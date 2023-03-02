package Pr1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{

    public List<RowWithLabel> listaRowsLabels;
    public Map<String, Integer> labelsToIndex;

    public TableWithLabels(){
        listaRowsLabels = new ArrayList<>();
        labelsToIndex = new HashMap<>();
    }

    public void addRowsLabels(List<RowWithLabel> lista){
        listaRowsLabels = lista;
    }

    public int creadorMapas(String etiqueta) {
        if (!labelsToIndex.containsKey(etiqueta)) {
            labelsToIndex.put(etiqueta, labelsToIndex.size());
        }
        return labelsToIndex.get(etiqueta);
    }
    @Override
    public RowWithLabel getRowAt(int rowNumber){
        return listaRowsLabels.get(rowNumber);
    }

}
