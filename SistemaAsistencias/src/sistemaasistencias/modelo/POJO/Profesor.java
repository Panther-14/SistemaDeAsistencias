package sistemaasistencias.modelo.POJO;

/**
 *
 * @author Panther
 */
public class Profesor {
    private int numeroEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidodoMaterno;
    private String nombreCompleto;
    private Usuario usuario;

    public Profesor() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidodoMaterno() {
        return apellidodoMaterno;
    }

    public void setApellidodoMaterno(String apellidodoMaterno) {
        this.apellidodoMaterno = apellidodoMaterno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Profesor{" + "numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidodoMaterno=" + apellidodoMaterno + ", usuario=" + usuario + '}';
    }
    
}
