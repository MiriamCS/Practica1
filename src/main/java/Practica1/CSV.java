package Practica1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public CSV(String nombreFichero){
        super();
        this.nombreFichero = nombreFichero;
    }
    private String nombreFichero;
    public Table readTable() throws FileNotFoundException, IOException {
        FileReader file = new FileReader(nombreFichero);
        BufferedReader buffer = new BufferedReader(file);
        String header= buffer.readLine();
        List<String> headers = creadorHeaders(header);
        List<Row> listaRow = new ArrayList<>();
        String cadena;
        while((cadena = buffer.readLine()) != null){
            Row linea = creadorRows(cadena);
            listaRow.add(linea);
        }
        Table tabla = new Table(headers, listaRow);
        return tabla;

    }

    public Table readTableLabels() throws FileNotFoundException, IOException {
        FileReader file = new FileReader(nombreFichero);
        BufferedReader buffer = new BufferedReader(file);
        String header= buffer.readLine();
        List<String> headers = creadorHeaders(header);
        headers.add("etiqueta");
        List<Row> listaRowLabels = new ArrayList<>();
        String cadena;
        while((cadena = buffer.readLine()) != null){
            RowWithLabel linea = creadorRowsLabels(cadena);
            listaRowLabels.add(linea);
            ///REVISA ESTO
            String etiqueta = linea[linea.])
            tablaet.creadorMapas(etiqueta);
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }
        TableWithLabels tablaet = new TableWithLabels(headers, listaRowLabels);
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
        for(int j = 0; j<vectorDatos.length -1; j++){
            Double num = Double.parseDouble(vectorDatos[j]);
            data.add(num);
        }
        Row linea = new Row(data);
        return linea;
    }
    private RowWithLabel creadorRowsLabels(String cadena){
        String[] vectorDatos  = cadena.split(",");
        List<String> data = new ArrayList<>();
        for(int j = 0; j<vectorDatos.length; j++){
            data.add(vectorDatos[j]);
        }
        RowWithLabel linea = new RowWithLabel(data);
        return linea;
    }
}
