package Presentation;

import Domain.Programa;
import Domain.Usuario;
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

        /*
        //----------------------------------------------------
        Programa peliculaFirstSunday = new Programa("Pelicula",98,16,"First Sunday", null);
        Programa peliculaGrownUps = new Programa("Pelicula",102,12,"Grown Ups", null);
        Programa peliculaIt = new Programa("Pelicula",136,15,"It", null);
        Programa peliculaAnnabelle = new Programa("Pelicula",98,15,"Annabelle", null);
        Programa peliculaTheNotebook = new Programa("Pelicula",124,16,"The Notebook", null);
        Programa peliculaNewness = new Programa("Pelicula",112,16,"Newness", null);

        Usuario u = new Usuario(23,"Carlos","M",123, "CR", 1, "Principal");
        u.getColaPrioridad().encolar(peliculaFirstSunday);
        u.getColaPrioridad().encolar(peliculaIt);
        u.getColaPrioridad().encolar(peliculaNewness);

        //u.getColaPrioridad().desencolar();
        System.out.println(u.getColaPrioridad().toString());
        System.out.println("Head: "+u.getColaPrioridad().head());
        System.out.println("Size: "+u.getColaPrioridad().getSize());

        if (u.getColaPrioridad().exists("It")){
            System.out.println("Existe");
        }else {
            System.out.println("NO Existe");
        }//else

        System.out.println("Position: "+u.getColaPrioridad().getPosition("Newness"));

        //u.getColaPrioridad().cancel();
        //System.out.println(u.getColaPrioridad().toString());

        if (u.getColaPrioridad().isEmpty()){
            System.out.println("Colaaaa Vaciaaaaa");
        }else {
            System.out.println("Colaaaa NOOOOO Vaciaaaaa");
        }//else

        //----------------------------------------------------
        */

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
