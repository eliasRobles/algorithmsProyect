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
        //implementacion de los programas

        LDEProgramas listaComedia=new LDEProgramas("Comedia");
        Programa peliculaFirstSunday = new Programa("Pelicula",98,16,"First Sunday");
        Programa peliculaGrownUps = new Programa("Pelicula",102,12,"Grown Ups");
        Programa peliculaChangeUp = new Programa("Pelicula",112,16,"Change Up");
        Programa peliculaNorbit = new Programa("Pelicula",102,16,"Norbit");
        Programa peliculaWeddingRinger = new Programa("Pelicula",101,14,"Wedding Ringer");
        listaComedia.insert(peliculaFirstSunday);
        listaComedia.insert(peliculaGrownUps);
        listaComedia.insert(peliculaChangeUp);
        listaComedia.insert(peliculaNorbit);
        listaComedia.insert(peliculaWeddingRinger);

        // System.out.println(listaComedia.toString());

        LDEProgramas listaTerror=new LDEProgramas("Terror");
        Programa peliculaIt = new Programa("Pelicula",136,15,"It");
        Programa peliculaAnnabelle = new Programa("Pelicula",98,15,"Annabelle");
        Programa peliculaMama = new Programa("Pelicula",100,15,"Mama");
        Programa peliculaVeronica = new Programa("Pelicula",102,16,"Veronica");
        Programa peliculaSaw = new Programa("Pelicula",111,18,"Saw");
        listaTerror.insert(peliculaIt);
        listaTerror.insert(peliculaAnnabelle);
        listaTerror.insert(peliculaMama);
        listaTerror.insert(peliculaVeronica);
        listaTerror.insert(peliculaSaw);

        LDEProgramas listaRomance=new LDEProgramas("Romance");
        Programa peliculaFriendsWithBenefits = new Programa("Pelicula",109,16,"Friends with Benefits");
        Programa peliculaAmar = new Programa("Pelicula",105,16,"Amar");
        Programa peliculaTheNotebook = new Programa("Pelicula",124,16,"The Notebook");
        Programa peliculaNewness = new Programa("Pelicula",112,16,"Newness");
        Programa peliculaCatchAndRelease = new Programa("Pelicula",105,16,"Catch & Release");
        listaRomance.insert(peliculaFriendsWithBenefits);
        listaRomance.insert(peliculaAmar);
        listaRomance.insert(peliculaTheNotebook);
        listaRomance.insert(peliculaNewness);
        listaRomance.insert(peliculaCatchAndRelease);

        LDEProgramas listaDocumentales=new LDEProgramas("Documentales");
        Programa peliculaPabloEscobar = new Programa("Pelicula",46,13,"Pablo Escobar");
        Programa peliculaStoryOfDiana = new Programa("Pelicula",83,13,"Story Of Diana");
        Programa peliculaGameChangers = new Programa("Pelicula",85,16,"Game Changers");
        Programa serieWorldWar = new Programa("Serie",51,13,"World War");
        Programa serieExpedientesCriminales = new Programa("Serie",46,16,"Expedientes Criminales");
        listaDocumentales.insert(peliculaPabloEscobar);
        listaDocumentales.insert(peliculaStoryOfDiana);
        listaDocumentales.insert(peliculaGameChangers);
        listaDocumentales.insert(serieWorldWar);
        listaDocumentales.insert(serieExpedientesCriminales);

        LDEProgramas listaAccion=new LDEProgramas("Acción");
        Programa peliculaParker = new Programa("Pelicula",118,18,"Parker");
        Programa peliculaSkyscraper = new Programa("Pelicula",102,18,"Skyscraper");
        Programa peliculaEscape = new Programa("Pelicula",115,18,"Escape");
        Programa peliculaPainAndGain = new Programa("Pelicula",129,18,"Pain & Gain");
        Programa peliculaLastRunway = new Programa("Pelicula",107,16,"Last Runway");
        listaAccion.insert(peliculaParker);
        listaAccion.insert(peliculaSkyscraper);
        listaAccion.insert(peliculaEscape);
        listaAccion.insert(peliculaPainAndGain);
        listaAccion.insert(peliculaLastRunway);

        LCDEGeneros listaGeneros = new LCDEGeneros();
        listaGeneros.insert(listaComedia);
        listaGeneros.insert(listaTerror);
        listaGeneros.insert(listaRomance);
        listaGeneros.insert(listaDocumentales);
        listaGeneros.insert(listaAccion);

        System.out.println(listaGeneros.toString());
        System.out.println(listaComedia.toString());
        System.out.println(listaTerror.toString());
        System.out.println(listaRomance.toString());
        System.out.println(listaDocumentales.toString());
        System.out.println(listaAccion.toString());

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
