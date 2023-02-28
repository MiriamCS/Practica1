//package Practica1;

import java.util.List;

public class Row {
    //atributos
    private List<Double> data;
    //Constructor de la clase Row
    public Row(List <Double> data){
        this.data = data;
    }
    //Método getData()
    public List<Double> getData(){
        return this.data;
    }
}
