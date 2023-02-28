//package Practica1;

import java.util.List;
public class Table {
    public List<String> headers;
    public List<Row> listaRows;
    public Table(List<String> headers, List<Row> listaRows){
        this.headers = headers;
        this.listaRows = listaRows;
    }
    //Constructor vacio
    public Table(){
        super();
    }

    public Row getRowAt(int rowNumber){
        return listaRows.get(rowNumber);
    }
}
