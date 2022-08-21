package sistemaasistencias.modelo.POJO;

/**
 *
 * @author Panther
 */
public class Estudiante {
    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidodoMaterno;
    private Usuario usuario;

    public Estudiante() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidodoMaterno=" + apellidodoMaterno + ", usuario=" + usuario + '}';
    }
    
}
