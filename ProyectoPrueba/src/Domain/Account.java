package Domain;

import Logic.ColaEnlazada;

public class Account {

    private String name;
    private String username;
    private String password;
    private String age;
    private String gender;
    private String cardNumber;
    private String cv;
    private String expireDate;
    private String type;  // esta ocuapcion es para las cuentas compartidas, es decir, para cuando es hijo1, principal, amigo 2, y así.
    private ColaEnlazada colaPrioridad;  //este sería para la implementación, de la cola de prioridad

    public Account(String name, String username, String password, String age, String gender, String cardNumber, String cv, String expireDate, String type, ColaEnlazada colaPrioridad) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.cardNumber = cardNumber;
        this.cv = cv;
        this.expireDate = expireDate;
        this.type = type;
        this.colaPrioridad = colaPrioridad;
    }//end constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ColaEnlazada getColaPrioridad() {
        return colaPrioridad;
    }

    public void setColaPrioridad(ColaEnlazada colaPrioridad) {
        this.colaPrioridad = colaPrioridad;
    }
}//fin class
