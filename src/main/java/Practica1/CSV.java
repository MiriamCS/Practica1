//package Practica1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSV {
    //atributos
    private static Set<String> etiquetasLista;
    //Constructor
    public CSV(){
        super();
        etiquetasLista=new HashSet<>();
    }
    //Leer los datos del fichero
    public Table readTable(String nombreFichero) throws FileNotFoundException, IOException {
        FileReader file = new FileReader(nombreFichero);
        BufferedReader buffer = new BufferedReader(file);
        //Lee las etiquetas
        String header= buffer.readLine();
        List<String> headers = creadorHeaders(header);
        //Lee el contenido del fichero
        List<Row> listaRow = new ArrayList<>();
        String cadena;
        while((cadena = buffer.readLine()) != null){
            Row linea = creadorRows(cadena, headers);
            listaRow.add(linea);
        }
        //Mete los contenidos en la tabla Table
        Table tabla = new Table(headers, listaRow);
        return tabla;

    }
    //Mete las etiquetas en un vector
    private List<String> creadorHeaders(String header){
        String[] vectorHeaders = header.split(",");
        List<String> headers = new ArrayList<>();
        for (String elem : vectorHeaders){
            headers.add(elem);
        }
        return headers;
    }
    //Mete el contenido
    private Row creadorRows(String cadena, List<String> headers){
        String[] vectorDatos  = cadena.split(",");
        List<Double> data = new ArrayList<>();
        for(int j = 0; j<vectorDatos.length -1; j++){
            Double num = Double.parseDouble(vectorDatos[j]);
            data.add(num);
        }
        //Extrae la etiqueta de la última columna
        String etiqueta = vectorDatos[vectorDatos.length -1];
        Row linea = new Row(data);
        TableWithLabels mapa = new TableWithLabels();
        if(!etiquetasLista.contains(etiqueta)){
            etiquetasLista.add(etiqueta);
            mapa.creadorMapas(etiqueta);
        }
        return linea;
    }
}
