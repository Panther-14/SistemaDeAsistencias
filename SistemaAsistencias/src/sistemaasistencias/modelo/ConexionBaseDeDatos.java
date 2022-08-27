package sistemaasistencias.modelo;

import java.io.File;
import java.net.URL;
import java.nio.file.Path; 
import java.io.IOException;
import java.sql.Connection;
import java.nio.file.Paths; 
import java.util.Properties;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;

/**
 *
 * @author Panther
 */
public class ConexionBaseDeDatos {
    private Connection conexion;   
    private String direccionBD;
    private String usuario;
    private String contrasenia;
    
    public Connection getConexion() throws SQLException{
        conectar();
        return conexion;
    }
    
    public void desconectar() throws SQLException{
        if (conexion!=null){
            if (!conexion.isClosed()){
                conexion.close();
            }
        }
    }
    
    public void configurarArchivo(){
        try{
            Path CURRENT_FILE = Paths.get("");
            String directory = CURRENT_FILE.toAbsolutePath().toString();
            directory = Paths.get(directory, "src", "sistemaasistencias", "modelo", "BaseDeDatosConfig.txt").toString();
            URL url = new File(directory).toURI().toURL();
            FileInputStream archivoConfiguracion = new FileInputStream(new File(url.getPath()));
            Properties atributos = new Properties();
            atributos.load(archivoConfiguracion);
            archivoConfiguracion.close();
            Class.forName("java.sql.Driver");
            this.direccionBD = atributos.getProperty("DireccionBD");
            this.usuario = atributos.getProperty("Usuario");
            this.contrasenia = atributos.getProperty("Contrasenia");
        }catch (FileNotFoundException fnfException) {
            Logger.getLogger(ConexionBaseDeDatos.class.getName()).log(Level.SEVERE, null, fnfException);
        } catch (IOException ioException){
            Logger.getLogger(ConexionBaseDeDatos.class.getName()).log(Level.SEVERE, null, ioException);
        } catch (ClassNotFoundException cnfException) {
            Logger.getLogger(ConexionBaseDeDatos.class.getName()).log(Level.SEVERE, null, cnfException);
        }
    }
    
    public void conectar() throws SQLException {
        configurarArchivo();
        conexion = DriverManager.getConnection(direccionBD, usuario, contrasenia);
    }
    
}
