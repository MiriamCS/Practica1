package Practica1;

import java.util.List;
import java.util.Map;

public class KNN {
    //IMPLEMENTACIÓN DEL ALGORITMO KNN
    private List<RowWithLabel> listaRowsLabels;
    //private Map<String, Integer> labelsToIndex;

    public void train(TableWithLabels data) {
        listaRowsLabels = data.listaRowsLabels;
       //labelsToIndex = data.labelsToIndex;
    }
    public Integer estimate(List<Double> sample){
        //Por cada row, conseguir data
        //Comparar data con data sample mediante euclidea
        //Guardar la euclidea menor
        //Devolver el tipo de iris (index de etiqueta) de el row de euclidea menor
        int closestIndex = -1;
        double mayor = Double.POSITIVE_INFINITY;
        double closestDistance = 2.6;

        for (int i = 0; i < listaRowsLabels.size(); i++) {
            RowWithLabel rowWithLabel = listaRowsLabels.get(i);

            double d_euclidea = euclidea(sample, rowWithLabel);

            if (d_euclidea < closestDistance) {
                closestIndex = i;
                closestDistance = d_euclidea;
            }else if(d_euclidea<mayor){
                mayor = d_euclidea;
                closestIndex = i;
            }
        }

        return listaRowsLabels.get(closestIndex).getNumeroClase();
    }

    public double euclidea(List<Double> sample,RowWithLabel rowWithLabel){
        double deuclidea = 0;

        for (int j = 0; j < rowWithLabel.getData().size()-1; j++) {
            double diferencia = Math.pow((sample.get(j) - rowWithLabel.getData().get(j)),2);
            deuclidea += diferencia;
        }

        return Math.sqrt(deuclidea);
    }

}
