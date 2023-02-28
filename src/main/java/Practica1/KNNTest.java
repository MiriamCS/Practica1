package Practica1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    CSV csv1 = new CSV();
    TableWithLabels tabla1 = csv1.readTableLabels("C:\\Users\\leiru\\Documents\\Universidad\\2nd año\\2nd semestre\\Programacion\\Practica1\\src\\main\\java\\Practica1\\Iris");
    //TableWithLabels tabla1 = csv1.readTableLabels("C:\\Users\\leiru\\Documents\\Universidad\\2nd año\\2nd semestre\\Programacion\\Practica1\\src\\main\\java\\Practica1\\prueba2");
    private final double[] vect1 = {4.4,2.9,1.4,0.2,0.0}; //linea 8
    private final double[] vect2 = {5.7,3.8,1.7,0.3,0.0}; //linea 18
    private final double[] vect3 = {5.3,3.7,1.5,0.2,0.0}; //linea 48
    private final double[] vect4 = {5.6,3.0,4.1,1.3,1.0}; //linea 88
    private final double[] vect5 = {0.0,0.0,0.0,0.0,0.0};
    private final double[] vect6 = {6.4,2.8,5.6,2.1,2.0}; //linea 128
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
        for (double elem: vect1){sample.add(elem);}
        assertEquals(0,knn1.estimate(sample));
        //prueba 2
        for (double elem: vect4){sample.add(elem);}
        assertEquals(0,knn1.estimate(sample));
        //prueba 3
        for (double elem: vect6){sample.add(elem);}
        assertEquals(0,knn1.estimate(sample));
    }

    @Test
    void euclidea() {
        for (double elem: vect1){sample.add(elem);}
        //prueba 1
        for (double elem: vect2){lista2.add(elem);}
        RowWithLabel prueba1 = new RowWithLabel(lista2);
        assertEquals(1.6124515496597096, knn1.euclidea(sample, prueba1));
        lista2.clear();
        //prueba 2
        for (double elem: vect3){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
        assertEquals(1.208304597359457, knn1.euclidea(sample, prueba1));
        lista2.clear();
        //prueba 3
        for (double elem: vect4){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
        assertEquals(3.1543620591175006, knn1.euclidea(sample, prueba1));
        lista2.clear();
        //prueba 4: lista con ceros
        for (double elem: vect5){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
        assertEquals(5.456189146281496, knn1.euclidea(sample, prueba1));
        lista2.clear();
    }
}