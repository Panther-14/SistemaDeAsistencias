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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    private int modoDeFuncion;

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
    }
    
    private void cargarExperienciasEducativas() {
        try {
            ArrayList<ExperienciaEducativa> resultadoConsulta = resultadoConsulta = ExperienciaEducativaDAO.obtenerHorarios();
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
    
    private void valorSeleccionadoTablaExperienciasEducativas(){
        int filaSeleccionada = tbExperiencias.getSelectionModel().getSelectedIndex();
        if(filaSeleccionada >= 0){
            ExperienciaEducativa experienciaEducativa = infoExperienciaEducativas.get(filaSeleccionada);
            modoDeVentana(experienciaEducativa);
        }else{
            Utilidades.mostrarAlerta("EE no seleccionada","Para continuar debes seleccionar una Experiencia Educativa de la tabla",Alert.AlertType.WARNING);
        }
    }

    private void abrirVentanaDetallesExperienciaEducativa(ExperienciaEducativa experienciaEducativa){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDetallesClases.fxml"));
            Parent root = loader.load();
            FXMLDetallesClasesController controladorDetalles = loader.getController();
            controladorDetalles.configurarVentana(experienciaEducativa);
            Scene escena = new Scene(root);
            Stage escenarioPrincipal = new Stage();
            escenarioPrincipal.setResizable(false);
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setTitle("Detalles de la Experiencia Educativa");
            escenarioPrincipal.initModality(Modality.APPLICATION_MODAL);
            escenarioPrincipal.showAndWait();
        } catch (IOException iOException) {
            Utilidades.mostrarAlerta("Error de sistema","Hubo un error al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
        }
    }
    
    private void abrirVentanaInscribirExperienciaEducativa(ExperienciaEducativa experienciaEducativa){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInscribirAEE.fxml"));
            Parent root = loader.load();
            FXMLInscribirAEEController controladorDetalles = loader.getController();
            controladorDetalles.configurarVentana(experienciaEducativa);
            Scene escena = new Scene(root);
            Stage escenarioPrincipal = new Stage();
            escenarioPrincipal.setResizable(false);
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setTitle("Inscribir Experiencia Educativa");
            escenarioPrincipal.initModality(Modality.APPLICATION_MODAL);
            escenarioPrincipal.showAndWait();
        } catch (IOException iOException) {
            Utilidades.mostrarAlerta("Error de sistema","Hubo un error al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
        }
    }
    
    private void abrirVentanaAsistenciasExperienciaEducativa(ExperienciaEducativa experienciaEducativa){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistroAsistencias.fxml"));
            Parent root = loader.load();
            FXMLRegistroAsistenciasController controladorDetalles = loader.getController();
            controladorDetalles.configurarVentana(experienciaEducativa);
            Scene escena = new Scene(root);
            Stage escenarioPrincipal = new Stage();
            escenarioPrincipal.setResizable(false);
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setTitle("Registro de Asistencias");
            escenarioPrincipal.initModality(Modality.APPLICATION_MODAL);
            escenarioPrincipal.showAndWait();
        } catch (IOException iOException) {
            Utilidades.mostrarAlerta("Error de sistema","Hubo un error al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
        }
    }
    
    private void modoDeVentana(ExperienciaEducativa experienciaEducativa) {
        switch(this.modoDeFuncion){
            case 1:
                abrirVentanaDetallesExperienciaEducativa(experienciaEducativa);
                break;
            case 2:
                abrirVentanaInscribirExperienciaEducativa(experienciaEducativa);
                break;
            case 3:
                abrirVentanaAsistenciasExperienciaEducativa(experienciaEducativa);
                break;
        }
    }
    
    private void irPantallaMenu() {
        try{
            Stage escenarioPrincipal = (Stage) tbExperiencias.getScene().getWindow();
            Scene menu = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
            escenarioPrincipal.setScene(menu);
            escenarioPrincipal.setTitle("Menu");
            escenarioPrincipal.show();
        } catch (IOException ioException) {
            Utilidades.mostrarAlertaConfirmacion("Error", "No se puede cargar el menu", Alert.AlertType.ERROR);
        }
    }
    
    public void configurarVentana(int modoInscribir){
        this.modoDeFuncion = modoInscribir;
        configurarColumnasTabla();
        cargarExperienciasEducativas();
    }
            
    @FXML
    private void regresar(ActionEvent event) {
        irPantallaMenu();
    }

    @FXML
    private void detallesExperienciaEducativa(MouseEvent event) {
        if(event.getClickCount() == 2){
            valorSeleccionadoTablaExperienciasEducativas();
        }
    }
}