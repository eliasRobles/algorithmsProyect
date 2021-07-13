package Presentation;

import Business.StatusBusiness;
import Data.StatusData;
import Domain.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    RegisterController rC = new RegisterController();

    @FXML
    private AnchorPane LoginBase;

    @FXML
    private AnchorPane Login;

    @FXML
    private Button bT_Login;

    @FXML
    private TextField tF_User;

    @FXML
    private PasswordField pF_Password;

    @FXML
    private Button bT_SignUp;

    @FXML
    private Label lB_Advice;


    @FXML
    void bT_Login(ActionEvent event) throws IOException {

        Account array[] = rC.getRegisterFile();
        String givenUser = tF_User.getText();
        String givenPassword = pF_Password.getText();

        for (int i = 0; i < array.length; i++) {

            if(givenUser.equals("") || givenPassword.equals("")){
                lB_Advice.setText("Please, enter your information.");
                lB_Advice.setTextFill(Color.DARKRED);
            }//end if
            else {
                if(returnAccount(givenUser, givenPassword) && givenUser.equals(array[i].getUsername()) && givenPassword.equals(array[i].getPassword())){
                    try {
                        StatusBusiness statusBusiness = new StatusBusiness();
                        statusBusiness.logIn(i, (ArrayList<Integer>)statusBusiness.retornarPosiciones()); //Nos logueamos
                        //es decir, hacemos que tengamos un uno, por lo que nuestra cuenta será la activa
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }//try-catch
                    //luego abre la ventana
                    Stage stage = (Stage) bT_Login.getScene().getWindow();
                    stage.setWidth(1000);
                    stage.setHeight(760);
                    stage.setTitle("MediaStream");
                    stage.centerOnScreen();
                    AnchorPane pane = FXMLLoader.load(IndexController.class.getResource("Index.fxml"));
                    LoginBase.getChildren().setAll(pane);
                    break;

                }else{
                    lB_Advice.setText("Incorrect credentials.");
                    lB_Advice.setTextFill(Color.DARKRED);
                    pF_Password.clear();
                    tF_User.clear();
                }//end else username

            }//end else
        }//end for

    }//end onLoginAction

    @FXML
    void bT_SignUp(ActionEvent event) throws IOException {

        Stage stage = (Stage) bT_SignUp.getScene().getWindow();
        stage.setWidth(838);
        stage.setHeight(640);
        stage.setTitle("MediaStream | Sign up");
        stage.centerOnScreen();
        AnchorPane pane = FXMLLoader.load(RegisterController.class.getResource("Register.fxml"));
        LoginBase.getChildren().setAll(pane);

    }//end bT_SignUp

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    public boolean returnAccount(String user, String password){

        Account array[] = rC.getRegisterFile();

        for (int i = 0; i < array.length; i++) {
            if(array[i].getUsername().equals(user) && array[i].getPassword().equals(password))
                return true;
        }//end for

        return false;

    }//end returnUsername

}//end LoginControllerClass
