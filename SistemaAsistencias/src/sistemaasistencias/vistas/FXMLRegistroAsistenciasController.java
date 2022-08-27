package sistemaasistencias.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sistemaasistencias.modelo.DAO.AsistenciaDAO;
import sistemaasistencias.modelo.POJO.Asistencia;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.alertas.Alertas;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLRegistroAsistenciasController implements Initializable {
    
    private ObservableList<Asistencia> infoEstudiantes;
    private ExperienciaEducativa experienciaEducativa;
    
    @FXML
    private TableView<Asistencia> tbAlumnos;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colFecha;
    @FXML
    private Label lbTitulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void configurarVentana(ExperienciaEducativa experienciaEducativa) {
        this.experienciaEducativa = experienciaEducativa;
        lbTitulo.setText("Asistencias "+this.experienciaEducativa.getNombreEE());
        configurarColumnasTabla();
        cargarExperienciasEducativas();
    }
    
    private void configurarColumnasTabla() {
        colNombre.setCellValueFactory (new PropertyValueFactory ("nombreEstudiante"));
        colFecha.setCellValueFactory (new PropertyValueFactory ("fecha"));
        infoEstudiantes = FXCollections.observableArrayList();
    }
    
    private void cargarExperienciasEducativas() {
        try {
            ArrayList<Asistencia> resultadoConsulta = AsistenciaDAO.obtenerAsistentes(this.experienciaEducativa.getNrc());
            if (resultadoConsulta != null) {
                infoEstudiantes.clear();
                infoEstudiantes.addAll(resultadoConsulta);
                tbAlumnos.setItems(infoEstudiantes);
            }else{
                Alertas.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
        } catch (SQLException ex) {
            Alertas.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void regresar(ActionEvent event) {
        Stage escenario = (Stage) tbAlumnos.getScene().getWindow();
        escenario.close();
    }
    
}
