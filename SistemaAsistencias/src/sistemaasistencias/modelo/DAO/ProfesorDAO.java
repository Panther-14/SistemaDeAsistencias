package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import passwordencryptor.SHA_512;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.modelo.POJO.Profesor;
import sistemaasistencias.modelo.POJO.Rol;
import sistemaasistencias.modelo.POJO.Usuario;
import static sistemaasistencias.modelo.POJO.Usuario.usuarioLogin;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class ProfesorDAO {
    public static int registrarProfesor(Profesor profesorRegistro) throws SQLException{
        DataBaseConnection dataBase = new DataBaseConnection();
        int verificacionRegistro;
        String consulta = "INSERT INTO profesor values(?,?,?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setInt(1, profesorRegistro.getNumeroEmpleado());
            prepararConsulta.setString(2, profesorRegistro.getNombre());
            prepararConsulta.setString(3, profesorRegistro.getApellidoPaterno());
            prepararConsulta.setString(4, profesorRegistro.getApellidodoMaterno());
            prepararConsulta.setString(5, profesorRegistro.getUsuario().getNombreUsuario());
            int filasAfectadas = prepararConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
    public static Profesor obtenerProfesor(ExperienciaEducativa experienciaEducativa) throws SQLException{
        Profesor profesorEncontrado = new Profesor();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT * FROM profesor\n" +
                        "INNER JOIN profesorimparteee\n" +
                        "ON profesor.numeroEmpleado = profesorimparteee.numeroEmpleado\n" +
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
            }
        }finally{
            dataBase.desconectar();
        }
        return profesorEncontrado;
    }
}
