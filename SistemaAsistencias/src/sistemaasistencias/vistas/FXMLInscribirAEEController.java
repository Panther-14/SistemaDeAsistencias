package sistemaasistencias.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemaasistencias.modelo.DAO.EstudianteCursaEEDAO;
import sistemaasistencias.modelo.DAO.EstudianteDAO;
import sistemaasistencias.modelo.DAO.ProfesorDAO;
import sistemaasistencias.modelo.DAO.ProfesorImparteEEDAO;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.modelo.POJO.Profesor;
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLInscribirAEEController implements Initializable {
    
    private ExperienciaEducativa experienciaEducativa;
    private Estudiante estudiante;
    private Profesor profesor;
    
    @FXML
    private Label lbIdentificador;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;
    @FXML
    private TextField txtIdentificador;
    @FXML
    private TextField txtExperienciaEducativa;
    @FXML
    private TextField txtNrc;
    @FXML
    private TextField txtRol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void configurarVentana(ExperienciaEducativa experienciaEducativa){
        this.experienciaEducativa = experienciaEducativa;
        rellenarInformacionUsuario();
    }
    
    private void rellenarInformacionUsuario(){
        txtRol.setText(Usuario.usuarioLogin.getRol().getDescripcion());
        txtExperienciaEducativa.setText(this.experienciaEducativa.getNombreEE());
        txtNrc.setText(this.experienciaEducativa.getNrc());
        
        if(Usuario.usuarioLogin.getRol().getIdRol()==1){
            lbIdentificador.setText("Número Empleado");
            try{
                this.profesor = ProfesorDAO.obtenerProfesor(Usuario.usuarioLogin.getNombreUsuario());
            }catch(SQLException sqle){
                Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
            txtNombre.setText(profesor.getNombre());
            txtApellidoPaterno.setText(profesor.getApellidoPaterno());
            txtApellidoMaterno.setText(profesor.getApellidodoMaterno());
            txtIdentificador.setText(Integer.toString(profesor.getNumeroEmpleado()));
        }else if (Usuario.usuarioLogin.getRol().getIdRol()==2){
            lbIdentificador.setText("Matricula");
            try{
                this.estudiante = EstudianteDAO.obtenerEstudiante(Usuario.usuarioLogin.getNombreUsuario());
            }catch(SQLException sqle){
                Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
            txtNombre.setText(estudiante.getNombre());
            txtApellidoPaterno.setText(estudiante.getApellidoPaterno());
            txtApellidoMaterno.setText(estudiante.getApellidoMaterno());
            txtIdentificador.setText(estudiante.getMatricula());
        }
    }
    
    private boolean validarHorario(){
        boolean valido = true;
        
        String lunes = this.experienciaEducativa.getLunes();
        String martes = this.experienciaEducativa.getMartes();
        String miercoles = this.experienciaEducativa.getMiercoles();
        String jueves = this.experienciaEducativa.getJueves();
        String viernes = this.experienciaEducativa.getViernes();
        String sabado = this.experienciaEducativa.getSabado();
        String domingo = this.experienciaEducativa.getDomingo();
        
        ArrayList<ExperienciaEducativa> experienciaEducativas = new ArrayList<>();
        try {
            if(this.estudiante != null){
                experienciaEducativas = EstudianteCursaEEDAO.obtenerExperienciaEducativaEstudiante(estudiante.getMatricula());
            }else if(this.profesor != null){
                experienciaEducativas = ProfesorImparteEEDAO.obtenerExperienciaEducativaProfesor(profesor.getNumeroEmpleado());
            }
        } catch (SQLException ex) {
            Utilidades.mostrarAlerta("(A)Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            
        }
        for (int i = 0; i < experienciaEducativas.size(); i++) {
            ExperienciaEducativa educativa = experienciaEducativas.get(i);
            if(educativa.getLunes().equals(lunes) || educativa.getMartes().equals(martes)||
                    educativa.getMiercoles().equals(miercoles)||educativa.getJueves().equals(jueves)||
                    educativa.getViernes().equals(viernes)||educativa.getSabado().equals(sabado)||
                    educativa.getDomingo().equals(domingo)){
                valido = false;
            }
        }        
        return valido;
    }
    
    private void registrarInformacion(){
        try {
            if(this.estudiante != null){
                EstudianteCursaEEDAO.registrarEnExperiencia(this.experienciaEducativa.getNrc(), this.estudiante.getMatricula());
            }else if (this.profesor != null) {
                ProfesorImparteEEDAO.registrarEnExperiencia(this.experienciaEducativa.getNrc(), this.profesor.getNumeroEmpleado());
            }
        } catch (SQLException sqle) {
            Utilidades.mostrarAlerta("(B)Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void registrarEnExperienciaEducativa(ActionEvent event) {
        if(validarHorario()){
            registrarInformacion();
            Utilidades.mostrarAlerta("Registro Exitoso", "Se ha registrado correctamente", Alert.AlertType.INFORMATION);
            Stage escenario = (Stage) txtApellidoMaterno.getScene().getWindow();
            escenario.close();
        }else{
            System.err.println("No se puede inscribir");
        }
    }

    @FXML
    private void cancelarRegistro(ActionEvent event) {
        Stage escenario = (Stage) txtApellidoMaterno.getScene().getWindow();
        escenario.close();
    }
    
}
