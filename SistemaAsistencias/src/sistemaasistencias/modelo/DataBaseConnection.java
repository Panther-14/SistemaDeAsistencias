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
public class DataBaseConnection {
    private Connection conexion;   
    
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
    
    public void conectar() throws SQLException {
        try{
            Path CURRENT_FILE = Paths.get("");
            String directory = CURRENT_FILE.toAbsolutePath().toString();
            directory = Paths.get(directory, "src", "proyectoconstruccion", "modelo", "dbconfig.txt").toString();
            System.err.println("File directory is " + directory); // err for debbug
            URL url = new File(directory).toURI().toURL();
            FileInputStream archivoConfiguracion = new FileInputStream(new File(url.getPath()));
            Properties atributos = new Properties();
            atributos.load(archivoConfiguracion);
            archivoConfiguracion.close();
            Class.forName("java.sql.Driver");
            String direccionBD = atributos.getProperty("DireccionBD");
            String usuario = atributos.getProperty("Usuario");
            String contrasenia = atributos.getProperty("Contrasenia");
            conexion = DriverManager.getConnection(direccionBD, usuario, contrasenia);
        }catch (FileNotFoundException fnfException) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, fnfException);
        } catch (IOException ioException){
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ioException);
        } catch (ClassNotFoundException cnfException) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, cnfException);
        } 
        /*catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;*/
    }
    
}
