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
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    LDEProgramas listaGlobal = null;
    Programa programaGlobal=null;

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

        this.listaGlobal=listaGeneros.getStart();//que la lista global tome como inicio la lista de generos
        this.bT_Nodo.setText(listaGlobal.getGenero());//al boton Nodo le asignamos la lista
        this.bT_Back.setDisable(true);//está deshabilitado para que no se vuelva atrás si está en categorias

    }//end del initialize

    @FXML
    void bT_Nodo(ActionEvent event) throws IOException {

        lB_Title.setText("Movies");
        this.programaGlobal=listaGlobal.getStart();//traer el primer apuntador de peliculas
        this.bT_Nodo.setText(programaGlobal.nombre);
        this.bT_Back.setDisable(false);//se habilita para volver a categorias
        this.bT_Left.setDisable(true); // por default el boton de la izquierda se deshabilita porque al inicio el before es nulo

    }//end del bT_Nodo

    @FXML
    void bT_Left(ActionEvent event) {
        //si programaGlobal es null, que Nodo ponga las categorias
        if (this.programaGlobal==null) {
            this.listaGlobal=this.listaGlobal.before;
            this.bT_Nodo.setText(this.listaGlobal.getGenero());
        }else {
            //en caso contrario, Nodo pone las peliculas
            this.programaGlobal=this.programaGlobal.before;
            this.bT_Nodo.setText(this.programaGlobal.nombre);

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
            this.bT_Nodo.setText(this.listaGlobal.getGenero());
        }else {
            //en caso contrario, que Nodo ponga las peliculas
            this.programaGlobal=this.programaGlobal.next;
            this.bT_Nodo.setText(this.programaGlobal.nombre);
            this.bT_Left.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
            if (this.programaGlobal.next==null) {
                this.bT_Right.setDisable(true);
            }//end del if
        }//end del else
    }//end del bT_Right


    @FXML
    void bT_Back(ActionEvent event) {
        this.bT_Nodo.setText(this.listaGlobal.getGenero());//volver de peliculas a generos
        this.programaGlobal=null;//reinicializamos para que los botones derecha e izquierda funciones con categorias y no con peliculas
        this.bT_Back.setDisable(true);//cuando volvemos a categorias deshabilitamos este boton
        this.bT_Left.setDisable(false);//se habilita para poder usarlo en categorias
        this.bT_Right.setDisable(false);//se habilita para poder usarlo en categorias
    }//end del bT_Back

}//end CategoryController class
