package sistemaasistencias.vistas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import sistemaasistencias.modelo.DAO.EstudianteDAO;
import sistemaasistencias.modelo.DAO.ProfesorDAO;
import sistemaasistencias.modelo.DAO.RolDAO;
import sistemaasistencias.modelo.DAO.UsuarioDAO;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.modelo.POJO.Profesor;
import sistemaasistencias.modelo.POJO.Rol;
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.alertas.Alertas;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLRegistrarUsuarioController implements Initializable {
    
    private ObservableList<Rol> listaRoles;
    
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasenia;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lbErrorContrasenia;
    @FXML
    private Label lbErrorRol;
    @FXML
    private ComboBox<Rol> cbRol;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbErrorMatricula;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtNombre;
    @FXML
    private Label lbErrorNombre;
    @FXML
    private Label lbErrorApellidoPaterno;
    @FXML
    private Label lbErrorApellidoMaterno;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarInformacioRoles();
        cbRol.valueProperty().addListener(new ChangeListener<Rol>(){
            @Override
            public void changed(ObservableValue<? extends Rol> observable, Rol oldValue, Rol newValue){
                if(newValue != null){
                    if (newValue.getIdRol()==1) {
                        lbMatricula.setText("Número de Personal");
                    }else if (newValue.getIdRol()==2){
                        lbMatricula.setText("Matricula");
                    }
                }
            } 
        });
    }    


    @FXML
    private void registrarse(ActionEvent event) {
        lbErrorApellidoMaterno.setText("");
        lbErrorApellidoPaterno.setText("");
        lbErrorContrasenia.setText("");
        lbErrorMatricula.setText("");
        lbErrorNombre.setText("");
        lbErrorRol.setText("");
        lbErrorUsuario.setText("");
        
        String nombreUsuario = txtUsuario.getText();
        String constrasenia = txtContrasenia.getText();
        String matricula = txtMatricula.getText();
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        Rol rol = cbRol.getSelectionModel().getSelectedItem();
        boolean usuarioValido = true;
        
        if(StringUtils.isBlank(nombreUsuario)){
            lbErrorUsuario.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        if(StringUtils.isBlank(constrasenia)){
            lbErrorContrasenia.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        if(StringUtils.isBlank(matricula)){
            lbErrorMatricula.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        if(StringUtils.isBlank(nombre)){
            lbErrorNombre.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        if(StringUtils.isBlank(apellidoPaterno)){
            lbErrorApellidoPaterno.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        if(StringUtils.isBlank(apellidoMaterno)){
            lbErrorApellidoMaterno.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        if(rol == null){
            lbErrorRol.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        
        if (usuarioValido) {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setContrasenia(constrasenia);
            usuario.setRol(rol);
            
            if(rol.getIdRol()==1){
                boolean valido =true;
                int parseInt = 0;
                
                Profesor profesor = new Profesor();
                profesor.setUsuario(usuario);
                profesor.setNombre(nombre);
                profesor.setApellidoPaterno(apellidoPaterno);
                profesor.setApellidoMaterno(apellidoMaterno);
                
                try{
                    parseInt = Integer.parseInt(matricula);
                }catch(NumberFormatException nfException){
                    Alertas.mostrarAlerta("Número de Empleado Incorrecto", "Debes ingresar un valor numérico", Alert.AlertType.WARNING);
                    valido = false;
                }
                
                profesor.setNumeroEmpleado(parseInt);
                
                if(valido) realizarRegistro(usuario, profesor, null);
            }else if(rol.getIdRol()==2){
                Estudiante estudiante = new Estudiante();
                estudiante.setUsuario(usuario);
                estudiante.setNombre(nombre);
                estudiante.setApellidoPaterno(apellidoPaterno);
                estudiante.setApellidoMaterno(apellidoMaterno);
                estudiante.setMatricula(matricula);
                
                realizarRegistro(usuario, null, estudiante);
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        irPantallaInicioSesion();
    }
    
    private void irPantallaInicioSesion() {
        try{
            Stage escenarioPrincipal = (Stage) txtUsuario.getScene().getWindow();
            Scene menu = new Scene(FXMLLoader.load(getClass().getResource("FXMLInicioSesion.fxml")));
            escenarioPrincipal.setScene(menu);
            escenarioPrincipal.setTitle("Inicio de Sesión");
            escenarioPrincipal.show();
        } catch (IOException ioException) {
            Alertas.mostrarAlertaConfirmacion("Error", "No se puede cargar la ventana de inicio de sesión", Alert.AlertType.ERROR);
        }
    }

    private void realizarRegistro(Usuario usuario,Profesor profesor,Estudiante estudiante) {
        try {
            UsuarioDAO.registrarUsuario(usuario);
            if(profesor != null){
                ProfesorDAO.registrarProfesor(profesor);
            }else if(estudiante != null){
                EstudianteDAO.registrarEstudiante(estudiante);
            }
            Alertas.mostrarAlerta("Usuario Registrado","Bienvenido al sistema.",Alert.AlertType.INFORMATION);
            irPantallaMenu();
        } catch (SQLException sqlException) {
            Alertas.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
        }
        
    }

    private void cargarInformacioRoles() {
        ArrayList<Rol> rolesList = null;
        try {
            rolesList = RolDAO.obtenerRoles();
        } catch (SQLException ex) {
            Alertas.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
        }
        if(rolesList != null){
            listaRoles = FXCollections.observableArrayList();
            listaRoles.addAll(rolesList);
            cbRol.setItems(listaRoles);
        }else{
            Alertas.mostrarAlertaConfirmacion("Error", "No se puede cargar la lista de roles", Alert.AlertType.ERROR);
        }
    }
    
    private void irPantallaMenu() {
        try{
            Stage escenarioPrincipal = (Stage) txtUsuario.getScene().getWindow();
            Scene menu = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
            escenarioPrincipal.setScene(menu);
            escenarioPrincipal.setTitle("Menu");
            escenarioPrincipal.show();
        } catch (IOException ioException) {
            Alertas.mostrarAlertaConfirmacion("Error", "No se puede cargar el menu", Alert.AlertType.ERROR);
        }
    }
}
