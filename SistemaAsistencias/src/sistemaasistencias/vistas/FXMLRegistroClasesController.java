package sistemaasistencias.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemaasistencias.modelo.DAO.ExperienciaEducativaDAO;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLRegistroClasesController implements Initializable {
    
    private ObservableList<ExperienciaEducativa> infoExperienciaEducativas;
    
    @FXML
    private TableView<ExperienciaEducativa> tbExperiencias;
    @FXML
    private TableColumn colNRC;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colLunes;
    @FXML
    private TableColumn colMartes;
    @FXML
    private TableColumn colMiercoles;
    @FXML
    private TableColumn colJueves;
    @FXML
    private TableColumn colViernes;
    @FXML
    private TableColumn colSabado;
    @FXML
    private TableColumn colDomingo;
    @FXML
    private TextField txtBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarExperienciasEducativas();
    }
    
    @FXML
    private void regresar(ActionEvent event) {
    }

    private void cargarExperienciasEducativas() {
        try {
            ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerHorarios();
            if (resultadoConsulta != null) {
                infoExperienciaEducativas.clear();
                infoExperienciaEducativas.addAll(resultadoConsulta);
                tbExperiencias.setItems(infoExperienciaEducativas);
                configurarBusqueda();
            }else{
                Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
        } catch (SQLException ex) {
            Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
        }
    }
    private void configurarColumnasTabla() {
        colNombre.setCellValueFactory (new PropertyValueFactory ("nombreEE"));
        colNRC.setCellValueFactory (new PropertyValueFactory ("nrc"));
        colLunes.setCellValueFactory (new PropertyValueFactory ("lunes"));
        colMartes.setCellValueFactory (new PropertyValueFactory ("martes"));
        colMiercoles.setCellValueFactory (new PropertyValueFactory ("miercoles"));
        colJueves.setCellValueFactory (new PropertyValueFactory ("jueves"));
        colViernes.setCellValueFactory (new PropertyValueFactory ("viernes"));
        colSabado.setCellValueFactory (new PropertyValueFactory ("sabado"));
        colDomingo.setCellValueFactory (new PropertyValueFactory ("domingo"));
        infoExperienciaEducativas = FXCollections.observableArrayList();
    }

    private void configurarBusqueda() {
        if(infoExperienciaEducativas.size() > 0){
            FilteredList<ExperienciaEducativa> listaFiltrada = new FilteredList<>(infoExperienciaEducativas,p->true);
            txtBuscar.textProperty().addListener(new ChangeListener<String>(){
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    listaFiltrada.setPredicate(busqueda ->{
                        if(newValue == null || newValue.isEmpty()){
                            return true;
                        }
                        if(busqueda.getNombreEE().toLowerCase().contains(newValue.toLowerCase())){
                            return true;
                        }
                        else if(String.valueOf(busqueda.getNrc()).toLowerCase().contains(newValue.toLowerCase())){
                            return true;
                        }
                        return false;
                    });
                }
            });
            SortedList<ExperienciaEducativa> ordenamientoAlumnos = new SortedList<>(listaFiltrada);
            ordenamientoAlumnos.comparatorProperty().bind(tbExperiencias.comparatorProperty());
            tbExperiencias.setItems(ordenamientoAlumnos);
        }
    }
}
