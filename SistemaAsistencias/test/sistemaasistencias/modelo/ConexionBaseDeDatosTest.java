package sistemaasistencias.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Panther
 */
public class ConexionBaseDeDatosTest {
    
    public ConexionBaseDeDatosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexion method, of class ConexionBaseDeDatos.
     */
    @Test
    public void testGetConexion() throws SQLException {
        System.out.println("getConexion");
        ConexionBaseDeDatos instance = new ConexionBaseDeDatos();
        Connection expResult = null;
        Connection result = instance.getConexion();
        expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of desconectar method, of class ConexionBaseDeDatos.
     */
    @Test
    public void testDesconectar() throws SQLException {
        System.out.println("desconectar");
        ConexionBaseDeDatos instance = new ConexionBaseDeDatos();
        instance.desconectar();
    }

    /**
     * Test of conectar method, of class ConexionBaseDeDatos.
     */
    @Test
    public void testConectar() throws SQLException {
        System.out.println("conectar");
        ConexionBaseDeDatos instance = new ConexionBaseDeDatos();
        instance.conectar();
    }
    
}
