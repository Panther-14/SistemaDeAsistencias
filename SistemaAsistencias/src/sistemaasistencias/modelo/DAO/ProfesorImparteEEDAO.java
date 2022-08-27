package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaasistencias.modelo.ConexionBaseDeDatos;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.constantes.Constantes;

/**
 *
 * @author Panther
 */
public class ProfesorImparteEEDAO {
    public static ArrayList<ExperienciaEducativa> obtenerExperienciaEducativaProfesor(int numeroEmpleado) throws SQLException{
        ArrayList<ExperienciaEducativa> listaEEEstudiante = new ArrayList<>();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT experienciaeducativa.* FROM experienciaeducativa " +
                            "INNER JOIN profesorimparteee " +
                            "ON profesorimparteee.nrc = experienciaeducativa.nrc " +
                            "WHERE activa = ? AND numeroEmpleado = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setInt(1, 1);
            prepararConsulta.setInt(2, numeroEmpleado);
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();
            while(resultadoConsulta.next()){
                ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                experienciaEducativaTemp.setNrc(resultadoConsulta.getString("nrc"));
                experienciaEducativaTemp.setNombreEE(resultadoConsulta.getString("nombreEE"));
                experienciaEducativaTemp.setLunes(resultadoConsulta.getString("lunes"));
                experienciaEducativaTemp.setMartes(resultadoConsulta.getString("martes"));
                experienciaEducativaTemp.setMiercoles(resultadoConsulta.getString("miercoles"));
                experienciaEducativaTemp.setJueves(resultadoConsulta.getString("jueves"));
                experienciaEducativaTemp.setViernes(resultadoConsulta.getString("viernes"));
                experienciaEducativaTemp.setSabado(resultadoConsulta.getString("sabado"));
                experienciaEducativaTemp.setDomingo(resultadoConsulta.getString("domingo"));
                listaEEEstudiante.add(experienciaEducativaTemp);
            }
        } finally {
            dataBase.desconectar();
        }
        return listaEEEstudiante;
    }
    public static int registrarEnExperiencia(String nrc, int numeroEmpleado) throws SQLException{
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        int verificacionRegistro;
        String consulta = "INSERT INTO profesorimparteee (nrc,numeroEmpleado) values(?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, nrc);
            prepararConsulta.setInt(2, numeroEmpleado);
            int filasAfectadas = prepararConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
}
