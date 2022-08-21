package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.Rol;

/**
 *
 * @author Panther
 */
public class RolDAO {
    public static ArrayList<Rol> obtenerRoles() throws SQLException{
        ArrayList<Rol> listaRoles = new ArrayList<Rol>();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT * FROM rol;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();
            while(resultadoConsulta.next()){
                Rol rolEncontrados = new Rol();             
                rolEncontrados.setIdRol(resultadoConsulta.getInt("idRol"));
                rolEncontrados.setDescripcion(resultadoConsulta.getString("descripcion"));
                listaRoles.add(rolEncontrados);
            }
        } finally {
            dataBase.desconectar();
        }
        return listaRoles;
    }
}
