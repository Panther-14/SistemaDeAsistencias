/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaasistencias.modelo.DAO;

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
    public void testRegistrarProfesor() throws Exception {
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
     * Test of obtenerProfesor method, of class ProfesorDAO.
     */
    @Test
    public void testObtenerProfesor() throws Exception {
        System.out.println("obtenerProfesor");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNrc("12355");
        
        Profesor expResult = new Profesor();
        expResult.setNombreCompleto("Annabela Burchfield Millsap");
        Profesor result = ProfesorDAO.obtenerProfesor(experienciaEducativa);
        assertEquals(expResult, result);
    }
    
}
