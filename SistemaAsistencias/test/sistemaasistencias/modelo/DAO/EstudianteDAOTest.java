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
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.util.Constantes;

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
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarEstudiante() throws Exception {
        System.out.println("registrarEstudiante");
        Estudiante estudianteRegistro = new Estudiante();
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("oarnhold5");
        estudianteRegistro.setMatricula("s20015725");
        estudianteRegistro.setNombre("Kyle");
        estudianteRegistro.setApellidoPaterno("Perez");
        estudianteRegistro.setApellidodoMaterno("Martinez");
        estudianteRegistro.setUsuario(usuario);
        int expResult = Constantes.CODIGO_OPERACION_CORRECTA;
        int result = EstudianteDAO.registrarEstudiante(estudianteRegistro);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerEstudiantesPorEE method, of class EstudianteDAO.
     */
    @Test
    public void testObtenerEstudiantesPorEE() throws Exception {
        System.out.println("obtenerEstudiantesPorEE");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNrc("81709");
        
        Estudiante estudiante = new Estudiante();
        Estudiante estudiante1 = new Estudiante();
        
        estudiante.setNombre("Ottilie");
        estudiante.setApellidoPaterno("Haldon");
        estudiante.setApellidodoMaterno("Arnhold");
        estudiante.setMatricula("s39392865");
        
        estudiante1.setNombre("Inger");
        estudiante1.setApellidoPaterno("Chasier");
        estudiante1.setApellidodoMaterno("Fuentes");
        estudiante1.setMatricula("s52199398");
        
        ArrayList<Estudiante> expResult = new ArrayList<>();
        expResult.add(estudiante);
        expResult.add(estudiante1);
        ArrayList<Estudiante> result = EstudianteDAO.obtenerEstudiantesPorEE(experienciaEducativa);
        assertEquals(expResult, result);
    }
    
}
