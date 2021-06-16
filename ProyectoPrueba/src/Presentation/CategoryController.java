package Presentation;

import Domain.Programa;
import Logic.LCDEGeneros;
import Logic.LDEProgramas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    LDEProgramas listaGlobal = null;
    Programa programaGlobal=null;
    //Necesitaremos un usuarioGlobal que es el que está logueado, para acceder a la cola de prioridad de este
    @FXML
    private Button bT_Left;

    @FXML
    private Button bT_Right;

    @FXML
    private Label lB_Title;

    @FXML
    private Button bT_Nodo;

    @FXML
    private MenuBar mB_Menu;

    @FXML
    private Menu m_Back;

    @FXML
    private Menu m_Account;

    @FXML
    private Menu m_Help;

    @FXML
    private Button bT_Back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Imagenes de comedia:
        Image FirstSunday = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/FirstSunday.png"));
        Image GrownUps = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/GrownUps.png"));
        Image ChangeUp = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/ChangeUp.png"));
        Image Norbit = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/Norbit.png"));
        Image WeddingRinger = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/WeddingRinger.png"));

        //Inicialización:
        Image Comedy = new Image(getClass().getResourceAsStream("/Image/Icons/Comedy.png"));
        LDEProgramas listaComedia=new LDEProgramas("Comedia", Comedy);
        Programa peliculaFirstSunday = new Programa("Pelicula",98,16,"First Sunday", FirstSunday);
        Programa peliculaGrownUps = new Programa("Pelicula",102,12,"Grown Ups", GrownUps);
        Programa peliculaChangeUp = new Programa("Pelicula",112,16,"Change Up", ChangeUp);
        Programa peliculaNorbit = new Programa("Pelicula",102,16,"Norbit", Norbit);
        Programa peliculaWeddingRinger = new Programa("Pelicula",101,14,"Wedding Ringer", WeddingRinger);
        listaComedia.insert(peliculaFirstSunday);
        listaComedia.insert(peliculaGrownUps);
        listaComedia.insert(peliculaChangeUp);
        listaComedia.insert(peliculaNorbit);
        listaComedia.insert(peliculaWeddingRinger);

        //Imagenes de terror:
        Image IT = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/IT.png"));
        Image Annabelle = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Annabelle.png"));
        Image Mama = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Mama.png"));
        Image Veronica = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Veronica.png"));
        Image Saw = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Saw.png"));

        //Inicializacion:
        Image Horror = new Image(getClass().getResourceAsStream("/Image/Icons/Horror.png"));
        LDEProgramas listaTerror=new LDEProgramas("Terror", Horror);
        Programa peliculaIt = new Programa("Pelicula",136,15,"It", IT);
        Programa peliculaAnnabelle = new Programa("Pelicula",98,15,"Annabelle", Annabelle);
        Programa peliculaMama = new Programa("Pelicula",100,15,"Mama", Mama);
        Programa peliculaVeronica = new Programa("Pelicula",102,16,"Veronica", Veronica);
        Programa peliculaSaw = new Programa("Pelicula",111,18,"Saw", Saw);
        listaTerror.insert(peliculaIt);
        listaTerror.insert(peliculaAnnabelle);
        listaTerror.insert(peliculaMama);
        listaTerror.insert(peliculaVeronica);
        listaTerror.insert(peliculaSaw);

        //Imagenes de romance:
        Image FriendsWithBenefits = new Image(getClass().getResourceAsStream("/Image/Movies/Love/FriendsWithBenefits.png"));
        Image Amar = new Image(getClass().getResourceAsStream("/Image/Movies/Love/Amar.png"));
        Image TheNotebook = new Image(getClass().getResourceAsStream("/Image/Movies/Love/TheNotebook.png"));
        Image Newness = new Image(getClass().getResourceAsStream("/Image/Movies/Love/Newness.png"));
        Image CatchAndRelease = new Image(getClass().getResourceAsStream("/Image/Movies/Love/Catch&Release.png"));

        //Inicializacion:
        Image Love = new Image(getClass().getResourceAsStream("/Image/Icons/Love.png"));
        LDEProgramas listaRomance=new LDEProgramas("Romance", Love);
        Programa peliculaFriendsWithBenefits = new Programa("Pelicula",109,16,"Friends with Benefits", FriendsWithBenefits);
        Programa peliculaAmar = new Programa("Pelicula",105,16,"Amar", Amar);
        Programa peliculaTheNotebook = new Programa("Pelicula",124,16,"The Notebook", TheNotebook);
        Programa peliculaNewness = new Programa("Pelicula",112,16,"Newness", Newness);
        Programa peliculaCatchAndRelease = new Programa("Pelicula",105,16,"Catch & Release", CatchAndRelease);
        listaRomance.insert(peliculaFriendsWithBenefits);
        listaRomance.insert(peliculaAmar);
        listaRomance.insert(peliculaTheNotebook);
        listaRomance.insert(peliculaNewness);
        listaRomance.insert(peliculaCatchAndRelease);

        //Imagenes de Documentales:
        Image PabloEscobar = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/PabloEscobar.png"));
        Image StoryOfDiana = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/StoryOfDiana.png"));
        Image GameChangers = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/GameChangers.png"));
        Image WorldWar = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/WorldWar.png"));
        Image ExpedientesCriminales = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/ExpedientesCriminales.png"));

        //Inicializacion:
        Image Documentaries = new Image(getClass().getResourceAsStream("/Image/Icons/Documentaries.png"));
        LDEProgramas listaDocumentales=new LDEProgramas("Documentales", Documentaries);
        Programa peliculaPabloEscobar = new Programa("Pelicula",46,13,"Pablo Escobar", PabloEscobar);
        Programa peliculaStoryOfDiana = new Programa("Pelicula",83,13,"Story Of Diana", StoryOfDiana);
        Programa peliculaGameChangers = new Programa("Pelicula",85,16,"Game Changers", GameChangers);
        Programa serieWorldWar = new Programa("Serie",51,13,"World War", WorldWar);
        Programa serieExpedientesCriminales = new Programa("Serie",46,16,"Expedientes Criminales", ExpedientesCriminales);
        listaDocumentales.insert(peliculaPabloEscobar);
        listaDocumentales.insert(peliculaStoryOfDiana);
        listaDocumentales.insert(peliculaGameChangers);
        listaDocumentales.insert(serieWorldWar);
        listaDocumentales.insert(serieExpedientesCriminales);

        //Imagenes de accion:
        Image Parker = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Parker.png"));
        Image Skyscraper = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Skyscraper.png"));
        Image Escape = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Escape.png"));
        Image PainAndGain = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Pain&Gain.png"));
        Image LastRunway = new Image(getClass().getResourceAsStream("/Image/Movies/Action/LastRunway.png"));

        //Inicializacion:
        Image Action = new Image(getClass().getResourceAsStream("/Image/Icons/Action.png"));
        LDEProgramas listaAccion=new LDEProgramas("Acción", Action);
        Programa peliculaParker = new Programa("Pelicula",118,18,"Parker", Parker);
        Programa peliculaSkyscraper = new Programa("Pelicula",102,18,"Skyscraper", Skyscraper);
        Programa peliculaEscape = new Programa("Pelicula",115,18,"Escape", Escape);
        Programa peliculaPainAndGain = new Programa("Pelicula",129,18,"Pain & Gain", PainAndGain);
        Programa peliculaLastRunway = new Programa("Pelicula",107,16,"Last Runway", LastRunway);
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

        this.listaGlobal=listaGeneros.getStart();//que la lista global tome como inicio la lista de generos
        //inicializamos las imagenes en el boton
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Nodo.setBackground(new Background(new BackgroundImage(listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(true);//está deshabilitado para que no se vuelva atrás si está en categorias

    }//end del initialize

    @FXML
    void bT_Nodo(ActionEvent event) throws IOException {

        lB_Title.setText("Movies");
        this.programaGlobal=listaGlobal.getStart();//traer el primer apuntador de peliculas
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Nodo.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

        this.bT_Back.setDisable(false);//se habilita para volver a categorias
        this.bT_Left.setDisable(true); // por default el boton de la izquierda se deshabilita porque al inicio el before es nulo

    }//end del bT_Nodo

    @FXML
    void bT_Left(ActionEvent event) {
        //si programaGlobal es null, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.before;

            //pone la imagen de la categoria cada vez que pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Nodo.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, Nodo pone las peliculas
            this.programaGlobal=this.programaGlobal.before;

            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Nodo.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

            //deshabilita el left cada vez que se llega al final
            if(programaGlobal.before==null) {
                this.bT_Left.setDisable(true);
            }//end del if
            this.bT_Right.setDisable(false);
        }//end del else
    }//end del bT_Left

    @FXML
    void bT_Right(ActionEvent event) {
        //si programaGlobal es nulo, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.next;

            //pone la imagen de la categoria cada vez que se pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Nodo.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, que Nodo ponga las peliculas
            this.programaGlobal=this.programaGlobal.next;
            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Nodo.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Left.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
            if (this.programaGlobal.next==null) {
                this.bT_Right.setDisable(true);
            }//end del if
        }//end del else
    }//end del bT_Right


    @FXML
    void bT_Back(ActionEvent event) {
        lB_Title.setText("Categories");
        //vuelve a poner de fondo las imagenes de categorias
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Nodo.setBackground(new Background(new BackgroundImage(listaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.programaGlobal=null;//reinicializamos para que los botones derecha e izquierda funciones con categorias y no con peliculas
        this.bT_Back.setDisable(true);//cuando volvemos a categorias deshabilitamos este boton
        //Poner de fondo del boton la imagen de la pelicula
        this.bT_Left.setDisable(false);//se habilita para poder usarlo en categorias
        this.bT_Right.setDisable(false);//se habilita para poder usarlo en categorias
    }//end del bT_Back

}//end CategoryController class
