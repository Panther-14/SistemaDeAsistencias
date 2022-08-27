package sistemaasistencias.modelo.POJO;

/**
 *
 * @author Panther
 */
public class Carrera {
    private int idCarrera;
    private String descripcion;

    public Carrera() {
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Carrera{" + "idCarrera=" + idCarrera + ", descripcion=" + descripcion + '}';
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
        if (object!= null && object instanceof Carrera) {
            Carrera other = (Carrera) object;
            isEquals=this.getIdCarrera()== other.getIdCarrera()&&
                    this.getDescripcion().equals(other.getDescripcion());
        }
        return isEquals;
    }
    
    
}
