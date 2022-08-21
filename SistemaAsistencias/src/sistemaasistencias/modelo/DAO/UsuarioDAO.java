package sistemaasistencias.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import passwordencryptor.SHA_512;
import sistemaasistencias.modelo.DataBaseConnection;
import sistemaasistencias.modelo.POJO.Rol;
import sistemaasistencias.modelo.POJO.Usuario;
import static sistemaasistencias.modelo.POJO.Usuario.usuarioLogin;
import sistemaasistencias.util.Constantes;

/**
 *
 * @author Panther
 */
public class UsuarioDAO {
    public static Usuario iniciarSesion(String nombreUsuario, String contrasenia) throws SQLException{
        Usuario.usuarioLogin = new Usuario();
        DataBaseConnection dataBase = new DataBaseConnection();
        SHA_512 encriptador = new SHA_512();
        String consulta = "SELECT usuario.nombreUsuario,usuario.idRol,rol.descripcion FROM sistemaasistencias.usuario " +
                        "INNER JOIN rol " +
                        "ON usuario.idRol = rol.idRol " +
                        "WHERE nombreUsuario = ? AND contrasenia = ?;";
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
        } catch (SQLException sqlException) {
            usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_ERROR_CONEXIONBD);
        } finally{
            dataBase.desconectar();
        }
        return Usuario.usuarioLogin;
    }
    
    public static int registrarUsuario(Usuario usuarioRegistro) throws SQLException{
        DataBaseConnection dataBase = new DataBaseConnection();
        SHA_512 encriptador = new SHA_512();
        int verificacionRegistro;
        String consulta = "INSERT INTO usuario values(?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement prepararConsulta = conexion.prepareStatement(consulta);
            prepararConsulta.setString(1, usuarioRegistro.getNombreUsuario());
            prepararConsulta.setString(2, encriptador.getSHA512(usuarioRegistro.getContrasenia()));
            prepararConsulta.setInt(3, usuarioRegistro.getRol().getIdRol());
            int filasAfectadas = prepararConsulta.executeUpdate();
            verificacionRegistro = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
}
