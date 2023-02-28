package Practica1;

import java.util.ArrayList;
import java.util.List;
public class Table {
    public List<String> headers;
    public List<Row> listaRows;
    public Table(){
        headers = new ArrayList<>();
        listaRows = new ArrayList<>();
    }

    public void addRows(List<Row> lista){
        listaRows = lista;
    }
    public void addHeader(List<String> lista){
        headers = lista;
    }

    public Row getRowAt(int rowNumber){
        return listaRows.get(rowNumber);
    }

}
