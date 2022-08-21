package sistemaasistencias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Panther
 */
public class SistemaAsistencias extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLInicioSesion.fxml"));
        
        Scene escenario = new Scene(root);
        
        stage.setResizable(false);
        stage.getIcons().add(new Image("sistemaasistencias/resources/icono.png"));
        stage.setScene(escenario);
        
        stage.setTitle("Inicio de Sesión");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
