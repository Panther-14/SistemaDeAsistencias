/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaasistencias.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemaasistencias.modelo.DAO.EstudianteDAO;
import sistemaasistencias.modelo.DAO.ProfesorDAO;
import sistemaasistencias.modelo.POJO.Estudiante;
import sistemaasistencias.modelo.POJO.ExperienciaEducativa;
import sistemaasistencias.modelo.POJO.Profesor;
import sistemaasistencias.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLDetallesClasesController implements Initializable {
    
    private ObservableList<Estudiante> infoEstudiantes;
    private ExperienciaEducativa experienciaEducativa;
    
    @FXML
    private TableView<Estudiante> tbAlumnos;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private TableColumn colMatricula;
    @FXML
    private TextField txtProfesor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacion();
        cargarExperienciasEducativas();
    }    
    
    private void configurarColumnasTabla() {
        colNombre.setCellValueFactory (new PropertyValueFactory (""));
        colApellidoPaterno.setCellValueFactory (new PropertyValueFactory (""));
        colApellidoMaterno.setCellValueFactory (new PropertyValueFactory (""));
        colMatricula.setCellValueFactory (new PropertyValueFactory (""));
        infoEstudiantes = FXCollections.observableArrayList();
    }
    
    private void cargarExperienciasEducativas() {
        try {
            ArrayList<Estudiante> resultadoConsulta = EstudianteDAO.obtenerEstudiantesPorEE(experienciaEducativa);
            if (resultadoConsulta != null) {
                infoEstudiantes.clear();
                infoEstudiantes.addAll(resultadoConsulta);
                tbAlumnos.setItems(infoEstudiantes);
            }else{
                Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRegistroClasesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cargarInformacion(){
        try {
            Profesor profesor = ProfesorDAO.obtenerProfesor(experienciaEducativa);
            txtProfesor.setText(profesor.getNombreCompleto());
            txtProfesor.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDetallesClasesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void configurarVentana(ExperienciaEducativa experienciaEducativa){
        this.experienciaEducativa = experienciaEducativa;
    }
}
