package Presentation;

import Domain.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.lang.reflect.Array;


public class Main extends Application {

    LoginController lC = new LoginController();
    //RegisterController rC = new RegisterController();


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Abrir ventana
        Parent root = FXMLLoader.load(LoginController.class.getResource("Login.fxml"));
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

        //Atributos de la ventana
        primaryStage.setTitle("MediaStream | Log In");//titulo de la ventana
        Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
        primaryStage.getIcons().add(icon);


    }//end start method

    public static void main(String[] args) {
        launch(args);
    }// fin Main
}// fin clase
