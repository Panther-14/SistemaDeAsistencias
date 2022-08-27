package sistemaasistencias.modelo.POJO;

import java.util.Objects;

/**
 *
 * @author Panther
 */
public class ExperienciaEducativa {
    private String nrc;
    private String nombreEE;
    private Carrera carera;
    private int idHorario;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String sabado;
    private String domingo;

    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(String nrc, String nombreEE, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        this.nrc = nrc;
        this.nombreEE = nombreEE;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
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

    public Carrera getCarera() {
        return carera;
    }

    public void setCarera(Carrera carera) {
        this.carera = carera;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    @Override
    public String toString() {
        return "ExperienciaEducativa{" + "nrc=" + nrc + ", nombreEE=" + nombreEE + ", carera=" + carera + ", idHorario=" + idHorario + ", lunes=" + lunes + ", martes=" + martes + ", miercoles=" + miercoles + ", jueves=" + jueves + ", viernes=" + viernes + ", sabado=" + sabado + ", domingo=" + domingo + '}';
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
        if (object!= null && object instanceof ExperienciaEducativa) {
            ExperienciaEducativa other = (ExperienciaEducativa) object;
            isEquals=this.getIdHorario()== other.getIdHorario()&&
                    this.getNombreEE().equals(other.getNombreEE()) &&
                    this.getNrc().equals(other.getNrc()) &&
                    this.getCarera().equals(other.getCarera()) &&
                    this.getLunes().equals(other.getLunes()) &&
                    this.getMartes().equals(other.getMartes()) &&
                    this.getMiercoles().equals(other.getMiercoles()) &&
                    this.getJueves().equals(other.getJueves()) &&
                    this.getViernes().equals(other.getViernes()) &&
                    this.getSabado().equals(other.getSabado()) &&
                    this.getDomingo().equals(other.getDomingo());
        }
        return isEquals;
    }
    
}
