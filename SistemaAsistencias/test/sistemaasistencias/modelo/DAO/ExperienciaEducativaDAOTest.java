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
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;

/**
 *
 * @author Panther
 */
public class ExperienciaEducativaDAOTest {
    
    public ExperienciaEducativaDAOTest() {
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
     * Test of obtenerHorarios method, of class ExperienciaEducativaDAO.
     */
    @Test
    public void testObtenerHorarios() throws Exception {
        System.out.println("obtenerHorarios");        
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        
        expResult.add(new ExperienciaEducativa("12355","Afrikaans","4:08","17:18","22:02","7:26","15:25","18:36","20:02"));
        expResult.add(new ExperienciaEducativa("15093","Tsonga","13:57","2:51","10:46","6:03","1:22","11:50","2:23"));
        expResult.add(new ExperienciaEducativa("38162","Swahili","23:15","8:05","18:07","4:33","14:07","0:00","3:51"));
        expResult.add(new ExperienciaEducativa("53561","Kyrgyz","7:24","5:09","3:43","16:49","11:51","0:44","22:09"));
        expResult.add(new ExperienciaEducativa("74666","Burmese","12:25","16:31","9:38","6:14","18:31","7:15","3:31"));
        expResult.add(new ExperienciaEducativa("90275","Haitian Creole","7:16","18:00","10:22","7:42","18:53","9:32","16:29"));
        
        ArrayList<ExperienciaEducativa> result = ExperienciaEducativaDAO.obtenerHorarios();
        assertEquals(expResult, result);
    }
    
}
