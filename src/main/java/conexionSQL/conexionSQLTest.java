package conexionSQL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class conexionSQLTest {

    private conexionSQL sqlUser;
    @BeforeEach
    void setUp() {
        sqlUser = new conexionSQL();
    }
    @Test
    void conexion() {
        assertNotNull(sqlUser.conexion());
    }

    @AfterEach
    void tearDown() {
    }


}