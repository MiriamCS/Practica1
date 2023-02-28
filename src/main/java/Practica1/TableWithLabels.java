package Practica1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{

    public List<Row> listaRowsLabels;
    private static Map<String, Integer> labelsToIndex;

    public TableWithLabels(){
        labelsToIndex = new HashMap<>();
    }

    public void addRows(List<Row> lista){
        listaRowsLabels = lista;
        labelsToIndex = new HashMap<>();
    }

    public void creadorMapas(String etiqueta) {
        if (!labelsToIndex.containsKey(etiqueta))
            labelsToIndex.put(etiqueta, labelsToIndex.size());
    }

}
