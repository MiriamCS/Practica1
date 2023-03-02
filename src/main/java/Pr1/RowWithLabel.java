package Pr1;

import java.util.List;

public class RowWithLabel extends Row{

    private int numeroClase;

    public RowWithLabel(List<Double> data) {
        super(data);
        double num = data.get(data.size()-1);
        numeroClase = (int) num;
    }

    public int getNumeroClase() {
        return numeroClase;
    }
}
