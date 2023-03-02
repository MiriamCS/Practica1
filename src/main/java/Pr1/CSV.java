package Pr1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public CSV(){
        super();
    }

    public Table readTable(String nombreFichero) throws FileNotFoundException, IOException {
        //Leer los datos del fichero
        FileReader file = new FileReader(nombreFichero);
        BufferedReader buffer = new BufferedReader(file);
        String header= buffer.readLine();

        Table tabla = new Table();

        //Pone los headers a la tabla
        List<String> headers = creadorHeaders(header);
        tabla.addHeader(headers);
        //Crea los Rows
        List<Row> listaRow = new ArrayList<>();
        String cadena;
        while((cadena = buffer.readLine()) != null){
            Row linea = creadorRows(cadena);
            listaRow.add(linea);
        }
        //Pone los rows en la tabla
        tabla.addRows(listaRow);

        return tabla;

    }

    public TableWithLabels readTableLabels(String nombreFichero) throws FileNotFoundException, IOException {
        FileReader file = new FileReader(nombreFichero);
        BufferedReader buffer = new BufferedReader(file);
        //Lee las cabeceras
        String header= buffer.readLine();

        TableWithLabels tablaet = new TableWithLabels();

        List<String> headers = creadorHeaders(header);
        tablaet.addHeader(headers);

        List<RowWithLabel> listaRow = new ArrayList<>();
        String cadena;
        while((cadena = buffer.readLine()) != null){
            RowWithLabel linea = creadorRowsLabels(cadena, tablaet);
            listaRow.add(linea);
        }

        tablaet.addRowsLabels(listaRow);

        return tablaet;
    }
    private List<String> creadorHeaders(String header){
        String[] vectorHeaders = header.split(",");
        List<String> headers = new ArrayList<>();
        for (String elem : vectorHeaders){
            headers.add(elem);
        }
        return headers;
    }

    private Row creadorRows(String cadena){
        String[] vectorDatos  = cadena.split(",");
        List<Double> data = new ArrayList<>();
        for(int j = 0; j<vectorDatos.length; j++){
            Double num = Double.parseDouble(vectorDatos[j]);
            data.add(num);
        }
        Row linea = new Row(data);
        return linea;
    }
    private RowWithLabel creadorRowsLabels(String cadena, TableWithLabels tablaet){
        String[] vectorDatos  = cadena.split(",");
        List<Double> data = new ArrayList<>();
        for(int j = 0; j<vectorDatos.length -1; j++){
            Double num = Double.parseDouble(vectorDatos[j]);
            data.add(num);
        }
        String etiqueta = vectorDatos[vectorDatos.length - 1];

        int index = tablaet.creadorMapas(etiqueta);
        data.add((double) index);

        RowWithLabel linea = new RowWithLabel(data);
        return linea;
    }
}


