package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private AnchorPane Register;

    @FXML
    private Button bT_Login;

    @FXML
    private TextField tF_Name;

    @FXML
    private TextField tF_LastName;

    @FXML
    private TextField tF_Username;

    @FXML
    private TextField tF_Age;

    @FXML
    private RadioButton rB_Male;

    @FXML
    private RadioButton rB_Female;

    @FXML
    private TextField tF_CardNumber;

    @FXML
    private TextField tF_SecurityCode;

    @FXML
    private TextField tF_ExpireDate;

    @FXML
    private Button bT_SignIn;

    @FXML
    void bT_LogIn(ActionEvent event) throws IOException {

        try{
            //Abrir la ventana
            Parent root = FXMLLoader.load(RegisterController.class.getResource("Login.fxml"));
            Scene logInScene = new Scene(root);
            Stage logInStage = new Stage();
            logInStage.setScene(logInScene);
            logInStage.show();

            //Atributos de ventana
            logInStage.setTitle("MediaStream | Sign up");//titulo de la ventana
            Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
            logInStage.getIcons().add(icon);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch

    }//end bT_LogIn

    @FXML
    void bT_SignUp(ActionEvent event) {

    }//end bT_SignUp

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}//end class RegisterController