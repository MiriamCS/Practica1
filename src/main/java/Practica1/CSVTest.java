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
    void readTable() throws IOException {
        CSV csv1 = new CSV("Iris");
        Table tabla1 = csv1.readTable();
        assertEquals(150, tabla1.listaRows.size());
        assertEquals(4,tabla1.headers.size());
    }
}