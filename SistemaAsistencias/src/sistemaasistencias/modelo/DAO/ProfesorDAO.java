package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaasistencias.modelo.ConexionBaseDeDatos;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.modelo.POJO.Profesor;
import sistemaasistencias.constantes.Constantes;

/**
 *
 * @author Panther
 */
public class ProfesorDAO {
    public static int registrarProfesor(Profesor profesorRegistro) throws SQLException{
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        int verificacionRegistro;
        String consulta = "INSERT INTO profesor values(?,?,?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setInt(1, profesorRegistro.getNumeroEmpleado());
            prepararConsulta.setString(2, profesorRegistro.getNombre());
            prepararConsulta.setString(3, profesorRegistro.getApellidoPaterno());
            prepararConsulta.setString(4, profesorRegistro.getApellidoMaterno());
            prepararConsulta.setString(5, profesorRegistro.getUsuario().getNombreUsuario());
            int filasAfectadas = prepararConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
    public static Profesor obtenerProfesorPorEE(ExperienciaEducativa experienciaEducativa) throws SQLException{
        Profesor profesorEncontrado = new Profesor();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT * FROM profesor " +
                        "INNER JOIN profesorimparteee " +
                        "ON profesor.numeroEmpleado = profesorimparteee.numeroEmpleado " +
                        "WHERE nrc = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta); 
            prepararConsulta.setString(1,experienciaEducativa.getNrc());
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();           
            if(resultadoConsulta.next()){
                profesorEncontrado.setNombreCompleto(resultadoConsulta.getString("nombre")+" "
                        +resultadoConsulta.getString("apellidoPaterno")+" "
                        +resultadoConsulta.getString("apellidoMaterno"));
            }else{
                profesorEncontrado = null;
            }
        }finally{
            dataBase.desconectar();
        }
        return profesorEncontrado;
    }
    public static Profesor obtenerProfesor(String nombreUsuario) throws SQLException{
        Profesor profesorEncontrado = new Profesor();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT * FROM profesor " +
                        "WHERE nombreUsuario = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta); 
            prepararConsulta.setString(1,nombreUsuario);
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();           
            if(resultadoConsulta.next()){
                profesorEncontrado.setNombre(resultadoConsulta.getString("nombre"));
                profesorEncontrado.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                profesorEncontrado.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                profesorEncontrado.setNumeroEmpleado(resultadoConsulta.getInt("numeroEmpleado"));
            }else{
                profesorEncontrado = null;
            }
        }finally{
            dataBase.desconectar();
        }
        return profesorEncontrado;
    }
}
