package Presentation;

import Domain.Account;
import Logic.ColaEnlazada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class RegisterController implements Initializable {

    @FXML
    private AnchorPane RegisterBase;

    @FXML
    private AnchorPane Register;

    @FXML
    private Button bT_Login;

    @FXML
    private TextField tF_Name;

    @FXML
    private TextField tF_Username;

    @FXML
    private PasswordField pF_Password;

    @FXML
    private TextField tF_Age;

    @FXML
    private RadioButton rB_Male;

    @FXML
    private RadioButton rB_Female;

    @FXML
    private TextField tF_CardNumber;

    @FXML
    private TextField tF_SecurityCode;

    @FXML
    private TextField tF_ExpireDate;

    @FXML
    private Button bT_SignUp;

    @FXML
    private ComboBox<?> cB_Gender;

    @FXML
    private String male;

    @FXML
    private String female;

    @FXML
    private Label lB_Advice;

    @FXML
    private Label lB_Advice1;

    @FXML
    private Button bT_Login1;

    @FXML
    void bT_LogIn(ActionEvent event) throws IOException {

        try{
            Stage stage = (Stage) bT_Login.getScene().getWindow();
            stage.close();
            //Abrir la ventana
            Parent root = FXMLLoader.load(RegisterController.class.getResource("Login.fxml"));
            Scene logInScene = new Scene(root);
            Stage logInStage = new Stage();
            logInStage.setScene(logInScene);
            logInStage.show();

            //Atributos de ventana
            logInStage.setTitle("MediaStream | Sign up");//titulo de la ventana
            Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
            logInStage.getIcons().add(icon);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch

    }//end bT_LogIn

    @FXML
    void bT_SignUp(ActionEvent event) {

        File fileAccount = new File("accounts.txt");
        String givenUsername = tF_Username.getText();

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

                if(tF_Name.getText().equals("") || tF_Username.getText().equals("") || pF_Password.getText().equals("") || tF_Age.getText().equals("") || tF_CardNumber.getText().equals("") || tF_SecurityCode.getText().equals("") || tF_ExpireDate.getText().equals("")){
                    lB_Advice.setText("All spaces are required.");
                    lB_Advice.setTextFill(Color.DARKRED);
                    lB_Advice.setAlignment(Pos.CENTER);
                    bT_Login1.setVisible(false);
                    lB_Advice1.setVisible(false);
                }//end if
                else {
                    if(givenUsername.equals(username)){
                        lB_Advice.setText("This username already exists.");
                        lB_Advice.setTextFill(Color.DARKRED);
                        lB_Advice.setAlignment(Pos.CENTER);
                        bT_Login1.setVisible(false);
                        lB_Advice1.setVisible(false);
                        break;
                    }//end if
                    else{
                         name = tF_Name.getText();
                         username = tF_Username.getText();
                         password = pF_Password.getText();
                         age = tF_Age.getText();
                         gender = cB_Gender.getValue().toString();
                         cardNumber = tF_CardNumber.getText();
                         cv = tF_SecurityCode.getText();
                         expireDate = tF_ExpireDate.getText();
                         type = "";
                         colaPrioridad = null;

                        Account account = new Account(name, username, password, age, gender, cardNumber, cv, expireDate, type, colaPrioridad);

                        addAccount(account);

                        tF_Name.clear();
                        tF_Name.clear();
                        tF_Username.clear();
                        pF_Password.clear();
                        tF_Age.clear();
                        tF_CardNumber.clear();
                        tF_SecurityCode.clear();
                        tF_ExpireDate.clear();

                        lB_Advice.setText("Account created succesfully.");
                        lB_Advice.setTextFill(Color.DARKGREEN);
                        lB_Advice.setAlignment(Pos.CENTER);
                        bT_Login1.setVisible(true);
                        lB_Advice1.setVisible(true);
                        break;
                    }//end else
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

    }//end bT_SignUp


    @FXML
    void bT_LogIn1(ActionEvent event) {

        try{
            Stage stage = (Stage) bT_Login.getScene().getWindow();
            stage.close();
            //Abrir la ventana
            Parent root = FXMLLoader.load(RegisterController.class.getResource("Login.fxml"));
            Scene logInScene = new Scene(root);
            Stage logInStage = new Stage();
            logInStage.setScene(logInScene);
            logInStage.show();

            //Atributos de ventana
            logInStage.setTitle("MediaStream | Sign up");//titulo de la ventana
            Image icon = new Image(getClass().getResourceAsStream("/Image/Icons/Icon.png"));//icono de la ventana
            logInStage.getIcons().add(icon);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch

    }//end LogIn1

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bT_Login1.setVisible(false);
        lB_Advice1.setVisible(false);

    }//end initialize


    //METODOS PARA GUARDAR USUARIOS:
    public void addAccount(Account account){

        File fileAccount = new File("accounts.txt");

        try{
            FileOutputStream fos = new FileOutputStream(fileAccount, true);
            PrintStream ps = new PrintStream(fos);

            ps.println(account.getName() + "|" + account.getUsername() + "|" + account.getPassword() + "|" + account.getAge() + "|" + account.getGender() + "|" + account.getCardNumber() + "|" + account.getCv() + "|" + account.getExpireDate());
        }//end Try

        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

    }//end addCountry


    public int countRegisterFile(){

        File fileAccount = new File("accounts.txt");

        int countRegisters = 0;

        try{
            FileInputStream fis = new FileInputStream(fileAccount);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String actualRegister = br.readLine();

            while (actualRegister != null){
                if(actualRegister != null)
                    countRegisters++;

                actualRegister = br.readLine();
            }//end while
        }//end try

        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

        return countRegisters;
    }//end method countRegisterFile


    public Account[] getRegisterFile(){

        Account array[] = new Account[countRegisterFile()];        File fileAccount = new File("accounts.txt");
        String givenUsername = tF_Username.getText();

        int indexArray = 0;

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

                    Account account = new Account(name, username, password, age, gender, cardNumber, cv, expireDate, type, colaPrioridad);

                    array[indexArray] = account;

                    indexArray++;

                actualRegister = br.readLine();
            }//end while
        }//end try

        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "We have problems with the file.");
        }//end catch

        return array;
    }//end method getRegisterFile

}//end class RegisterController