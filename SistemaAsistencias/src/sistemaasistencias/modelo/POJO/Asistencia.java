package sistemaasistencias.modelo.POJO;

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
    private CheckBox chAsistencia;

    public Asistencia() {
        this.chAsistencia = new CheckBox();
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

    public CheckBox getChAsistencia() {
        return chAsistencia;
    }

    public void setChAsistencia(CheckBox chAsistencia) {
        this.chAsistencia = chAsistencia;
    }
    
}
