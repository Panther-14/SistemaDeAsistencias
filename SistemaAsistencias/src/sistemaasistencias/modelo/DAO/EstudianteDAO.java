package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaasistencias.modelo.ConexionBaseDeDatos;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.constantes.Constantes;

/**
 *
 * @author Panther
 */
public class EstudianteDAO {
    public static int registrarEstudiante(Estudiante estudianteRegistro) throws SQLException{
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        int verificacionRegistro;
        String consulta = "INSERT INTO estudiante values(?,?,?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, estudianteRegistro.getMatricula());
            prepararConsulta.setString(2, estudianteRegistro.getNombre());
            prepararConsulta.setString(3, estudianteRegistro.getApellidoPaterno());
            prepararConsulta.setString(4, estudianteRegistro.getApellidoMaterno());
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
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT estudiante.* FROM estudiante " +
                        "INNER JOIN estudiantecursaee " +
                        "ON estudiante.matricula = estudiantecursaee.matricula " +
                        "INNER JOIN experienciaeducativa " +
                        "ON experienciaeducativa.nrc = estudiantecursaee.nrc " +
                        "WHERE experienciaeducativa.nrc = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, experienciaEducativa.getNrc());
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();
            while(resultadoConsulta.next()){
                Estudiante estudianteTemp = new Estudiante();
                estudianteTemp.setNombre(resultadoConsulta.getString("nombre"));
                estudianteTemp.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                estudianteTemp.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                estudianteTemp.setMatricula(resultadoConsulta.getString("matricula"));
                listaEstudiantes.add(estudianteTemp);
            }
        } finally {
            dataBase.desconectar();
        }
        return listaEstudiantes;
    }
    public static Estudiante obtenerEstudiante(String nombreUsuario)throws SQLException{
        Estudiante estudiante = new Estudiante();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT * FROM estudiante " +
                        "WHERE nombreUsuario = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, nombreUsuario);
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();
            if(resultadoConsulta.next()){
                estudiante.setNombre(resultadoConsulta.getString("nombre"));
                estudiante.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                estudiante.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                estudiante.setMatricula(resultadoConsulta.getString("matricula"));
            }
        } finally {
            dataBase.desconectar();
        }
        return estudiante;
    }
}
