package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaasistencias.modelo.ConexionBaseDeDatos;
import sistemaasistencias.modelo.POJO.Asistencia;

/**
 *
 * @author Panther
 */
public class AsistenciaDAO {
    public static ArrayList<Asistencia> obtenerAsistentes(String nrc) throws SQLException{
        ArrayList<Asistencia> listaEEHorarios = new ArrayList<>();
        ConexionBaseDeDatos dataBase = new ConexionBaseDeDatos();
        String consulta = "SELECT estudiante.nombre,estudiante.apellidoPaterno,estudiante.apellidoMaterno,fecha,asistencias.nrc " +
                "FROM sistemaasistencias.asistencias " +
                "INNER JOIN estudiante " +
                "ON asistencias.matricula = estudiante.matricula " +
                "WHERE nrc = ? AND asistencia = 1;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, nrc);
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();
            while(resultadoConsulta.next()){
                Asistencia asistenciaTemp = new Asistencia();                
                asistenciaTemp.setNrc(resultadoConsulta.getString("nrc"));
                asistenciaTemp.setFecha(resultadoConsulta.getString("fecha"));
                asistenciaTemp.setNombreEstudiante(resultadoConsulta.getString("nombre")+
                        " "+resultadoConsulta.getString("apellidoPaterno")+
                        " "+resultadoConsulta.getString("apellidoMaterno"));
                listaEEHorarios.add(asistenciaTemp);
            }
        } finally {
            dataBase.desconectar();
        }
        return listaEEHorarios;
    }
}
