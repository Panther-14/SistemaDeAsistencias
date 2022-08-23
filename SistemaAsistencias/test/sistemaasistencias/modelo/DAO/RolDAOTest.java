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
import sistemaasistencias.modelo.POJO.Rol;

/**
 *
 * @author Panther
 */
public class RolDAOTest {
    
    public RolDAOTest() {
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
     * Test of obtenerRoles method, of class RolDAO.
     */
    @Test
    public void testObtenerRoles() throws Exception {
        System.out.println("obtenerRoles");
        ArrayList<Rol> expResult = new ArrayList<>();
        Rol rol = new Rol();
        Rol rol1 = new Rol();
        
        rol.setIdRol(1);
        rol.setDescripcion("Profesor");
        
        rol1.setIdRol(2);
        rol1.setDescripcion("Estudiante");
        
        expResult.add(rol);
        expResult.add(rol1);
        
        ArrayList<Rol> result = RolDAO.obtenerRoles();
        assertEquals(expResult, result);
    }
    
}
