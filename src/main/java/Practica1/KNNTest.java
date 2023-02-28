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
    TableWithLabels tabla1 = csv1.readTableLabels("C:\\Users\\Miriam\\IdeaProjects\\Practica1\\src\\main\\java\\Practica1\\Iris");

    private RowWithLabel prueba1;
    private double[] vect1 = {4.4,2.9,1.4,0.2}; //linea 8
    private double[] vect2 = {5.7,3.8,1.7,0.3}; //linea 18
    private List<Double> sample;
    private List<Double> lista2;

    KNNTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        for (double elem: vect1){sample.add(elem);}
        for (double elem: vect2){lista2.add(elem);}
        prueba1 = new RowWithLabel(lista2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void train() {
    }

    @Test
    void estimate() {
    }

    @Test
    void euclidea() {
        KNN knn1 = new KNN();
        assertEquals(4, knn1.euclidea(sample, prueba1));
    }
}