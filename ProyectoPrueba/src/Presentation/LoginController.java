package Presentation;

import Domain.Account;
import Logic.ColaEnlazada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LoginController implements Initializable {

    RegisterController rG = new RegisterController();

    @FXML
    private AnchorPane Base;

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

        //ciclo que recorra el numero de indice del arreglo y en cada indice revise los espacios del token de usuario y si
        //coincide con el de el getText del textfield usuario entonces revise el siguiente token y si coincide con el getText
        //del textfield password entonces que inicie sesion, si no, un mensaje que diga que contraseña o usuario es incorrecto

        File fileAccount = new File("accounts.txt");
        String givenUser = tF_User.getText();
        String givenPassword = pF_Password.getText();

        try{
            FileInputStream fis = new FileInputStream(fileAccount);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String actualRegister = br.readLine();

            while(actualRegister != null){

                String name = "", username = "", password = "", age = "", gender = "", cardNumber = "", cv = "", expireDate = "", type = "";
                ColaEnlazada colaPrioridad = null;
                int controlToken = 0;

                StringTokenizer sT = new StringTokenizer(actualRegister, "|");

                while(sT.hasMoreTokens()){

                    if(controlToken == 1)
                        name = sT.nextToken();
                    else if(controlToken == 2)
                        username = sT.nextToken();
                    else if(controlToken == 3)
                        password = sT.nextToken();
                    else if(controlToken == 4)
                        age = sT.nextToken();
                    else if(controlToken == 5)
                        gender = sT.nextToken();
                    else if(controlToken == 6)
                        cardNumber = sT.nextToken();
                    else if(controlToken == 7)
                        cv = sT.nextToken();
                    else if(controlToken == 8)
                        type = sT.nextToken();

                    controlToken++;
                }//end while

                if(givenUser.equals("") || givenPassword.equals("")){
                    lB_Advice.setText("Please, enter your information.");
                    lB_Advice.setTextFill(Color.DARKRED);
                }//end if
                else {
                    if(givenUser.equals(username) && (givenPassword.equals(password))){

                        Stage stage = (Stage) bT_Login.getScene().getWindow();
                        stage.close();

                        //Abrir la ventana
                        Parent root = FXMLLoader.load(CategoryController.class.getResource("Category.fxml"));
                        Scene signUpScene = new Scene(root);
                        Stage signUpStage = new Stage();
                        signUpStage.setScene(signUpScene);
                        signUpStage.show();

                        //Atributos de ventana
                        signUpStage.setTitle("MediaStream | Category");//titulo de la ventana
                        Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
                        signUpStage.getIcons().add(icon);
                        break;
                    }//end if username
                    else{
                        lB_Advice.setText("Incorrect credentials.");
                        lB_Advice.setTextFill(Color.DARKRED);
                        pF_Password.clear();
                        tF_User.clear();
                    }//end else username

                }//end else

                actualRegister = br.readLine();
            }//end while
        }//end try

        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

    }//end onLoginAction

    @FXML
    void bT_SignUp(ActionEvent event) throws IOException {

        try{
            Stage stage = (Stage) bT_Login.getScene().getWindow();
            stage.close();
            //Abrir la ventana
            Parent root = FXMLLoader.load(RegisterController.class.getResource("Register.fxml"));
            Scene signUpScene = new Scene(root);
            Stage signUpStage = new Stage();
            signUpStage.setScene(signUpScene);
            signUpStage.show();

            //Atributos de ventana
            signUpStage.setTitle("MediaStream | Sign up");//titulo de la ventana
            Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
            signUpStage.getIcons().add(icon);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch

    }//end bT_SignUp

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

}//end LoginControllerClass
