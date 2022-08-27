package sistemaasistencias.modelo.POJO;

import java.util.Objects;

/**
 *
 * @author Panther
 */
public class Asistencia {
    private int idAsistencia;
    private String fecha;
    private String nrc;
    private String nombreEE;
    private String nombreEstudiante;

    public Asistencia() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNombreEE() {
        return nombreEE;
    }

    public void setNombreEE(String nombreEE) {
        this.nombreEE = nombreEE;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String estudiante) {
        this.nombreEstudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", fecha=" + fecha + ", nrc=" + nrc + ", nombreEE=" + nombreEE + ", nombreEstudiante=" + nombreEstudiante + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals=false;
        if (object == this) {
            isEquals=true;
        }
        if (object!= null && object instanceof Asistencia) {
            Asistencia other = (Asistencia) object;
            isEquals=this.getIdAsistencia()== other.getIdAsistencia()&&
                    this.getFecha().equals(other.getFecha()) &&
                    this.getNombreEE().equals(other.getNombreEE()) &&
                    this.getNrc().equals(other.getNrc()) &&
                    this.getNombreEstudiante().equals(other.getNombreEstudiante());
        }
        return isEquals;
    }
}
