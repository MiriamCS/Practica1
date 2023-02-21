package Practica1;

import java.util.List;
public class Table {
    private List<String> headers;
    private List<Row> listaRows;
    public Table(List<String> headers, List<Row> listaRows){
        this.headers = headers;
        this.listaRows = listaRows;
    }

    public Row getRowAt(int rowNumber){
        return listaRows.get(rowNumber);
    }
}
