package Practica1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    CSV csv1 = new CSV();
    TableWithLabels tabla1 = csv1.readTableLabels("src/fichero/Iris");
    private final double[] s1 = {5.4,2.0,1.9,2.5}; //SAMPLE1
    private final double[] s2 = {4.5,3.0,4.8,1.2}; //SAMPLE1
    private final double[] s3 = {6.4,3.9,1.5,0.3}; //SAMPLE1
    private final double[] vect2 = {5.7,3.8,1.7,0.3,0.0}; //linea 18
    private final double[] vect3 = {5.3,3.7,1.5,0.2,0.0}; //linea 48
    private final double[] vect4 = {5.6,3.0,4.1,1.3,1.0}; //linea 88
    private final double[] vect5 = {0.0,0.0,0.0,0.0,0.0};
    private final List<Double> sample = new ArrayList<>();
    KNN knn1 = new KNN();
    List<Double> lista2 = new ArrayList<>();

    KNNTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void train() {
    }

    @Test
    void estimate() {
        knn1.train(tabla1);
        //prueba 1
        for (double elem: s1){sample.add(elem);}
        assertEquals(1,knn1.estimate(sample));
        sample.clear();
        //prueba 2
        for (double elem: s2){sample.add(elem);}
        assertEquals(2,knn1.estimate(sample));
        sample.clear();
        //prueba 3
        for (double elem: s3){sample.add(elem);}
        assertEquals(0,knn1.estimate(sample));
    }

    @Test
    void euclidea() {
        for (double elem: s1){sample.add(elem);}
        //prueba 1
        for (double elem: vect2){lista2.add(elem);}
        RowWithLabel prueba1 = new RowWithLabel(lista2);
        assertEquals(2.8653097563788807, knn1.euclidea(sample, prueba1));
        lista2.clear();
        //prueba 2
        for (double elem: vect3){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
        assertEquals(2.8896366553599777, knn1.euclidea(sample, prueba1));
        lista2.clear();
        //prueba 3
        for (double elem: vect4){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
        assertEquals(2.7055498516937364, knn1.euclidea(sample, prueba1));
        lista2.clear();
        //prueba 4: lista con ceros
        for (double elem: vect5){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
        assertEquals(6.558963332722634, knn1.euclidea(sample, prueba1));
        lista2.clear();
    }
}