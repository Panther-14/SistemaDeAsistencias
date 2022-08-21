package sistemaasistencias.modelo.POJO;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    public static Usuario usuarioLogin;
    
    private String nombreUsuario;
    private String contrasenia;
    private Integer codigoRespuesta;
    private Rol rol;
    
    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", codigoRespuesta=" + codigoRespuesta + ", rol=" + rol + '}';
    }
    
}
