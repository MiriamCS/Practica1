package Practica1;


import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class KMeans {
    private long seed;
    private int numIterations;
    private int numClusters; //numero de grupos
    //Constructor
    public KMeans(int numClusters, int numIterations, long seed){
        this.seed=seed;
        this.numClusters=numClusters;
        this.numIterations=numIterations;
    }
    //método
    //public void train(TableWithLabels tabla){
    public void train(Table tabla){
        //Elegir aleatoriamente un semilla
        Set<Integer> coleccion = new HashSet<>();
        int i=0;
        while (i<numClusters){
            Random random =new Random(seed);
            //int aleatorio = random.nextInt(0, tabla.listaRowsLabels.size());
            int aleatorio = random.nextInt(0, tabla.listaRows.size());
            if(!coleccion.contains(aleatorio)){
                System.out.println(aleatorio);
                coleccion.add(aleatorio);
                i++;
                seed++;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        CSV csv1 = new CSV();
        TableWithLabels tabla = csv1.readTableLabels("src/main/java/files/Iris");
        KMeans km1 = new KMeans(3, 5, 415634);
        km1.train(tabla);
    }

}
