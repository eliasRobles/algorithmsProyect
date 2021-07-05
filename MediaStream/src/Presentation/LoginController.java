package Presentation;

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

                    //Recoge toda la informacion de la cuenta para volver a escribirla, pero con el 1 de actividad
                    String name = array[i].getName();
                    String username = array[i].getUsername();
                    String password = array[i].getPassword();
                    String age = array[i].getAge();
                    String gender = array[i].getGender();
                    String cardNumber = array[i].getCardNumber();
                    String cv = array[i].getCv();
                    String expireDate = array[i].getExpireDate();
                    String status = "1";//significa que el usuario esta activos

                    //Crea un nuevo account, se llama al metodo que reescribe y lo reescribe
                    Account account = new Account(name, username, password, age, gender, cardNumber, cv, expireDate, status);
                    rewriteAccount(array[i].getName(), account);

                    //luego abre la ventana
                    Stage stage = (Stage) bT_Login.getScene().getWindow();
                    stage.setWidth(1000);
                    stage.setHeight(760);
                    stage.setTitle("MediaStream");
                    stage.centerOnScreen();
                    AnchorPane pane = FXMLLoader.load(IndexController.class.getResource("Index.fxml"));
                    LoginBase.getChildren().setAll(pane);
                    break;

                }//end if username
                else{
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


}//end LoginControllerClass
