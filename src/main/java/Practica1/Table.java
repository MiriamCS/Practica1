package Practica1;

import java.util.List;
public class Table {
    private List<String> headers;
    private List<Row> listaRows;
    private Table(){
        super();
    }

    public Row getRowAt(int rowNumber){
        return listaRows.get(rowNumber);
    }
}
