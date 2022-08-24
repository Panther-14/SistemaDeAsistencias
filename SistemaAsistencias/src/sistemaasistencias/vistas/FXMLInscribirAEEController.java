package sistemaasistencias.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemaasistencias.modelo.DAO.EstudianteDAO;
import sistemaasistencias.modelo.DAO.ProfesorDAO;
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

    @FXML
    private void registrarEnExperienciaEducativa(ActionEvent event) {
    }

    @FXML
    private void cancelarRegistro(ActionEvent event) {
        Stage escenario = (Stage) txtApellidoMaterno.getScene().getWindow();
        escenario.close();
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
            Profesor profesor = null;
            try{
                profesor = ProfesorDAO.obtenerProfesor(Usuario.usuarioLogin.getNombreUsuario());
            }catch(SQLException sqle){
                Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
            txtNombre.setText(profesor.getNombre());
            txtApellidoPaterno.setText(profesor.getApellidoPaterno());
            txtApellidoMaterno.setText(profesor.getApellidodoMaterno());
            txtIdentificador.setText(Integer.toString(profesor.getNumeroEmpleado()));
        }else if (Usuario.usuarioLogin.getRol().getIdRol()==2){
            lbIdentificador.setText("Matricula");
            Estudiante estudiante = null;
            try{
                estudiante = EstudianteDAO.obtenerEstudiante(Usuario.usuarioLogin.getNombreUsuario());
            }catch(SQLException sqle){
                Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
            txtNombre.setText(estudiante.getNombre());
            txtApellidoPaterno.setText(estudiante.getApellidoPaterno());
            txtApellidoMaterno.setText(estudiante.getApellidoMaterno());
            txtIdentificador.setText(estudiante.getMatricula());
        }
    }
}
