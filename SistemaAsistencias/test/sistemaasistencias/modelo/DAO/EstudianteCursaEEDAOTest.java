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
import sistemaasistencias.constantes.Constantes;

/**
 *
 * @author Panther
 */
public class EstudianteCursaEEDAOTest {
    
    public EstudianteCursaEEDAOTest() {
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
     * Test of obtenerExperienciaEducativaEstudiante method, of class EstudianteCursaEEDAO.
     */
    @Test
    public void testObtenerExperienciaEducativaEstudiante() throws SQLException {
        System.out.println("obtenerExperienciaEducativaEstudiante");
        String matricula = "s90611166";
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        expResult.add(new ExperienciaEducativa("15093","Tsonga","14:00","2:51","10:46","6:03","1:22","11:50","2:23"));
        ArrayList<ExperienciaEducativa> result = EstudianteCursaEEDAO.obtenerExperienciaEducativaEstudiante(matricula);
        System.out.println("Exp "+expResult+"\nRes "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarEnExperiencia method, of class EstudianteCursaEEDAO.
     */
    @Test
    public void testRegistrarEnExperiencia() throws SQLException {
        System.out.println("registrarEnExperiencia");
        String nrc = "15093";
        String matricula = "s39392865";
        int expResult = Constantes.CODIGO_OPERACION_CORRECTA;
        int result = EstudianteCursaEEDAO.registrarEnExperiencia(nrc, matricula);
        assertEquals(expResult, result);
    }
    
}
