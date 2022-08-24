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
public class AsistenciasDAOTest {
    
    public AsistenciasDAOTest() {
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
     * Test of obtenerHorarios method, of class AsistenciasDAO.
     */
    @Test
    public void testObtenerHorarios() throws SQLException {
        System.out.println("obtenerHorarios");
        String nrc = "12355";
        Asistencia asistencia = new Asistencia();
        asistencia.setNrc(nrc);
        asistencia.setEstudiante("Doyle"+" "+"Gerlts"+" "+"Healey");
        asistencia.setFecha("2022-08-22");
        ArrayList<Asistencia> expResult = new ArrayList<>();
        expResult.add(asistencia);
        ArrayList<Asistencia> result = AsistenciasDAO.obtenerHorarios(nrc);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
