/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaasistencias.modelo.DAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;

/**
 *
 * @author Panther
 */
public class EstudianteDAOTest {
    
    public EstudianteDAOTest() {
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
     * Test of registrarEstudiante method, of class EstudianteDAO.
     */
    @Test
    public void testRegistrarEstudiante() throws Exception {
        System.out.println("registrarEstudiante");
        Estudiante estudianteRegistro = null;
        int expResult = 0;
        int result = EstudianteDAO.registrarEstudiante(estudianteRegistro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerEstudiantesPorEE method, of class EstudianteDAO.
     */
    @Test
    public void testObtenerEstudiantesPorEE() throws Exception {
        System.out.println("obtenerEstudiantesPorEE");
        ExperienciaEducativa experienciaEducativa = null;
        ArrayList<Estudiante> expResult = null;
        ArrayList<Estudiante> result = EstudianteDAO.obtenerEstudiantesPorEE(experienciaEducativa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
