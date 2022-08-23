package sistemaasistencias.modelo.POJO;

import java.util.Objects;
import javafx.scene.control.CheckBox;

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

    public String getEstudiante() {
        return nombreEstudiante;
    }

    public void setEstudiante(String estudiante) {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asistencia other = (Asistencia) obj;
        if (this.idAsistencia != other.idAsistencia) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.nrc, other.nrc)) {
            return false;
        }
        if (!Objects.equals(this.nombreEE, other.nombreEE)) {
            return false;
        }
        if (!Objects.equals(this.nombreEstudiante, other.nombreEstudiante)) {
            return false;
        }
        return true;
    }
    
}
