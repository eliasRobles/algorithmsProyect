package Presentation;

import Domain.Programa;
import Logic.LCDEGeneros;
import Logic.LDEProgramas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Abrir ventana
        Parent root = FXMLLoader.load(LoginController.class.getResource("Login.fxml"));
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

        //Atributos de la ventana
        primaryStage.setTitle("MediaStream | Log in");//titulo de la ventana
        Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
        primaryStage.getIcons().add(icon);
        //primaryStage.setResizable(false);

    }//end start method

    public static void main(String[] args) {
        launch(args);



        //----------------------------------------------------
        /*
        System.out.println(lista1.toString());
        System.out.println("Size: "+lista1.getSize());
        if (lista2.exists(programa1)) {
            System.out.println("Existe");
        }else {
            System.out.println("NO EXISTE");
        }//else
        */

        //System.out.println(lista1.before.toString());
        //LCDEGenero nuevaLista=new LCDEGenero();

        //nuevaLista.insert("terror");//0
        //nuevaLista.insert("Drama");//1
        //nuevaLista.insert("Comedia");//2
        //nuevaLista.insert("Anime");//3
        //System.out.println("El sigiente  es: "+nuevaLista.getNext("Anime"));
        //System.out.println("El anterior es: "+nuevaLista.getBefore("Anime"));

    }// fin Main
}// fin clase
