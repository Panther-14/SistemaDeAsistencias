package sistemaasistencias.modelo.POJO;

/**
 *
 * @author Panther
 */
public class Rol {
    
    private int idRol;
    private String descripcion;

    public Rol() {
    }

    public Rol(int idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }
    
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals=false;
        if (object == this) {
            isEquals=true;
        }
        if (object!= null && object instanceof Rol) {
            Rol other = (Rol) object;
            isEquals=this.getIdRol() == other.getIdRol() &&
                    this.getDescripcion().equals(other.getDescripcion());
        }
        return isEquals;
    }
    
        
}
