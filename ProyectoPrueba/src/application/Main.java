package application;

import Domain.Programa;
import Logica.LCDEGeneros;
import Logica.LDEProgramas;
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
        //launch(args);
       // System.out.println("Ejemplo");
        /*
        Programa programa1 = new Programa("Serie", 1, 18, "serie1");
        Programa programa2 = new Programa("Pelicula", 2, 19, "pelicula2");
        Programa programa3 = new Programa("Pelicula", 3, 20, "pelicula3");
        Programa programa4 = new Programa("Serie", 4, 21, "serie4");
        Programa programa5 = new Programa("Pelicula", 5, 22, "pelicula5");
        Programa programa6 = new Programa("Serie", 6, 23, "serie6");
        Programa programa7 = new Programa("Pelicula", 7, 24, "pelicula7");
        Programa programa8 = new Programa("Serie", 8, 25, "serie8");

        //System.out.println(programa1.toString());

        LDEProgramas lista1 = new LDEProgramas("Terror");
        lista1.insert(programa1);
        lista1.insert(programa2);
        lista1.insert(programa3);

        LDEProgramas lista2 = new LDEProgramas("Comedia");
        lista2.insert(programa4);
        lista2.insert(programa5);
        lista2.insert(programa6);

        LDEProgramas lista3 = new LDEProgramas("Romance");
        lista3.insert(programa7);
        lista3.insert(programa8);

        //System.out.println(lista1.toString());

        LCDEGeneros listaGeneros = new LCDEGeneros();
        listaGeneros.insert(lista1);
        listaGeneros.insert(lista2);
        listaGeneros.insert(lista3);


        System.out.println(listaGeneros.toString());
        System.out.println("Size: "+listaGeneros.getSize());
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
