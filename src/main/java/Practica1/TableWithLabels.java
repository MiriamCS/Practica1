//package Practica1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    //atributos
    private final Map<String, Integer> labelsToIndex;
    //Constructor
    public TableWithLabels (){
        labelsToIndex = new HashMap<>();
    }
    public void creadorMapas(String etiqueta){
        if (!labelsToIndex.containsKey(etiqueta))
            labelsToIndex.put(etiqueta, labelsToIndex.size());
    }
}
