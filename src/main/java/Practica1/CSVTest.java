//package Practica1;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    private String[] etiquetas={"sepal length","sepal width","petal length","petal width","class"};
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
        //Comprobar que las líneas leidas son correctas
        assertEquals(150, tabla.listaRows.size());
        //Comprobar que el número de columnas es correcto
        assertEquals(5,tabla.headers.size());
        //Comprobar que las etiquetas son correctas
        for(int i=0;i<etiquetas.length;i++){
            assertEquals(etiquetas[i],tabla.headers.get(i));
        }

    }
}