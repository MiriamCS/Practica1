package Practica1;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void readTableLabels() throws IOException {
        CSV csv1 = new CSV();
        // Table tabla1 = csv1.readTableLabels("C:\\Users\\al415634\\IdeaProjects\\Practica1\\src\\main\\java\\Practica1\\Iris");
        Table tabla1 = csv1.readTableLabels("C:\\Users\\Miriam\\IdeaProjects\\Practica1\\src\\main\\java\\Practica1\\Iris");
        assertEquals(150, tabla1.listaRows.size());
        assertEquals(4,tabla1.headers.size());

        assertTrue(tabla1.headers.get(0).equals("sepal length"));
        assertTrue(tabla1.headers.get(1).equals("sepal width"));
        assertTrue(tabla1.headers.get(2).equals("petal length"));
        assertTrue(tabla1.headers.get(3).equals("petal width"));




    }
}