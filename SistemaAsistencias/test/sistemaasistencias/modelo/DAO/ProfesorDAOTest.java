package sistemaasistencias.modelo.DAO;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.modelo.POJO.Profesor;
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class ProfesorDAOTest {
    
    public ProfesorDAOTest() {
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
     * Test of registrarProfesor method, of class ProfesorDAO.
     */
    @Test
    public void testRegistrarProfesor() throws SQLException {
        System.out.println("registrarProfesor");
        Profesor profesorRegistro = new Profesor();
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Paul");
        
        profesorRegistro.setNombre("Juan");
        profesorRegistro.setApellidoPaterno("Perez");
        profesorRegistro.setApellidodoMaterno("Marquez");
        profesorRegistro.setUsuario(usuario);
        int expResult = Constantes.CODIGO_OPERACION_CORRECTA;
        int result = ProfesorDAO.registrarProfesor(profesorRegistro);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerProfesorPorEE method, of class ProfesorDAO.
     * @throws java.sql.SQLException
     */
    @Test
    public void testObtenerProfesorPorEE() throws SQLException {
        System.out.println("obtenerProfesor");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNrc("12355");
        
        Profesor expResult = new Profesor();
        expResult.setNombreCompleto("Annabela Burchfield Millsap");
        Profesor result = ProfesorDAO.obtenerProfesorPorEE(experienciaEducativa);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerProfesor method, of class ProfesorDAO.
     */
    @Test
    public void testObtenerProfesor() throws SQLException {
        System.out.println("obtenerProfesor");
        String nombreUsuario = "Paul";
        Profesor expResult = new Profesor();
        expResult.setNombre("Juan");
        expResult.setApellidoPaterno("Perez");
        expResult.setApellidodoMaterno("Marquez");
        expResult.setNumeroEmpleado(0);
        Profesor result = ProfesorDAO.obtenerProfesor(nombreUsuario);
        assertEquals(expResult, result);
    }
    
}
