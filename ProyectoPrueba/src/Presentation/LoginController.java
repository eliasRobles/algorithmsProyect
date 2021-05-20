package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private AnchorPane Login;

    @FXML
    private AnchorPane JPInicioSesion;

    @FXML
    private TextField jtfUsuario;

    @FXML
    private TextField jtfContraseña;

    @FXML
    private Button jbIniciarSesion;

    @FXML
    void openWindow(ActionEvent event) throws IOException {

        //Estas dos líneas se llevan los objetos de Login y traen los de Category
        //sin necesidad de crear un Scene nuevo
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("Category.fxml"));
        //Login.getChildren().setAll(pane);

        //Estas líneas abren una nueva ventana sin cerrar la anterior
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();


        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch


    }//end cambioVentana method

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }
}//end ControllerLogin class
