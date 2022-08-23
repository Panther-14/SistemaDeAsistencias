package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class EstudianteDAO {
    public static int registrarEstudiante(Estudiante estudianteRegistro) throws SQLException{
        DataBaseConnection dataBase = new DataBaseConnection();
        int verificacionRegistro;
        String consulta = "INSERT INTO estudiante values(?,?,?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, estudianteRegistro.getMatricula());
            prepararConsulta.setString(2, estudianteRegistro.getNombre());
            prepararConsulta.setString(3, estudianteRegistro.getApellidoPaterno());
            prepararConsulta.setString(4, estudianteRegistro.getApellidodoMaterno());
            prepararConsulta.setString(5, estudianteRegistro.getUsuario().getNombreUsuario());
            int filasAfectadas = prepararConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
    public static ArrayList<Estudiante> obtenerEstudiantesPorEE(ExperienciaEducativa experienciaEducativa)throws SQLException{
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT estudiante.* FROM estudiante\n" +
                        "INNER JOIN estudiantecursaee\n" +
                        "ON estudiante.matricula = estudiantecursaee.matricula\n" +
                        "INNER JOIN experienciaeducativa\n" +
                        "ON experienciaeducativa.nrc = estudiantecursaee.nrc\n" +
                        "WHERE experienciaeducativa.nrc = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, experienciaEducativa.getNrc());
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();
            while(resultadoConsulta.next()){
                Estudiante estudianteTemp = new Estudiante();
                estudianteTemp.setNombre(resultadoConsulta.getString("nombre"));
                estudianteTemp.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                estudianteTemp.setApellidodoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                estudianteTemp.setMatricula(resultadoConsulta.getString("matricula"));
                listaEstudiantes.add(estudianteTemp);
            }
        } finally {
            dataBase.desconectar();
        }
        return listaEstudiantes;
    }
}
