package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Login.fxml"));
        Pane ventana=(Pane)loader.load();
        Scene scene= new Scene(ventana);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
        //LCDEGenero nuevaLista=new LCDEGenero();

        //nuevaLista.insert("terror");//0
        //nuevaLista.insert("Drama");//1
        //nuevaLista.insert("Comedia");//2
        //nuevaLista.insert("Anime");//3
        //System.out.println("El sigiente  es: "+nuevaLista.getNext("Anime"));
        //System.out.println("El anterior es: "+nuevaLista.getBefore("Anime"));




    }// fin Main
}// fin clase
