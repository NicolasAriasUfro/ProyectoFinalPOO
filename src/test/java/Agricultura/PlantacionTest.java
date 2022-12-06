package Agricultura;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantacionTest {
    Plantacion plantacion;

    @BeforeEach
    void setUp() {
        plantacion = new Plantacion(217,100,100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toQuery() {
        String expected = "(id_plantacion,ancho,largo,) values (217,100,100)";
        String recibed = plantacion.toQuery();
        assertEquals(expected,recibed);

    }
}