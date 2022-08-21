package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.Profesor;
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
            PreparedStatement configurarConsulta = conexion.prepareStatement(consulta);
            configurarConsulta.setInt(1, profesorRegistro.getNumeroEmpleado());
            configurarConsulta.setString(2, profesorRegistro.getNombre());
            configurarConsulta.setString(3, profesorRegistro.getApellidoPaterno());
            configurarConsulta.setString(4, profesorRegistro.getApellidodoMaterno());
            configurarConsulta.setString(5, profesorRegistro.getUsuario().getNombreUsuario());
            int filasAfectadas = configurarConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
}
