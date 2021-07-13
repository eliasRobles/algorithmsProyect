package Presentation;

import Business.StatusBusiness;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    LCDEGeneros listaGenerosGlobal = null;
    LDEProgramas listaProgramasActiva = null;
    Program programGlobal = null;
    boolean categoriesActive =true; //ESTO ES NECESARIO PARA QUE FUNCIONE CORRECTAMENTE LO DE LAS COLAS, YA QUE SE NECESITA APLICAR DISTINTOS EFECTOS
    boolean activeRecomendation = false;
    RegisterController rC = new RegisterController();
    Account activeAccount = null;
    User activeUser = null;
    User userOne = null;
    User userTwo = null;
    User userThree = null;


    //-------------Users-------------//
    @FXML
    private AnchorPane CategoryBase;

    @FXML
    private AnchorPane aP_View;

    @FXML
    private Button bT_ViewMovie;

    @FXML
    private Button bT_BackWatching;

    @FXML
    private Button bT_ViewFinish;

    @FXML
    private Button bT_BackWatching2;

    @FXML
    private Label lB_Info;

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
    private ImageView iV_Categories;

    @FXML
    private ImageView iV_Continue;

    @FXML
    private ImageView iV_ForYou;

    @FXML
    private MenuButton mB_CategoryUser;

    @FXML
    private MenuItem mI_SwitchUser;

    @FXML
    private MenuItem mI_LogOut1;

    @FXML
    private Button bT_LogOut;

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

    @FXML
    private AnchorPane aP_Users;

    @FXML
    private Button bT_UserOne;

    @FXML
    private Button bT_UserThree;

    @FXML
    private Button bT_EditUser;

    @FXML
    private Label lB_UserOne;

    @FXML
    private Label lB_UserTwo;

    @FXML
    private Label lB_UserThree;

    @FXML
    private MenuButton mB_User;

    @FXML
    private MenuItem mI_LogOut;

    @FXML
    private Button bT_UserTwo;

    @FXML
    private Button bT_ViewFinish2;

    @FXML
    private Button bT_ViewFinish3;

    //-------------Edit-------------//

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.uptadeData(18); //Inicializamos todas las listas al inicio con 18, para que se carguen todas
        //inicializacion del usuario actual:
        activeAccount = returnActiveAccount("1");//obtenemos la cuenta activa

        userOne = new User(activeAccount.getName(), activeAccount.getAge());
        this.activeUser = userOne; //Esto es necesario para que el programa no se caiga y no trabaje con nulls
        userTwo = new User("Teens", "15");
        userThree = new User("Kids", "6");

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

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
        this.bT_LeftContinue.setVisible(false);
        this.bT_LeftRecomendation.setDisable(true);
        this.bT_LeftRecomendation.setVisible(false);
        this.bT_BackWatching2.setVisible(false);
        this.bT_BackWatching2.setDisable(true);

        //cargar imagen
        Image base = new Image(getClass().getResourceAsStream("/Image/Movies/base.png"));
        bT_Continue.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        bT_Recomendation.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

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
        //this.activeUser.getColaPrioridad().cancel();
        if (this.activeUser.getColaPrioridad().isEmpty()) { //hacemos que sus botones se deshabiliten
            this.bT_Continue.setDisable(true);
            this.bT_RightContinue.setDisable(true);
        }else{
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Continue.setDisable(false);
            this.bT_RightContinue.setDisable(false);
        }//else
        if (this.activeUser.getGrafoRecomendacion().getColaAlmacen().isEmpty()){
           this.bT_RightRecomendation.setDisable(true);
           this.bT_Recomendation.setDisable(true);
        }else {
           BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
           this.bT_Recomendation.setBackground(new Background(new BackgroundImage(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
           this.bT_Recomendation.setDisable(false);
           this.bT_RightRecomendation.setDisable(false);
        }//else

        this.uptadeData(Integer.parseInt(activeUser.getAge())); //cargamos las listas con los datos del usuario
        aP_Users.setVisible(false);
        aP_Category.setVisible(true);
        mB_CategoryUser.setText(activeAccount.getUsername());

    }//end bT_UserOne

    @FXML
    void bT_UserTwo(ActionEvent event) {

        activeUser = userTwo;
        //this.activeUser.getColaPrioridad().cancel();
        if (this.activeUser.getColaPrioridad().isEmpty()) {
            this.bT_Continue.setDisable(true);
            this.bT_RightContinue.setDisable(true);
        }else{
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Continue.setDisable(false);
            this.bT_RightContinue.setDisable(false);
        }//else
        if (this.activeUser.getGrafoRecomendacion().getColaAlmacen().isEmpty()){
            this.bT_RightRecomendation.setDisable(true);
            this.bT_Recomendation.setDisable(true);
        }else {
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Recomendation.setBackground(new Background(new BackgroundImage(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Recomendation.setDisable(false);
            this.bT_RightRecomendation.setDisable(false);
        }//else

        this.uptadeData(Integer.parseInt(activeUser.getAge()));
        aP_Users.setVisible(false);
        aP_Category.setVisible(true);
        mB_CategoryUser.setText(userTwo.getName());

    }//end bT_UserTwo

    @FXML
    void bT_UserThree(ActionEvent event) {

        activeUser = userThree;
        //this.activeUser.getColaPrioridad().cancel();
        if (this.activeUser.getColaPrioridad().isEmpty()) {
            this.bT_Continue.setDisable(true);
            this.bT_RightContinue.setDisable(true);
        }else{
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Continue.setDisable(false);
            this.bT_RightContinue.setDisable(false);
        }//else

        if (this.activeUser.getGrafoRecomendacion().getColaAlmacen().isEmpty()){
            this.bT_RightRecomendation.setDisable(true);
            this.bT_Recomendation.setDisable(true);
        }else {
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Recomendation.setBackground(new Background(new BackgroundImage(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Recomendation.setDisable(false);
            this.bT_RightRecomendation.setDisable(false);
        }//else

        this.uptadeData(Integer.parseInt(activeUser.getAge()));
        aP_Users.setVisible(false);
        aP_Category.setVisible(true);
        mB_CategoryUser.setText(userThree.getName());

    }//end bT_UserThree
    //-------------Users Methods-------------//


    //-------------Category Methods-------------//
    @FXML
    void bT_LogOut(ActionEvent event) throws IOException {
        //Hacemos que el usuario ya no sea el activo
        Account[] array = rC.getRegisterFile();
        try {
            StatusBusiness statusBusiness = new StatusBusiness();
            ArrayList<Integer> posiciones = (ArrayList<Integer>) statusBusiness.retornarPosiciones();
            for (int i = 0; i < array.length; i++) {//Obtenemos los usuarios, y el que tenga la misma posicion en el
                //ArrayList de status es el activo, por lo que se pone en 0
                if (array[i].getUsername().equals(this.activeAccount.getUsername())){
                    statusBusiness.logOut(i, posiciones);
                    break;
                }//if
            }//for
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }//try-catch

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
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        Image base = new Image(getClass().getResourceAsStream("/Image/Movies/base.png"));
        bT_Continue.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        bT_Recomendation.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

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

        this.programGlobal = listaProgramasActiva.getStart();//traer el primer apuntador de peliculas
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Movies.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(false);//se habilita para volver a categorias
        this.bT_LeftMovies.setDisable(true); // por default el boton de la izquierda se deshabilita porque al inicio el before es nulo
        if (this.listaProgramasActiva.getSize()>1){ //Este if es MUY necesario, ya que sino se puede bloquear el boton de la derecha de movies aunque este no deba
            this.bT_RightMovies.setDisable(false);
        }else {
            this.bT_RightMovies.setDisable(true);
        }//else
        this.categoriesActive= false;//ESTO indica que ya no está activo el botón de categorías

    }//end del bT_Categories

    @FXML
    void bT_LeftCategories(ActionEvent event) {
        this.listaProgramasActiva =this.listaProgramasActiva.before;
        //pone la imagen de la categoria cada vez que pasa de categoria
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaProgramasActiva.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
    }//end del bT_LeftCategories

    @FXML
    void bT_RightCategories(ActionEvent event) {
        this.listaProgramasActiva =this.listaProgramasActiva.next;
        //pone la imagen de la categoria cada vez que se pasa de categoria
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(this.listaProgramasActiva.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
    }//end del bT_RightCategories

    @FXML
    void bT_Movies(ActionEvent event) throws IOException {

        aP_Category.setVisible(false);
        aP_View.setVisible(true);
        bT_BackWatching.setVisible(true);
        bT_BackWatching.setDisable(false);

        this.bT_ViewFinish3.setDisable(true);
        this.bT_ViewFinish3.setVisible(false);
        this.bT_ViewFinish2.setDisable(true);
        this.bT_ViewFinish2.setVisible(false);
        //ponemos visible el finish respectivo
        this.bT_ViewFinish.setDisable(false);
        this.bT_ViewFinish.setVisible(true);

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
        this.programGlobal =this.programGlobal.before;
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Movies.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        //deshabilita el left cada vez que se llega al final
        if(programGlobal.before==null) {
            this.bT_LeftMovies.setDisable(true);
        }//end del if
        this.bT_RightMovies.setDisable(false);
    }//end bT_LeftMovies

    @FXML
    void bT_RightMovies(ActionEvent event) {
        this.programGlobal =this.programGlobal.next;
        //Poner de fondo del boton la imagen de la pelicula
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Movies.setBackground(new Background(new BackgroundImage(programGlobal.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_LeftMovies.setDisable(false);//habilitamos el boton de la izquierda apenas nos corremos una posicion en la lista
        if (this.programGlobal.next==null) {
            this.bT_RightMovies.setDisable(true);
        }//end del if
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
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaProgramasActiva.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
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
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaProgramasActiva.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(false);//cuando volvemos a categorias deshabilitamos este boton

        //Este IF permite que cuando se presione el back de cuando la pelicula se está vizualizando, si dicho programa no fue finalizado
        //Este se agregue a la cola y ya esté disponible tanto el botón de derecha de la cola y la cola como tal
        if (this.programGlobal.isVisto()==false){
            this.activeUser.getColaPrioridad().encolar(this.programGlobal);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_RightContinue.setDisable(false);
            this.bT_Continue.setDisable(false);
        }//if

    }//end del bT_BackWatching

    @FXML
    void bT_LeftContinue (ActionEvent event){

    }

    @FXML
    void bt_FInish(ActionEvent event) throws IOException {
        this.programGlobal.setVisto(true);
        this.activeUser.getGrafoRecomendacion().agregaVertice(this.programGlobal);//Es necesario preguntar por el genero del programa, ya que sino entrara siempre en el primer if
        if (this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen())!=null){
            if (this.programGlobal.genero.equals("comedia")&&this.activeUser.getGrafoRecomendacion().getcComedia()>this.activeUser.getGrafoRecomendacion().getcTerror() && this.activeUser.getGrafoRecomendacion().getcComedia()>this.activeUser.getGrafoRecomendacion().getcRomance() && this.activeUser.getGrafoRecomendacion().getcComedia()>this.activeUser.getGrafoRecomendacion().getcDocumental() && this.activeUser.getGrafoRecomendacion().getcComedia()>this.activeUser.getGrafoRecomendacion().getcAccion() && this.activeUser.getGrafoRecomendacion().getcComedia()>this.activeUser.getGrafoRecomendacion().getcKid()){
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen()));
            }else if (this.programGlobal.genero.equals("romance")&&this.activeUser.getGrafoRecomendacion().getcRomance()>this.activeUser.getGrafoRecomendacion().getcComedia() && this.activeUser.getGrafoRecomendacion().getcRomance()>this.activeUser.getGrafoRecomendacion().getcTerror() && this.activeUser.getGrafoRecomendacion().getcRomance()>this.activeUser.getGrafoRecomendacion().getcDocumental() && this.activeUser.getGrafoRecomendacion().getcRomance()>this.activeUser.getGrafoRecomendacion().getcAccion() && this.activeUser.getGrafoRecomendacion().getcRomance()>this.activeUser.getGrafoRecomendacion().getcKid() ){
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen()));
            }else if (this.programGlobal.genero.equals("documental")&&this.activeUser.getGrafoRecomendacion().getcDocumental()>this.activeUser.getGrafoRecomendacion().getcTerror() && this.activeUser.getGrafoRecomendacion().getcDocumental()>this.activeUser.getGrafoRecomendacion().getcRomance() && this.activeUser.getGrafoRecomendacion().getcDocumental()>this.activeUser.getGrafoRecomendacion().getcComedia() && this.activeUser.getGrafoRecomendacion().getcDocumental()>this.activeUser.getGrafoRecomendacion().getcAccion()&& this.activeUser.getGrafoRecomendacion().getcDocumental()>this.activeUser.getGrafoRecomendacion().getcKid() ) {
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen()));
            }else if (this.programGlobal.genero.equals("accion")&&this.activeUser.getGrafoRecomendacion().getcAccion()>this.activeUser.getGrafoRecomendacion().getcTerror() && this.activeUser.getGrafoRecomendacion().getcAccion()>this.activeUser.getGrafoRecomendacion().getcRomance() && this.activeUser.getGrafoRecomendacion().getcAccion()>this.activeUser.getGrafoRecomendacion().getcDocumental() && this.activeUser.getGrafoRecomendacion().getcAccion()>this.activeUser.getGrafoRecomendacion().getcComedia()&& this.activeUser.getGrafoRecomendacion().getcAccion()>this.activeUser.getGrafoRecomendacion().getcKid() ) {
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen()));
            }else if (this.programGlobal.genero.equals("kid")&&this.activeUser.getGrafoRecomendacion().getcKid()>this.activeUser.getGrafoRecomendacion().getcTerror() && this.activeUser.getGrafoRecomendacion().getcKid()>this.activeUser.getGrafoRecomendacion().getcRomance() && this.activeUser.getGrafoRecomendacion().getcKid()>this.activeUser.getGrafoRecomendacion().getcDocumental() && this.activeUser.getGrafoRecomendacion().getcKid()>this.activeUser.getGrafoRecomendacion().getcComedia() && this.activeUser.getGrafoRecomendacion().getcKid()>this.activeUser.getGrafoRecomendacion().getcAccion()) {
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen()));
            }else if (this.programGlobal.genero.equals("terror")&&this.activeUser.getGrafoRecomendacion().getcTerror()>this.activeUser.getGrafoRecomendacion().getcKid() && this.activeUser.getGrafoRecomendacion().getcTerror()>this.activeUser.getGrafoRecomendacion().getcRomance() && this.activeUser.getGrafoRecomendacion().getcTerror()>this.activeUser.getGrafoRecomendacion().getcDocumental() && this.activeUser.getGrafoRecomendacion().getcTerror()>this.activeUser.getGrafoRecomendacion().getcComedia() && this.activeUser.getGrafoRecomendacion().getcTerror()>this.activeUser.getGrafoRecomendacion().getcAccion()) {
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.listaProgramasActiva.buscarPrograma(this.programGlobal.nombre, this.activeUser.getGrafoRecomendacion().getColaAlmacen()));
            }//else-if
            if (!this.activeUser.getGrafoRecomendacion().getColaAlmacen().isEmpty()){//Este if es MUY necesario, ya que
                //si por casualidad, se ve un programa el cual es el unico de esa categoria, por lo que no se recomienda
                //y luego se ve otro de otra categoria pero los contadores son iguales, se tretará de llamar como a un programa
                //nulo en la interfaz y se caerá, por lo que es necesario hacer esta validación para saber si el head
                //de la cola de recomendación es null o no
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                this.bT_Recomendation.setBackground(new Background(new BackgroundImage(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
                this.bT_Recomendation.setDisable(false);
                this.bT_RightRecomendation.setDisable(false);
            }//if
        }//if
        //Borramos si en la cola también está el programa que estamos viendo desde categoría
        if (this.activeUser.getColaPrioridad().exists(this.programGlobal.nombre)){
            //Si existe en la cola de prioridad, la vemos y la eliminamos de ahí, ya que es como si la vieramos
            this.activeUser.getColaPrioridad().borrar(this.programGlobal.nombre);
            if (this.activeUser.getColaPrioridad().isEmpty()){//esto permite que el botn se desactive si se vacía la cola
                this.bT_Continue.setDisable(true);
                this.bT_RightContinue.setDisable(true);
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                Image base = new Image(getClass().getResourceAsStream("/Image/Movies/base.png"));
                bT_Continue.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

            }else {//Este else hace que se cambie a la imagen del nuevo head
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            }//else
        }//if
    }//bt_finish

    @FXML
    void bt_FInish2(ActionEvent event) throws IOException {
        //Este finish2 se usa para cuando se ve un programa desde la cola de prioridad
        this.bT_BackWatching2(event);
        this.activeUser.getColaPrioridad().head().setVisto(true);//o vemos desde la cola de prioridad
        this.activeUser.getColaPrioridad().desencolar();
        if (activeUser.getColaPrioridad().isEmpty()){
            this.bT_Continue.setDisable(true);
            this.bT_RightContinue.setDisable(true);
            this.bT_ViewFinish2.setVisible(false);
            this.bT_ViewFinish2.setDisable(true);
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            Image base = new Image(getClass().getResourceAsStream("/Image/Movies/base.png"));
            bT_Continue.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));

        }else {
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        }//else
    }//bt_FInish2

    @FXML
    void bt_FInish3(ActionEvent event) throws IOException {
        //Este finish3 se usa para cuando se ve un programa desde la cola de recomendacion del grafo
        this.bT_BackWatching2(event);
        if (this.activeUser.getColaPrioridad().exists(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().nombre)){
            //Si existe en la cola de prioridad, la vemos y la eliminamos de ahí, ya que es como si la vieramos
            this.activeUser.getColaPrioridad().borrar(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().nombre);
            if (this.activeUser.getColaPrioridad().isEmpty()){
                this.bT_Continue.setDisable(true);
                this.bT_RightContinue.setDisable(true);
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                Image base = new Image(getClass().getResourceAsStream("/Image/Movies/base.png"));
                bT_Continue.setBackground(new Background(new BackgroundImage(base, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            }else {
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            }//else
        }//if
    }//bt_FInish3

    @FXML
    void bT_Recomendation(ActionEvent event){
        //quita los elementos del menu
        this.activeRecomendation=true; //Sabemos que vemos un programas desde la cola del grafo
        aP_Category.setVisible(false);
        //trae los elementos del view de la pelicula
        aP_View.setVisible(true);
        this.bT_BackWatching.setVisible(false);
        this.bT_BackWatching.setDisable(true);

        this.bT_BackWatching2.setVisible(true);
        this.bT_BackWatching2.setDisable(false);

        this.bT_ViewFinish3.setDisable(false); //Activamos el finish de la cola de recomendacion
        this.bT_ViewFinish3.setVisible(true);

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        //Se usa el mismo bt_Movie porque es igual que el de arriba.
        this.bT_ViewMovie.setBackground(new Background(new BackgroundImage(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.lB_Info.setText("Now watching \n" +
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().nombre + ".\n" +
                "\n" +
                this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().duracion + " min.\n" +
                "\n" +
                "For older than " + this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().restriccion +
                "\nyears old.");
    }//bT_Recomendation

    @FXML
    void bT_RightRecomendation(ActionEvent event) {
        this.activeUser.getGrafoRecomendacion().getColaAlmacen().encolar(this.activeUser.getGrafoRecomendacion().getColaAlmacen().desencolar());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Recomendation.setBackground(new Background(new BackgroundImage(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
    }//bt_RightRecomendation

    @FXML
    void bT_RightContinue(ActionEvent event) throws IOException {
        //Esto permite que se encole el head y se mueva el head a la siguiente
        this.activeUser.getColaPrioridad().encolar(this.activeUser.getColaPrioridad().desencolar());
        //Esto permite que se carguen las imagenes del siguiente programa
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
    }//end del bT_LeftContinue

    @FXML
    void bT_Continue(ActionEvent event) throws IOException {
        //quita los elementos del menu
        aP_Category.setVisible(false);
        //trae los elementos del view de la pelicula
        aP_View.setVisible(true);
        this.bT_BackWatching.setVisible(false);
        this.bT_BackWatching.setDisable(true);

        this.bT_BackWatching2.setVisible(true);
        this.bT_BackWatching2.setDisable(false);

        this.bT_ViewFinish.setVisible(false);
        this.bT_ViewFinish.setDisable(true);
        this.bT_ViewFinish3.setVisible(false);
        this.bT_ViewFinish3.setDisable(true);

        this.bT_ViewFinish2.setVisible(true);
        this.bT_ViewFinish2.setDisable(false);

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        //Se usa el mismo bt_Movie porque es igual que el de arriba.
        this.bT_ViewMovie.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.lB_Info.setText("Now watching \n" +
                this.activeUser.getColaPrioridad().head().nombre + ".\n" +
                "\n" +
                this.activeUser.getColaPrioridad().head().duracion + " min.\n" +
                "\n" +
                "For older than " + this.activeUser.getColaPrioridad().head().restriccion +
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
            this.bT_Categories.setBackground(new Background(new BackgroundImage(listaProgramasActiva.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Back.setDisable(true);//cuando volvemos a categorias deshabilitamos este boton

        }else {// PERO, si el botón de las películas es el activo, se debe hacer lo mismo, pero también se fdebe llamar al método
            //de bt_Back, lo que permite que se carge BIEN la cuestión de las categorías.
            //quita los elementos de categorias
            aP_View.setVisible(false);

            //trae los elementos del menu
            aP_Category.setVisible(true);

            //vuelve a poner de fondo las imagenes de categorias
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Categories.setBackground(new Background(new BackgroundImage(listaProgramasActiva.img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Back.setDisable(false);//cuando volvemos a categorias deshabilitamos este boton

            //SE llama a bt_Back
            this.bT_Back(event);
        }//endElse
        this.bT_BackWatching2.setVisible(false);
        this.bT_BackWatching2.setDisable(true);

        if (this.activeRecomendation){//Este if permite diferenciar si se hace desde la cola de prioridad o si se hace desde la de recomendación
            //Si se hace desde la recomendacion y el programa no se ve, queda como NO finalizado y se agrega en la cola de prioridad
            this.activeUser.getColaPrioridad().encolar(this.activeUser.getGrafoRecomendacion().getColaAlmacen().head());
            this.activeRecomendation=false;
            BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            this.bT_Continue.setBackground(new Background(new BackgroundImage(this.activeUser.getColaPrioridad().head().img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
            this.bT_Continue.setDisable(false);
            this.bT_RightContinue.setDisable(false);
        }//if
    }//end del bT_BackWatching
    //-------------Category Methods-------------//


    //-------------Edit Methods-------------//
    @FXML
    void bT_Confirm(ActionEvent event) {

        String newName = tF_NewName.getText();
        String newAge = tF_NewAge.getText();

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
    void cB_User3 (ActionEvent event) {

        cB_User2.setDisable(true);

    }//end cB_User3
    //-------------Edit Methods-------------//


    //Metodos auxiliares:
    public Account returnActiveAccount(String status){

        Account array[] = rC.getRegisterFile();
        StatusBusiness statusBusiness = new StatusBusiness();
        try {
            ArrayList<Integer> posiciones = (ArrayList<Integer>) statusBusiness.retornarPosiciones();
            for (int i = 0; i < posiciones.size(); i++) {
                if (posiciones.get(i)==1){
                    return array[i];
                }//if
            }//for
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }//try-catch

        return null;

    }//end returnUsername

    public void rewriteAccount (String name, Account account) {

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

    //Metodos auxiliares
    private void uptadeData (int edad){
        //Este es muy importante, ya que nos permite estar actualizando constantemente las listas y modificarlas respecto a la edad del ususario activo

        //Imagenes de comedia:
        Image FirstSunday = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/FirstSunday.png"));
        Image GrownUps = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/GrownUps.png"));
        Image ChangeUp = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/ChangeUp.png"));
        Image Norbit = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/Norbit.png"));
        Image WeddingRinger = new Image(getClass().getResourceAsStream("/Image/Movies/Comedy/WeddingRinger.png"));

        //Inicialización:
        Image Comedy = new Image(getClass().getResourceAsStream("/Image/Icons/Comedy.png"));
        LDEProgramas listaComedia=new LDEProgramas("Comedia", Comedy);
        Program peliculaFirstSunday = new Program("Pelicula",98,16,"First Sunday","comedia", FirstSunday);
        Program peliculaGrownUps = new Program("Pelicula",102,12,"Grown Ups","comedia", GrownUps);
        Program peliculaChangeUp = new Program("Pelicula",112,16,"Change Up","comedia", ChangeUp);
        Program peliculaNorbit = new Program("Pelicula",102,16,"Norbit","comedia", Norbit);
        Program peliculaWeddingRinger = new Program("Pelicula",101,14,"Wedding Ringer","comedia", WeddingRinger);
        listaComedia.insert(peliculaFirstSunday,edad);
        listaComedia.insert(peliculaGrownUps,edad);
        listaComedia.insert(peliculaChangeUp,edad);
        listaComedia.insert(peliculaNorbit,edad);
        listaComedia.insert(peliculaWeddingRinger,edad);

        //Imagenes de terror:
        Image IT = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/IT.png"));
        Image Annabelle = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Annabelle.png"));
        Image Mama = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Mama.png"));
        Image Veronica = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Veronica.png"));
        Image Saw = new Image(getClass().getResourceAsStream("/Image/Movies/Terror/Saw.png"));

        //Inicializacion:
        Image Horror = new Image(getClass().getResourceAsStream("/Image/Icons/Horror.png"));
        LDEProgramas listaTerror=new LDEProgramas("Terror", Horror);
        Program peliculaIt = new Program("Pelicula",136,15,"It","terror", IT);
        Program peliculaAnnabelle = new Program("Pelicula",98,15,"Annabelle","terror", Annabelle);
        Program peliculaMama = new Program("Pelicula",100,15,"Mama","terror", Mama);
        Program peliculaVeronica = new Program("Pelicula",102,16,"Veronica","terror", Veronica);
        Program peliculaSaw = new Program("Pelicula",111,18,"Saw","terror", Saw);
        listaTerror.insert(peliculaIt,edad);
        listaTerror.insert(peliculaAnnabelle,edad);
        listaTerror.insert(peliculaMama,edad);
        listaTerror.insert(peliculaVeronica,edad);
        listaTerror.insert(peliculaSaw,edad);

        //Imagenes de romance:
        Image FriendsWithBenefits = new Image(getClass().getResourceAsStream("/Image/Movies/Love/FriendsWithBenefits.png"));
        Image Amar = new Image(getClass().getResourceAsStream("/Image/Movies/Love/Amar.png"));
        Image TheNotebook = new Image(getClass().getResourceAsStream("/Image/Movies/Love/TheNotebook.png"));
        Image Newness = new Image(getClass().getResourceAsStream("/Image/Movies/Love/Newness.png"));
        Image CatchAndRelease = new Image(getClass().getResourceAsStream("/Image/Movies/Love/Catch&Release.png"));

        //Inicializacion:
        Image Love = new Image(getClass().getResourceAsStream("/Image/Icons/Love.png"));
        LDEProgramas listaRomance=new LDEProgramas("Romance", Love);
        Program peliculaFriendsWithBenefits = new Program("Pelicula",109,16,"Friends with Benefits","romance", FriendsWithBenefits);
        Program peliculaAmar = new Program("Pelicula",105,16,"Amar","romance", Amar);
        Program peliculaTheNotebook = new Program("Pelicula",124,16,"The Notebook","romance", TheNotebook);
        Program peliculaNewness = new Program("Pelicula",112,16,"Newness","romance", Newness);
        Program peliculaCatchAndRelease = new Program("Pelicula",105,16,"Catch & Release","romance", CatchAndRelease);
        listaRomance.insert(peliculaFriendsWithBenefits,edad);
        listaRomance.insert(peliculaAmar,edad);
        listaRomance.insert(peliculaTheNotebook,edad);
        listaRomance.insert(peliculaNewness,edad);
        listaRomance.insert(peliculaCatchAndRelease,edad);

        //Imagenes de Documentales:
        Image PabloEscobar = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/PabloEscobar.png"));
        Image StoryOfDiana = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/StoryOfDiana.png"));
        Image GameChangers = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/GameChangers.png"));
        Image WorldWar = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/WorldWar.png"));
        Image ExpedientesCriminales = new Image(getClass().getResourceAsStream("/Image/Movies/Documentaries/ExpedientesCriminales.png"));

        //Inicializacion:
        Image Documentaries = new Image(getClass().getResourceAsStream("/Image/Icons/Documentaries.png"));
        LDEProgramas listaDocumentales=new LDEProgramas("Documentales", Documentaries);
        Program peliculaPabloEscobar = new Program("Pelicula",46,13,"Pablo Escobar","documental", PabloEscobar);
        Program peliculaStoryOfDiana = new Program("Pelicula",83,13,"Story Of Diana","documental", StoryOfDiana);
        Program peliculaGameChangers = new Program("Pelicula",85,16,"Game Changers","documental", GameChangers);
        Program serieWorldWar = new Program("Serie",51,13,"World War","documental", WorldWar);
        Program serieExpedientesCriminales = new Program("Serie",46,16,"Expedientes Criminales","documental", ExpedientesCriminales);
        listaDocumentales.insert(peliculaPabloEscobar,edad);
        listaDocumentales.insert(peliculaStoryOfDiana,edad);
        listaDocumentales.insert(peliculaGameChangers,edad);
        listaDocumentales.insert(serieWorldWar,edad);
        listaDocumentales.insert(serieExpedientesCriminales,edad);

        //Imagenes de accion:
        Image Parker = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Parker.png"));
        Image Skyscraper = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Skyscraper.png"));
        Image Escape = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Escape.png"));
        Image PainAndGain = new Image(getClass().getResourceAsStream("/Image/Movies/Action/Pain&Gain.png"));
        Image LastRunway = new Image(getClass().getResourceAsStream("/Image/Movies/Action/LastRunway.png"));

        //Inicializacion:
        Image Action = new Image(getClass().getResourceAsStream("/Image/Icons/Action.png"));
        LDEProgramas listaAccion=new LDEProgramas("Acción", Action);
        Program peliculaParker = new Program("Pelicula",118,18,"Parker","accion", Parker);
        Program peliculaSkyscraper = new Program("Pelicula",102,18,"Skyscraper","accion", Skyscraper);
        Program peliculaEscape = new Program("Pelicula",115,18,"Escape","accion", Escape);
        Program peliculaPainAndGain = new Program("Pelicula",129,18,"Pain & Gain","accion", PainAndGain);
        Program peliculaLastRunway = new Program("Pelicula",107,16,"Last Runway","accion", LastRunway);
        listaAccion.insert(peliculaParker,edad);
        listaAccion.insert(peliculaSkyscraper,edad);
        listaAccion.insert(peliculaEscape,edad);
        listaAccion.insert(peliculaPainAndGain,edad);
        listaAccion.insert(peliculaLastRunway,edad);

        //Imagenes niños:
        Image BeeMovie = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/BeeMovie.png"));
        Image JohnnyTest = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/JohnnyTest.png"));
        Image PawPatrol = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/PawPatrol.png"));
        Image Pokemo = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/Pokemo.png"));
        Image Shrek = new Image(getClass().getResourceAsStream("/Image/Movies/Kids/Shrek.png"));

        //Inicializacion:
        Image Kids = new Image(getClass().getResourceAsStream("/Image/Icons/KIDS.png"));
        LDEProgramas listaNinos = new LDEProgramas("Kids", Kids);
        Program peliculaBeeMovie = new Program("Pelicula",118,6,"BeeMovie","kid", BeeMovie);
        Program peliculaJohnnyTest = new Program("Pelicula",102,6,"Johnny Test","kid", JohnnyTest);
        Program peliculaPawPatrol = new Program("Pelicula",115,6,"Paw Patrol","kid", PawPatrol);
        Program peliculaPokemon = new Program("Pelicula",129,6,"Pokemon","kid", Pokemo);
        Program peliculaShrek = new Program("Pelicula",107,6,"Shrek","kid", Shrek);
        listaNinos.insert(peliculaBeeMovie,edad);
        listaNinos.insert(peliculaJohnnyTest,edad);
        listaNinos.insert(peliculaPawPatrol,edad);
        listaNinos.insert(peliculaPokemon,edad);
        listaNinos.insert(peliculaShrek,edad);

        LCDEGeneros listaGeneros = new LCDEGeneros();
        listaGeneros.insert(listaComedia);
        listaGeneros.insert(listaTerror);
        listaGeneros.insert(listaRomance);
        listaGeneros.insert(listaDocumentales);
        listaGeneros.insert(listaAccion);
        listaGeneros.insert(listaNinos);

        //ESTO que sigue es general, por lo que no define la cuestion de la edad del usuario, solo carga lo necesario
        this.listaGenerosGlobal = listaGeneros;
        this.listaProgramasActiva =this.listaGenerosGlobal.getStart();//sobreescribimos la listaglobal segun la edad
        //inicializamos las imagenes en el boton
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.bT_Categories.setBackground(new Background(new BackgroundImage(listaProgramasActiva.getImg(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bSize) ));
        this.bT_Back.setDisable(true);//está deshabilitado para que no se vuelva atrás si está en categorias
        if (!this.categoriesActive){ //ESTA es la misma idea que en el backWacthing2
            //Esto sería el efecto del bt_Back
            //ESTO permite que si cambiamos de usuario, no
            //quita todos los elementos de movies
            this.bT_Movies.setVisible(false);
            this.bT_RightMovies.setVisible(false);
            this.bT_LeftMovies.setVisible(false);

            //pone todos los elementos de categories
            this.bT_Categories.setVisible(true);
            this.bT_RightCategories.setVisible(true);
            this.bT_LeftCategories.setVisible(true);

            //vuelve a poner de fondo las imagenes de categorias
            this.programGlobal = null;//reiniciamos para que los botones derecha e izquierda funciones con categorias y no con peliculas

            this.categoriesActive= true;//ESTO significa que volvemos a estar en las categorías, por lo que se hace menos proceso al usar lo de la cola,
            //es decir, con respecto a la interfaz gráfica.
        }//if
    }//uptadeData

}//end CategoryController class 293x167