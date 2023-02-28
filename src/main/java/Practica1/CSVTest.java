//package Practica1;

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
    void readTable() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable("C:\\Users\\al415673\\IdeaProjects\\Practica1\\src\\main\\java\\Practica1\\Iris.txt");
        assertEquals(150, tabla.listaRows.size());
        assertEquals(5,tabla.headers.size());
    }
}