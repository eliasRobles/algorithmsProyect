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
    private AnchorPane aP_Index;

    @FXML
    private Button bT_Movies;

    @FXML
    private Button bT_RightMovies;

    @FXML
    private Button bT_LeftMovies;

    @FXML
    private Button bT_LeftCategories;

    @FXML
    private Button bT_RightCategories;

    @FXML
    private Button bT_Categories;

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

    @FXML
    private Button bT_Continue;

    @FXML
    private Button bT_Recomendation;

    @FXML
    private Button bT_LeftContinue;

    @FXML
    private Button bT_RightContinue;

    @FXML
    private Button bT_LeftRecomendation;

    @FXML
    private Button bT_RightRecomendation;

    @FXML
    private AnchorPane aP_View;

    @FXML
    private Button bT_Movie;

    @FXML
    private Button bT_BackWatching;

    @FXML
    private Button bT_FInish;

    @FXML
    private Label lB_Tittle;

    @FXML
    private ImageView iV_Categories;

    @FXML
    private ImageView iV_Continue;

    @FXML
    private ImageView iV_ForYou;


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
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(true);//está deshabilitado para que no se vuelva atrás si está en categorias

        //inicializa los elementos del view de la pelicula desactivados
        this.bT_Movie.setVisible(false);
        this.lB_Tittle.setVisible(false);
        this.bT_BackWatching.setVisible(false);
        this.bT_FInish.setVisible(false);


        //inicializa los botones de peliculas desactivados porque estan los de categorias
        this.bT_Movies.setVisible(false);
        this.bT_RightMovies.setVisible(false);
        this.bT_LeftMovies.setVisible(false);

    }//end del initialize

    @FXML
    void bT_Categories(ActionEvent event) throws IOException {

        //quita todos los elementos de categories
        this.bT_Categories.setVisible(false);
        this.bT_RightCategories.setVisible(false);
        this.bT_LeftCategories.setVisible(false);

        //pone todos los elementos de movies
        this.bT_Movies.setVisible(true);
        this.bT_RightMovies.setVisible(true);
        this.bT_LeftMovies.setVisible(true);

        this.programaGlobal=listaGlobal.getStart();//traer el primer apuntador de peliculas
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Movies.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(false);//se habilita para volver a categorias
        this.bT_LeftMovies.setDisable(true); // por default el boton de la izquierda se deshabilita porque al inicio el before es nulo


        /*
        //lB_Title.setText("Movies");
        this.programaGlobal=listaGlobal.getStart();//traer el primer apuntador de peliculas
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

        this.bT_Back.setDisable(false);//se habilita para volver a categorias
        this.bT_LeftCategories.setDisable(true); // por default el boton de la izquierda se deshabilita porque al inicio el before es nulo

        AnchorPane index = FXMLLoader.load(getClass().getResource("View.fxml"));
        aP_Index.getChildren().setAll(index);
        */



    }//end del bT_Nodo

    @FXML
    void bT_LeftCategories(ActionEvent event) {
        //si programaGlobal es null, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.before;

            //pone la imagen de la categoria cada vez que pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, Nodo pone las peliculas
            this.programaGlobal=this.programaGlobal.before;

            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

            //deshabilita el left cada vez que se llega al final
            if(programaGlobal.before==null) {
                this.bT_LeftCategories.setDisable(true);
            }//end del if
            this.bT_RightCategories.setDisable(false);
        }//end del else
    }//end del bT_LeftCategories

    @FXML
    void bT_RightCategories(ActionEvent event) {
        //si programaGlobal es nulo, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.next;

            //pone la imagen de la categoria cada vez que se pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, que Nodo ponga las peliculas
            this.programaGlobal=this.programaGlobal.next;
            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_LeftCategories.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
            if (this.programaGlobal.next==null) {
                this.bT_RightCategories.setDisable(true);
            }//end del if
        }//end del else
    }//end del bT_RightCategories

    @FXML
    void bT_Movies(ActionEvent event) throws IOException {

        //AnchorPane index = FXMLLoader.load(getClass().getResource("View.fxml"));
        //aP_Index.getChildren().setAll(index);

        //quita los elementos del menu
        bT_Categories.setVisible(false);
        bT_LeftCategories.setVisible(false);
        bT_RightCategories.setVisible(false);
        bT_Recomendation.setVisible(false);
        bT_LeftRecomendation.setVisible(false);
        bT_RightRecomendation.setVisible(false);
        bT_Continue.setVisible(false);
        bT_RightContinue.setVisible(false);
        bT_LeftContinue.setVisible(false);
        bT_Movies.setVisible(false);
        bT_LeftMovies.setVisible(false);
        bT_RightMovies.setVisible(false);
        iV_Categories.setVisible(false);
        iV_Continue.setVisible(false);
        iV_ForYou.setVisible(false);
        bT_Back.setVisible(false);

        //trae los elementos del view de la pelicula
        this.bT_Movie.setVisible(true);
        this.lB_Tittle.setVisible(true);
        this.bT_BackWatching.setVisible(true);
        this.bT_FInish.setVisible(true);

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Movie.setBackground(new Background(new BackgroundImage(this.programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

    }//end bT_Movies

    @FXML
    void bT_LeftMovies(ActionEvent event) {

        //si programaGlobal es null, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.before;

            //pone la imagen de la categoria cada vez que pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, Nodo pone las peliculas
            this.programaGlobal=this.programaGlobal.before;

            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Movies.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

            //deshabilita el left cada vez que se llega al final
            if(programaGlobal.before==null) {
                this.bT_LeftMovies.setDisable(true);
            }//end del if
            this.bT_RightMovies.setDisable(false);
        }//end del else

    }//end bT_LeftMovies

    @FXML
    void bT_RightMovies(ActionEvent event) {

        //si programaGlobal es nulo, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.next;

            //pone la imagen de la categoria cada vez que se pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, que Nodo ponga las peliculas
            this.programaGlobal=this.programaGlobal.next;
            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Movies.setBackground(new Background(new BackgroundImage(programaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_LeftMovies.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
            if (this.programaGlobal.next==null) {
                this.bT_RightMovies.setDisable(true);
            }//end del if
        }//end del else

    }//end bT_RightMovies

    @FXML
    void bT_Back(ActionEvent event) {

        //quita todos los elementos de movies
        this.bT_Movies.setVisible(false);
        this.bT_RightMovies.setVisible(false);
        this.bT_LeftMovies.setVisible(false);

        //pone todos los elementos de categories
        this.bT_Categories.setVisible(true);
        this.bT_RightCategories.setVisible(true);
        this.bT_LeftCategories.setVisible(true);

        //vuelve a poner de fondo las imagenes de categorias
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.programaGlobal=null;//reinicializamos para que los botones derecha e izquierda funciones con categorias y no con peliculas
        this.bT_Back.setDisable(true);//cuando volvemos a categorias deshabilitamos este boton


    }//end del bT_Back

    @FXML
    void bT_BackWatching(ActionEvent event) throws IOException {

        //quita los elementos de categorias
        this.bT_Movie.setVisible(false);
        this.lB_Tittle.setVisible(false);
        this.bT_BackWatching.setVisible(false);
        this.bT_FInish.setVisible(false);

        //trae los elementos del menu
        //bT_Categories.setVisible(true);
        //bT_LeftCategories.setVisible(true);
        //bT_RightCategories.setVisible(true);
        bT_Recomendation.setVisible(true);
        bT_LeftRecomendation.setVisible(true);
        bT_RightRecomendation.setVisible(true);
        bT_Continue.setVisible(true);
        bT_RightContinue.setVisible(true);
        bT_LeftContinue.setVisible(true);
        bT_Movies.setVisible(true);
        bT_LeftMovies.setVisible(true);
        bT_RightMovies.setVisible(true);
        iV_Categories.setVisible(true);
        iV_Continue.setVisible(true);
        iV_ForYou.setVisible(true);
        bT_Back.setVisible(true);

        //vuelve a poner de fondo las imagenes de categorias
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(false);//cuando volvemos a categorias deshabilitamos este boton

    }//end del bT_BackWatching

}//end CategoryController class 293x167
