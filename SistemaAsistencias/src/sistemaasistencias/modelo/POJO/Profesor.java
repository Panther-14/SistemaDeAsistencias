package sistemaasistencias.modelo.POJO;

/**
 *
 * @author Panther
 */
public class Profesor {
    private int numeroEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Profesor{" + "numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidodoMaterno=" + apellidoMaterno + ", usuario=" + usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals=false;
        if (object == this) {
            isEquals=true;
        }
        if (object!= null && object instanceof Profesor) {
            Profesor other = (Profesor) object;
            isEquals=this.getNombre().equals(other.getNombre()) &&
                    this.getApellidoPaterno().equals(other.getApellidoPaterno()) &&
                    this.getApellidoMaterno().equals(other.getApellidoMaterno()) &&
                    this.getNombreCompleto().equals(other.getNombreCompleto()) &&
                    this.getNumeroEmpleado() == other.getNumeroEmpleado() &&
                    this.getUsuario().equals(other.getUsuario());
        }
        return isEquals;
    }
    
}
