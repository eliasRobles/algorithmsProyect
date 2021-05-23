package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane Base;

    @FXML
    private AnchorPane Login;

    @FXML
    private Button bT_Login;

    @FXML
    private TextField tF_User;

    @FXML
    private TextField tF_Password;

    @FXML
    private Button bT_SignUp;

    @FXML
    void bT_Login(ActionEvent event) throws IOException {

        //Estas dos líneas se llevan los objetos de Login y traen los de Category
        //sin necesidad de crear un Scene nuevo
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("Category.fxml"));
        //Login.getChildren().setAll(pane);

        //Abrir la ventana
        Parent root = FXMLLoader.load(RegisterController.class.getResource("Category.fxml"));
        Scene CategoryScene = new Scene(root);
        Stage CategoryStage = new Stage();
        CategoryStage.setScene(CategoryScene);
        CategoryStage.show();

        //Atributos de ventana
        CategoryStage.setTitle("MediaStream | Category");//titulo de la ventana
        Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
        CategoryStage.getIcons().add(icon);

    }//end onLoginAction

    @FXML
    void bT_SignUp(ActionEvent event) throws IOException {

        try{
            //Abrir la ventana
            Parent root = FXMLLoader.load(RegisterController.class.getResource("Register.fxml"));
            Scene signUpScene = new Scene(root);
            Stage signUpStage = new Stage();
            signUpStage.setScene(signUpScene);
            signUpStage.show();

            //Atributos de ventana
            signUpStage.setTitle("MediaStream | Sign up");//titulo de la ventana
            Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
            signUpStage.getIcons().add(icon);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch

    }//end bT_SignUp

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

}//end LoginControllerClass
