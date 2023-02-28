package Practica1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private static Map<String, Integer> labelsToIndex;
    public TableWithLabels(List<String> headers, List<Row> listaRows) {
        super(headers, listaRows);
        labelsToIndex = new HashMap<>();
    }
    public static void creadorMapas(String etiqueta){
        if (!labelsToIndex.containsKey(etiqueta))
            labelsToIndex.put(etiqueta, labelsToIndex.size());
    }
}
