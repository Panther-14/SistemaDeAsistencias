/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
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
public class EstudianteCursaEEDAO {
    public static ArrayList<ExperienciaEducativa> obtenerExperienciaEducativaEstudiante(String matricula) throws SQLException{
        ArrayList<ExperienciaEducativa> listaEEEstudiante = new ArrayList<>();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT experienciaeducativa.* FROM experienciaeducativa " +
                        "INNER JOIN estudiantecursaee " +
                        "ON estudiantecursaee.nrc = experienciaeducativa.nrc " +
                        "WHERE activa = ? AND matricula = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setInt(1, 1);
            prepararConsulta.setString(2, matricula);
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
    public static int registrarEnExperiencia(String nrc, String matricula) throws SQLException{
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        int verificacionRegistro;
        String consulta = "INSERT INTO estudiantecursaee (nrc,matricula) values(?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, nrc);
            prepararConsulta.setString(2, matricula);
            int filasAfectadas = prepararConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
}
