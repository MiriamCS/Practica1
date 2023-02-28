package Practica1;

import java.util.List;

public class RowWithLabel extends Row{

    private int numeroClase;
    private List<Double> data;

    public RowWithLabel(List<String> data) {
        this.data= data;
    }

    public int getNumeroClase() {
        return numeroClase;
    }
}
