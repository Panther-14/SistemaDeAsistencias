package sistemaasistencias.modelo.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistemaasistencias.modelo.POJO.Asistencia;

/**
 *
 * @author Panther
 */
public class AsistenciaDAOTest {
    
    public AsistenciaDAOTest() {
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
     * Test of obtenerAsistentes method, of class AsistenciaDAO.
     */
    @Test
    public void testObtenerAsistentes() throws SQLException {
        System.out.println("obtenerAsistentes");
        String nrc = "12355";
        Asistencia asistencia = new Asistencia();
        asistencia.setNrc(nrc);
        asistencia.setNombreEstudiante("Doyle"+" "+"Gerlts"+" "+"Healey");
        asistencia.setFecha("2022-08-22");
        ArrayList<Asistencia> expResult = new ArrayList<>();
        expResult.add(asistencia);
        ArrayList<Asistencia> result = AsistenciaDAO.obtenerAsistentes(nrc);
        assertEquals(expResult, result);
    }
    
}
