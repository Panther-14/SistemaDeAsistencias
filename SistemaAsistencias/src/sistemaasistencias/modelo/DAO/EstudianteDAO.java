package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class EstudianteDAO {
    public static int registrarProfesor(Estudiante estudianteRegistro) throws SQLException{
        DataBaseConnection dataBase = new DataBaseConnection();
        int verificacionRegistro;
        String consulta = "INSERT INTO estudiante values(?,?,?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement configurarConsulta = conexion.prepareStatement(consulta);
            configurarConsulta.setString(1, estudianteRegistro.getMatricula());
            configurarConsulta.setString(2, estudianteRegistro.getNombre());
            configurarConsulta.setString(3, estudianteRegistro.getApellidoPaterno());
            configurarConsulta.setString(4, estudianteRegistro.getApellidodoMaterno());
            configurarConsulta.setString(5, estudianteRegistro.getUsuario().getNombreUsuario());
            int filasAfectadas = configurarConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
}
