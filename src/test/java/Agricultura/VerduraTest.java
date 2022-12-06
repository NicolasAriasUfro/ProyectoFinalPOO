package Agricultura;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerduraTest {
    static Verdura verdura;

    @BeforeAll
    static void setUp() {
        verdura = new Verdura(245, "Tomate", 40, 40, "200");

    }
    @Test
    void toSQlTest(){
        String expected = "(nombre,ancho,largo,crecimiento) values (Tomate,40,40,200)";
        String recibed = verdura.toQuery();
        assertEquals(expected,recibed);
        }

}