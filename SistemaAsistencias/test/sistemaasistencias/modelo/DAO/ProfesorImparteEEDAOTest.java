/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package sistemaasistencias.modelo.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class ProfesorImparteEEDAOTest {
    
    public ProfesorImparteEEDAOTest() {
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
     * Test of obtenerExperienciaEducativaProfesor method, of class ProfesorImparteEEDAO.
     */
    @Test
    public void testObtenerExperienciaEducativaProfesor() throws SQLException {
        System.out.println("obtenerExperienciaEducativaProfesor");
        int numeroEmpleado = 0;
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        ArrayList<ExperienciaEducativa> result = ProfesorImparteEEDAO.obtenerExperienciaEducativaProfesor(numeroEmpleado);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarEnExperiencia method, of class ProfesorImparteEEDAO.
     */
    @Test
    public void testRegistrarEnExperiencia() throws SQLException {
        System.out.println("registrarEnExperiencia");
        String nrc = "12355";
        int numeroEmpleado = 0;
        int expResult = Constantes.CODIGO_OPERACION_CORRECTA;
        int result = ProfesorImparteEEDAO.registrarEnExperiencia(nrc, numeroEmpleado);
        assertEquals(expResult, result);
    }
    
}
