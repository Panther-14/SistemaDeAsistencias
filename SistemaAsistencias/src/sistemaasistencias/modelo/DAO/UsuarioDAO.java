package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import passwordencryptor.SHA_512;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.Rol;
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class UsuarioDAO {
        public static Usuario iniciarSesion(String nombreUsuario, String contrasenia) throws SQLException{
        Usuario usuarioLogin = new Usuario();
        DataBaseConnection dataBase = new DataBaseConnection();
        SHA_512 encriptador = new SHA_512();
        String consulta = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta); 
            prepararConsulta.setString(1, nombreUsuario);
            prepararConsulta.setString(2, encriptador.getSHA512(contrasenia));
            ResultSet resultadoConsulta = prepararConsulta.executeQuery();           
            if(resultadoConsulta.next()){
                usuarioLogin.setNombreUsuario(resultadoConsulta.getString("nombreUsuario"));
                usuarioLogin.setRol(new Rol(
                        resultadoConsulta.getInt("idRol"),
                        resultadoConsulta.getString("descripcion")
                ));
                usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
            }else{
                usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_CREDENCIALES_INCORRECTAS);
            }
        } catch (SQLException e) {
            usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_ERROR_CONEXIONBD);

        } finally{
            dataBase.desconectar();
        }
        return usuarioLogin;
    }
}
