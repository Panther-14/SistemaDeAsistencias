package sistemaasistencias.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sistemaasistencias.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private Label lbTitulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void irPantallaRegistroClases(String titulo,int modo) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistroClases.fxml"));
            Parent root = loader.load();
            FXMLRegistroClasesController controladorDetalles = loader.getController();
            controladorDetalles.configurarVentana(modo);
            Scene escena = new Scene(root);
            Stage escenarioPrincipal = (Stage) lbTitulo.getScene().getWindow();;
            escenarioPrincipal.setResizable(false);
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setTitle(titulo);
            escenarioPrincipal.show();
        } catch (IOException ioException) {
            Utilidades.mostrarAlertaConfirmacion("Error", "No se puede cargar el menu", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void detallesExperienciasEducativas(ActionEvent event) {
        irPantallaRegistroClases("Detalles Experiencia Educativa",1);
    }

    @FXML
    private void inscribirExperienciaEducativa(ActionEvent event) {
        irPantallaRegistroClases("Inscribir Experiencia Educativa",2);
    }

    @FXML
    private void registroDeAsistencia(ActionEvent event) {
        irPantallaRegistroClases("Asistencias por Experiencia Educativa",3);
    }
    
}
