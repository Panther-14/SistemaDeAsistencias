package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaasistencias.modelo.ConexionBaseDeDatos;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;

/**
 *
 * @author Panther
 */
public class ExperienciaEducativaDAO {
    public static ArrayList<ExperienciaEducativa> obtenerHorarios() throws SQLException{
        ArrayList<ExperienciaEducativa> listaEEHorarios = new ArrayList<>();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT * FROM experienciaeducativa WHERE activa = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setInt(1, 1);
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
                listaEEHorarios.add(experienciaEducativaTemp);
            }
        } finally {
            dataBase.desconectar();
        }
        return listaEEHorarios;
    }
}
