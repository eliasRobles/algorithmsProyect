package Presentation;

import Domain.Account;
import Domain.Program;
import Domain.User;
import Logic.LCDEGeneros;
import Logic.LDEProgramas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    LDEProgramas listaGlobal = null;
    Program programGlobal = null;
    User userGlobal = null; //este lo hago para las pruebas
    boolean categoriesActive =true; //ESTO ES NECESARIO PARA QUE FUNCIONE CORRECTAMENTE LO DE LAS COLAS, YA QUE SE NECESITA APLICAR DISTINTOS EFECTOS

    RegisterController rC = new RegisterController();
    Account activeAccount = null;
    User activeUser = null;
    User userOne = null;
    User userTwo = null;
    User userThree = null;


    //-------------Users-------------//
    @FXML
    private AnchorPane aP_Users;

    @FXML
    private Button bT_UserTwo;

    @FXML
    private Button bT_UserOne;

    @FXML
    private Button bT_UserThree;

    @FXML
    private MenuButton mB_User;

    @FXML
    private MenuItem mI_LogOut;

    @FXML
    private Button bT_EditUser;

    @FXML
    private Label lB_UserOne;

    @FXML
    private Label lB_UserTwo;

    @FXML
    private Label lB_UserThree;
    //-------------Users-------------//


    //-------------Category-------------//
    @FXML
    private AnchorPane CategoryBase;

    @FXML
    private AnchorPane aP_Category;

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
    private Button bT_Movie;

    @FXML
    private Button bT_BackWatching;

    @FXML
    private Button bT_BackWatching2;

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

    @FXML
    private Button bT_LogOut;

    @FXML
    private MenuButton mB_CategoryUser;

    @FXML
    private MenuItem mI_SwitchUser;

    @FXML
    private MenuItem mI_CategoryLogOut;
    //-------------Category-------------//


    //-------------View-------------//
    @FXML
    private AnchorPane aP_View;

    @FXML
    private Button bT_ViewMovie;

    @FXML
    private Button bT_ViewFinish;

    @FXML
    private Label lB_Info;
    //-------------View-------------//


    //-------------Edit-------------//
    @FXML
    private AnchorPane aP_EditUser;

    @FXML
    private MenuButton mB_EditUser;

    @FXML
    private MenuItem mI_LogOut2;

    @FXML
    private TextField tF_NewName;

    @FXML
    private TextField tF_NewAge;

    @FXML
    private Button bT_Confirm;

    @FXML
    private CheckBox cB_User2;

    @FXML
    private CheckBox cB_User3;
    //-------------Edit-------------//


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
        Program peliculaFirstSunday = new Program("Pelicula",98,16,"First Sunday", FirstSunday);
        Program peliculaGrownUps = new Program("Pelicula",102,12,"Grown Ups", GrownUps);
        Program peliculaChangeUp = new Program("Pelicula",112,16,"Change Up", ChangeUp);
        Program peliculaNorbit = new Program("Pelicula",102,16,"Norbit", Norbit);
        Program peliculaWeddingRinger = new Program("Pelicula",101,14,"Wedding Ringer", WeddingRinger);
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
        Program peliculaIt = new Program("Pelicula",136,15,"It", IT);
        Program peliculaAnnabelle = new Program("Pelicula",98,15,"Annabelle", Annabelle);
        Program peliculaMama = new Program("Pelicula",100,15,"Mama", Mama);
        Program peliculaVeronica = new Program("Pelicula",102,16,"Veronica", Veronica);
        Program peliculaSaw = new Program("Pelicula",111,18,"Saw", Saw);
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
        Program peliculaFriendsWithBenefits = new Program("Pelicula",109,16,"Friends with Benefits", FriendsWithBenefits);
        Program peliculaAmar = new Program("Pelicula",105,16,"Amar", Amar);
        Program peliculaTheNotebook = new Program("Pelicula",124,16,"The Notebook", TheNotebook);
        Program peliculaNewness = new Program("Pelicula",112,16,"Newness", Newness);
        Program peliculaCatchAndRelease = new Program("Pelicula",105,16,"Catch & Release", CatchAndRelease);
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
        Program peliculaPabloEscobar = new Program("Pelicula",46,13,"Pablo Escobar", PabloEscobar);
        Program peliculaStoryOfDiana = new Program("Pelicula",83,13,"Story Of Diana", StoryOfDiana);
        Program peliculaGameChangers = new Program("Pelicula",85,16,"Game Changers", GameChangers);
        Program serieWorldWar = new Program("Serie",51,13,"World War", WorldWar);
        Program serieExpedientesCriminales = new Program("Serie",46,16,"Expedientes Criminales", ExpedientesCriminales);
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
        Program peliculaParker = new Program("Pelicula",118,18,"Parker", Parker);
        Program peliculaSkyscraper = new Program("Pelicula",102,18,"Skyscraper", Skyscraper);
        Program peliculaEscape = new Program("Pelicula",115,18,"Escape", Escape);
        Program peliculaPainAndGain = new Program("Pelicula",129,18,"Pain & Gain", PainAndGain);
        Program peliculaLastRunway = new Program("Pelicula",107,16,"Last Runway", LastRunway);
        listaAccion.insert(peliculaParker);
        listaAccion.insert(peliculaSkyscraper);
        listaAccion.insert(peliculaEscape);
        listaAccion.insert(peliculaPainAndGain);
        listaAccion.insert(peliculaLastRunway);

        //Imagenes niños:
        Image BeeMovie = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/BeeMovie.png"));
        Image JohnnyTest = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/JohnnyTest.png"));
        Image PawPatrol = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/PawPatrol.png"));
        Image Pokemo = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/Pokemo.png"));
        Image Shrek = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/Shrek.png"));

        //Inicializacion:
        Image Kids = new Image(getClass().getResourceAsStream("/Image/Icons/KIDS.png"));
        LDEProgramas listaNinos = new LDEProgramas("Kids", Kids);
        Program peliculaBeeMovie = new Program("Pelicula",118,6,"BeeMovie", BeeMovie);
        Program peliculaJohnnyTest = new Program("Pelicula",102,6,"Johnny Test", JohnnyTest);
        Program peliculaPawPatrol = new Program("Pelicula",115,6,"Paw Patrol", PawPatrol);
        Program peliculaPokemon = new Program("Pelicula",129,6,"Pokemon", Pokemo);
        Program peliculaShrek = new Program("Pelicula",107,6,"Shrek", Shrek);
        listaNinos.insert(peliculaBeeMovie);
        listaNinos.insert(peliculaJohnnyTest);
        listaNinos.insert(peliculaPawPatrol);
        listaNinos.insert(peliculaPokemon);
        listaNinos.insert(peliculaShrek);

        LCDEGeneros listaGeneros = new LCDEGeneros();
        listaGeneros.insert(listaComedia);
        listaGeneros.insert(listaTerror);
        listaGeneros.insert(listaRomance);
        listaGeneros.insert(listaDocumentales);
        listaGeneros.insert(listaAccion);
        listaGeneros.insert(listaNinos);


        //inicializacion del usuario actual:
        activeAccount = returnActiveAccount("1");
        userOne = new User(activeAccount.getName(), activeAccount.getAge());
        userTwo = new User("Teens", "15");
        userThree = new User("Kids", "6");

        this.listaGlobal=listaGeneros.getStart();//que la lista global tome como inicio la lista de generos
        //inicializamos las imagenes en el boton
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(true);//está deshabilitado para que no se vuelva atrás si está en categorias

        //inicializa los AnchorPane en false.
        this.aP_View.setVisible(false);
        this.aP_Category.setVisible(false);
        this.aP_EditUser.setVisible(false);

        //Inicializar la imagen de user:
        Image user = new Image(getClass().getResourceAsStream("/Image/Icons/users.png"));
        //Inicializa los elementos de la ventana Users
        mB_User.setText(activeAccount.getUsername());
        lB_UserOne.setText(userOne.getName());
        lB_UserOne.setAlignment(Pos.CENTER);
        bT_UserOne.setBackground(new Background(new BackgroundImage(user, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

        lB_UserTwo.setText(userTwo.getName());
        lB_UserTwo.setAlignment(Pos.CENTER);
        bT_UserTwo.setBackground(new Background(new BackgroundImage(user, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

        lB_UserThree.setText(userThree.getName());
        lB_UserThree.setAlignment(Pos.CENTER);
        bT_UserThree.setBackground(new Background(new BackgroundImage(user, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

        //inicializa los botones de peliculas desactivados porque estan los de categorias
        this.bT_Movies.setVisible(false);
        this.bT_RightMovies.setVisible(false);
        this.bT_LeftMovies.setVisible(false);
        this.bT_Back.setDisable(true);
        this.bT_LogOut.setVisible(false);
        this.bT_LogOut.setDisable(true);
        this.bT_LeftContinue.setDisable(true);
        this.bT_BackWatching2.setVisible(false);
        this.bT_BackWatching2.setDisable(true);


        //--------------------------PRUEBAS--------------------------PRUEBAS--------------------------PRUEBAS--------------------------
        //Este usuario es para las pruebas
        User u = new User("Pedro", "28");
        /*
        u.getColaPrioridad().encolar(peliculaFirstSunday);
        u.getColaPrioridad().encolar(peliculaIt);
        u.getColaPrioridad().encolar(peliculaNewness);
        */
        this.userGlobal = u;
        //NOTA: acá modifiqué el código para que se cree un usuario con cola vacía, y que estas se vayan agregando conforme uno hace pruebas
        if (this.userGlobal.getColaPrioridad().isEmpty()) {
            this.bT_Continue.setDisable(true);
            this.bT_RightContinue.setDisable(true);
        }else {
            //Este carga la primera imagen sea por defecto, aquí se haría la validación de que si es null, se cargue una por defecto y se deshabiliten los botones.
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.userGlobal.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }//else
        //--------------------------PRUEBAS--------------------------PRUEBAS--------------------------PRUEBAS--------------------------
    }//end del initialize


    //-------------Users Methods-------------//
    @FXML
    void bT_EditUser(ActionEvent event) {
        this.aP_Users.setVisible(false);
        this.aP_EditUser.setVisible(true);
        mB_EditUser.setText(activeAccount.getUsername());
    }//end EditUser

    @FXML
    void bT_UserOne(ActionEvent event) {

        activeUser = userOne;

        aP_Users.setVisible(false);
        aP_Category.setVisible(true);
        mB_CategoryUser.setText(userOne.getName());

    }//end bT_UserOne

    @FXML
    void bT_UserTwo(ActionEvent event) {

        activeUser = userTwo;

        aP_Users.setVisible(false);
        aP_Category.setVisible(true);
        mB_CategoryUser.setText(userTwo.getName());

    }//end bT_UserTwo

    @FXML
    void bT_UserThree(ActionEvent event) {

        activeUser = userThree;

        aP_Users.setVisible(false);
        aP_Category.setVisible(true);
        mB_CategoryUser.setText(userThree.getName());

    }//end bT_UserThree
    //-------------Users Methods-------------//


    //-------------Category Methods-------------//
    @FXML
    void bT_LogOut(ActionEvent event) throws IOException {

        //Recoge toda la informacion de la cuenta para volver a escribirla, pero con el 1 de actividad
        String name = activeAccount.getName();
        String username = activeAccount.getUsername();
        String password = activeAccount.getPassword();
        String age = activeAccount.getAge();
        String gender = activeAccount.getGender();
        String cardNumber = activeAccount.getCardNumber();
        String cv = activeAccount.getCv();
        String expireDate = activeAccount.getExpireDate();
        String status = "0";//significa que el usuario esta inactivo

        //Crea un nuevo account, se llama al metodo que reescribe y lo reescribe
        Account account = new Account(name, username, password, age, gender, cardNumber, cv, expireDate, status);
        rewriteAccount(activeAccount.getName(), account);

        Stage stage = (Stage) bT_LogOut.getScene().getWindow();
        stage.setWidth(657);
        stage.setHeight(760);
        stage.setTitle("MediaStream | Log In");
        stage.centerOnScreen();
        AnchorPane pane = FXMLLoader.load(IndexController.class.getResource("Login.fxml"));
        CategoryBase.getChildren().setAll(pane);

    }//end LogOut

    @FXML
    void bT_SwitchUser(ActionEvent event) {

        aP_Category.setVisible(false);
        aP_Users.setVisible(true);

    }//end bT_SwitchUser

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
        this.bT_Back.setDisable(false);

        this.programGlobal =listaGlobal.getStart();//traer el primer apuntador de peliculas
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Movies.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(false);//se habilita para volver a categorias
        this.bT_LeftMovies.setDisable(true); // por default el boton de la izquierda se deshabilita porque al inicio el before es nulo

        this.categoriesActive= false;//ESTO indica que ya no está activo el botón de categorías

    }//end del bT_Nodo

    @FXML
    void bT_LeftCategories(ActionEvent event) {
        //si programaGlobal es null, que Nodo ponga las categorias
        if (this.programGlobal ==null) {
            this.listaGlobal=this.listaGlobal.before;

            //pone la imagen de la categoria cada vez que pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, Nodo pone las peliculas
            this.programGlobal =this.programGlobal.before;

            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

            //deshabilita el left cada vez que se llega al final
            if(programGlobal.before==null) {
                this.bT_LeftCategories.setDisable(true);
            }//end del if
            this.bT_RightCategories.setDisable(false);
        }//end del else
    }//end del bT_LeftCategories

    @FXML
    void bT_RightCategories(ActionEvent event) {
        //si programaGlobal es nulo, que Nodo ponga las categorias
        if (this.programGlobal ==null) {
            this.listaGlobal=this.listaGlobal.next;

            //pone la imagen de la categoria cada vez que se pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, que Nodo ponga las peliculas
            this.programGlobal =this.programGlobal.next;
            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_LeftCategories.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
            if (this.programGlobal.next==null) {
                this.bT_RightCategories.setDisable(true);
            }//end del if
        }//end del else
    }//end del bT_RightCategories

    @FXML
    void bT_Movies(ActionEvent event) throws IOException {

        aP_Category.setVisible(false);
        aP_View.setVisible(true);
        bT_BackWatching.setVisible(true);
        bT_BackWatching.setDisable(false);

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_ViewMovie.setBackground(new Background(new BackgroundImage(this.programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.lB_Info.setText("Now watching \n" +
                            this.programGlobal.nombre + ".\n" +
                            "\n" +
                            this.programGlobal.duracion + " min.\n" +
                            "\n" +
                            "For older than " + this.programGlobal.restriccion +
                            "\nyears old.");

    }//end bT_Movies

    @FXML
    void bT_LeftMovies(ActionEvent event) {

        //si programaGlobal es null, que Nodo ponga las categorias
        if (this.programGlobal ==null) {
            this.listaGlobal=this.listaGlobal.before;

            //pone la imagen de la categoria cada vez que pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, Nodo pone las peliculas
            this.programGlobal =this.programGlobal.before;

            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Movies.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

            //deshabilita el left cada vez que se llega al final
            if(programGlobal.before==null) {
                this.bT_LeftMovies.setDisable(true);
            }//end del if
            this.bT_RightMovies.setDisable(false);
        }//end del else

    }//end bT_LeftMovies

    @FXML
    void bT_RightMovies(ActionEvent event) {

        //si programaGlobal es nulo, que Nodo ponga las categorias
        if (this.programGlobal ==null) {
            this.listaGlobal=this.listaGlobal.next;

            //pone la imagen de la categoria cada vez que se pasa de categoria
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaGlobal.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }else {
            //en caso contrario, que Nodo ponga las peliculas
            this.programGlobal =this.programGlobal.next;
            //Poner de fondo del boton la imagen de la pelicula
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Movies.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_LeftMovies.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
            if (this.programGlobal.next==null) {
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
        this.programGlobal =null;//reinicializamos para que los botones derecha e izquierda funciones con categorias y no con peliculas
        this.bT_Back.setDisable(true);//cuando volvemos a categorias deshabilitamos este boton

        this.categoriesActive= true;//ESTO significa que volvemos a estar en las categorías, por lo que se hace menos proceso al usar lo de la cola,
        //es decir, con respecto a la interfaz gráfica.

    }//end del bT_Back

    @FXML
    void bT_BackWatching(ActionEvent event) throws IOException {

        //quita los elementos de view
        aP_View.setVisible(false);
        //pone elementos de categorys
        aP_Category.setVisible(true);

        //vuelve a poner de fondo las imagenes de categorias
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(false);//cuando volvemos a categorias deshabilitamos este boton

        //--------------------------------
        //Este IF permite que cuando se presione el back de cuando la pelicula se está vizualizando, si dicho programa no fue finalizado
        //Este se agregue a la cola y ya esté disponible tanto el botón de derecha de la cola y la cola como tal
        if (this.programGlobal.isVisto()==false){
            this.userGlobal.getColaPrioridad().encolar(this.programGlobal);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.userGlobal.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_RightContinue.setDisable(false);
            this.bT_Continue.setDisable(false);
        }//if
        //--------------------------------

    }//end del bT_BackWatching

    @FXML
    void bT_LeftContinue(ActionEvent event) throws IOException {}//end del bT_LeftContinue

    @FXML
    void bT_RightContinue(ActionEvent event) throws IOException {
        //Esto permite que se encole el head y se mueva el head a la siguiente
        this.userGlobal.getColaPrioridad().encolar(this.userGlobal.getColaPrioridad().desencolar());
        //Esto permite que se carguen las imagenes del siguiente programa
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Continue.setBackground(new Background(new BackgroundImage(this.userGlobal.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        //System.out.println("boton derecha continuo");
    }//end del bT_LeftContinue

    @FXML
    void bT_Continue(ActionEvent event) throws IOException {
        //NOTA: Acá utilizo el mismo código de lo del bt_Movie, solo que agrego el botón respectivo

        //quita los elementos del menu
        aP_Category.setVisible(false);
        //trae los elementos del view de la pelicula
        aP_View.setVisible(true);
        this.bT_BackWatching.setVisible(false);
        this.bT_BackWatching.setDisable(true);

        this.bT_BackWatching2.setVisible(true);
        this.bT_BackWatching2.setDisable(false);

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        //Se usa el mismo bt_Movie porque es igual que el de arriba.
        this.bT_ViewMovie.setBackground(new Background(new BackgroundImage(this.userGlobal.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.lB_Info.setText("Now watching \n" +
                this.userGlobal.getColaPrioridad().head().nombre + ".\n" +
                "\n" +
                this.userGlobal.getColaPrioridad().head().duracion + " min.\n" +
                "\n" +
                "For older than " + this.userGlobal.getColaPrioridad().head().restriccion +
                "\nyears old.");

    }//end del bT_BackWatching

    @FXML
    void bT_BackWatching2(ActionEvent event) throws IOException {

        if (this.categoriesActive){ // ESTE IF dice que, si el botón de las categorias es el que se está mostrando, entonces,
            //cuando estamos viendo la película derectamente, pero de las colas, solo debemos quitar ese botón y esos datos,
            //y cargar lo anterior, sin hacer nada más

            //quita los elementos de categorias
            aP_View.setVisible(false);

            //trae los elementos del menu
            aP_Category.setVisible(true);

            //vuelve a poner de fondo las imagenes de categorias
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Back.setDisable(true);//cuando volvemos a categorias deshabilitamos este boton

        }else {// PERO, si el botón de las películas es el activo, se debe hacer lo mismo, pero también se fdebe llamar al método
            //de bt_Back, lo que permite que se carge BIEN la cuestión de las categorías.
            //quita los elementos de categorias
            aP_View.setVisible(false);

            //trae los elementos del menu
            aP_Category.setVisible(true);

            //vuelve a poner de fondo las imagenes de categorias
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(listaGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Back.setDisable(false);//cuando volvemos a categorias deshabilitamos este boton

            //SE llama a bt_Back
            this.bT_Back(event);
        }//endElse
        this.bT_BackWatching2.setVisible(false);
        this.bT_BackWatching2.setDisable(true);
        //NOTA: En este método no es necesario cambiar a categorieActive ya que cono solo el cambio anterior es suficiente.
    }//end del bT_BackWatching
    //-------------Category Methods-------------//


    //-------------Edit Methods-------------//
    @FXML
    void bT_Confirm(ActionEvent event) {

        String newName = tF_NewName.getText();
        String newAge = tF_NewName.getText();

        if(cB_User2.isSelected()){
            userTwo = new User(newName, newAge);
            lB_UserTwo.setText(newName);
        }//end if
        else if(cB_User3.isSelected()){
            userThree = new User(newName, newAge);
            lB_UserThree.setText(newName);
        }//end else

        aP_EditUser.setVisible(false);
        aP_Users.setVisible(true);

        tF_NewAge.clear();
        tF_NewName.clear();
        cB_User3.setSelected(false);
        cB_User2.setSelected(false);
        cB_User2.setDisable(false);
        cB_User3.setDisable(false);
        cB_User2.setDisable(false);

    }//end bT_Confirm

    @FXML
    void cB_User2(ActionEvent event) {

        cB_User3.setDisable(true);

    }//end cB_User2

    @FXML
    void cB_User3(ActionEvent event) {

        cB_User2.setDisable(true);

    }//end cB_User3
    //-------------Edit Methods-------------//


    //Metodos auxiliares:
    public Account returnActiveAccount(String status){

        Account array[] = rC.getRegisterFile();

        for (int i = 0; i < array.length; i++) {
            if(array[i].getStatus().equals(status))
                return array[i];
        }//end for

        return null;

    }//end returnUsername

    public void rewriteAccount(String name, Account account) {

        String changes = account.toString();

        File fileAccount = new File("accounts.txt");

        try {

            File file = new File("accounts.txt");

            File temp = File.createTempFile("accounts", ".txt", file.getParentFile());
            String charset = "UTF-8";

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));

            for (String line; (line = br.readLine()) != null;) {

                if (line.contains(name)) {
                    line = line.replace(line, changes);
                    writer.println(line);
                } else {
                    writer.println(line.trim());
                }
            }//end for

            br.close();
            writer.close();
            file.delete();
            temp.renameTo(file);

        }//End Try
        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

    }//end editACountry

}//end CategoryController class 293x167
