package Practica1;


import java.io.IOException;
import java.util.*;

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
        Set<Integer> representantes = new HashSet<>();
        int i=0;
        while (i<numClusters){
            Random random =new Random(seed);
            //int aleatorio = random.nextInt(0, tabla.listaRowsLabels.size());
            int aleatorio = random.nextInt(0, tabla.listaRows.size());
            if(!representantes.contains(aleatorio)){
                System.out.println(aleatorio);
                representantes.add(aleatorio);
                i++;
                seed++;
            }
        }
    }
    private List<List<Double>> obtenerDatos (Set representantes, Table tabla){
        List<List<Double>> repre = new ArrayList<>();
        for(Object elem : representantes){
            Row aux = tabla.getRowAt(elem);
            repre.add(aux.getData());
        }
        return repre;
    }
    public List<Double> asignacion (Set representantes, Table tabla){
        List<List<Double>> repre = obtenerDatos(representantes, tabla);
        KNN knn = new KNN();
        int j=0;
        while(j< repre.size()){
            for(int i =0; i<tabla.listaRows.size(); i++){
                knn.estimate(repre.get(j));
            }
            j++;
        }

    }

    public static void main(String[] args) throws IOException {
        CSV csv1 = new CSV();
        TableWithLabels tabla = csv1.readTableLabels("src/main/java/files/Iris");
        KMeans km1 = new KMeans(3, 5, 415634);
        km1.train(tabla);
    }

}
