package sistemaasistencias.vistas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import sistemaasistencias.modelo.DAO.UsuarioDAO;
import sistemaasistencias.modelo.POJO.Usuario;
import sistemaasistencias.util.Constantes;
import sistemaasistencias.util.Utilidades;

/**
 *
 * @author Panther
 */
public class FXMLInicioSesionController implements Initializable {
    
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasenia;
    @FXML
    private Label lbErrorContrasenia;
    @FXML
    private Label lbErrorUsuario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        lbErrorContrasenia.setText("");
        lbErrorUsuario.setText("");
        
        String nombreUsuario = txtUsuario.getText();
        String constrasenia = txtContrasenia.getText();
        boolean usuarioValido = true;
        
        if(StringUtils.isBlank(nombreUsuario)){
            lbErrorUsuario.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        
        if(StringUtils.isBlank(constrasenia)){
            lbErrorContrasenia.setText("Campo Obligatorio");
            usuarioValido = false;
        }
        
        if (usuarioValido) {
            validarUsuarioBD(nombreUsuario, constrasenia);
        }
    }
    
    @FXML
    private void registrarse(ActionEvent event) {
        irPantallaRegistrarUsuario();
    }

    private void validarUsuarioBD(String nombreUsuario, String constrasenia) {
        try {
            Usuario usuarioLogin = UsuarioDAO.iniciarSesion(nombreUsuario, constrasenia);
            switch(usuarioLogin.getCodigoRespuesta()){
                case Constantes.CODIGO_OPERACION_CORRECTA:
                    Utilidades.mostrarAlerta("Usuario Verificado","Bienvenido al sistema.",Alert.AlertType.INFORMATION);
                    irPantallaMenu();
                    break;
                case Constantes.CODIGO_CREDENCIALES_INCORRECTAS:
                    Utilidades.mostrarAlerta("Credenciales incorrectas","Usuario o contraseña incorrectas.",Alert.AlertType.WARNING);
                    txtUsuario.setText("");
                    txtContrasenia.setText("");
                    break;
                case Constantes.CODIGO_ERROR_CONEXIONBD:
                    Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
                    break;
            }
        } catch (SQLException sqlException) {
            Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
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
            Utilidades.mostrarAlertaConfirmacion("Error", "No se puede cargar el menu", Alert.AlertType.ERROR);
        }
    }
    
    private void irPantallaRegistrarUsuario() {
        try{
            Stage escenarioPrincipal = (Stage) txtUsuario.getScene().getWindow();
            Scene menu = new Scene(FXMLLoader.load(getClass().getResource("FXMLRegistrarUsuario.fxml")));
            escenarioPrincipal.setScene(menu);
            escenarioPrincipal.setTitle("Registrar usuario");
            escenarioPrincipal.show();
        } catch (IOException ioException) {
            Utilidades.mostrarAlertaConfirmacion("Error", "No se puede cargar la ventana de registro", Alert.AlertType.ERROR);
        }
    }
}
