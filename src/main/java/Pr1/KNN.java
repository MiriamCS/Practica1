package Pr1;

import java.util.List;

public class KNN {
    //IMPLEMENTACIÓN DEL ALGORITMO KNN
    private List<RowWithLabel> listaRowsLabels;

    public void train(TableWithLabels data) {
        listaRowsLabels = data.listaRowsLabels;
    }
    public Integer estimate(List<Double> sample){
        int closestIndex = -1; //Indica el indice más cercano
        double menor = Double.POSITIVE_INFINITY; //Definimos un menor infinito para no dar distancia menor que la del mínimo
        //recorrer los rows para encontrar la menor euclidea
        for (int i = 0; i < listaRowsLabels.size(); i++) {
            RowWithLabel rowWithLabel = listaRowsLabels.get(i);

            double d_euclidea = euclidea(sample, rowWithLabel);
            //guardar el índice del menor euclidea
            if(d_euclidea<menor){
                menor = d_euclidea;
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
