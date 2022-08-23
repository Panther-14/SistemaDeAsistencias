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
import sistemaasistencias.modelo.POJO.Rol;
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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
     * Test of iniciarSesion method, of class UsuarioDAO.
     */
    @Test
    public void testIniciarSesion() throws Exception {
        System.out.println("iniciarSesion");
        String nombreUsuario = "wcartmill3";
        String contrasenia = "123";
        
        Usuario expResult = new Usuario();
        expResult.setNombreUsuario(nombreUsuario);
        expResult.setContrasenia(null);
        expResult.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
        Rol rol = new Rol();
        rol.setIdRol(2);
        rol.setDescripcion("Estudiante");
        expResult.setRol(rol);
        
        Usuario result = UsuarioDAO.iniciarSesion(nombreUsuario, contrasenia);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testRegistrarUsuario() throws Exception {
        System.out.println("registrarUsuario");
        Usuario usuarioRegistro = new Usuario();
        usuarioRegistro.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
        usuarioRegistro.setNombreUsuario("Panther");
        usuarioRegistro.setContrasenia("123");
        Rol rol = new Rol();
        rol.setIdRol(2);
        rol.setDescripcion("Estudiante");
        usuarioRegistro.setRol(rol);
        int expResult = Constantes.CODIGO_OPERACION_CORRECTA;
        int result = UsuarioDAO.registrarUsuario(usuarioRegistro);
        assertEquals(expResult, result);
    }
    
}
