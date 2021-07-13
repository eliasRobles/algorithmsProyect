package Domain;

public class Account {

    private String name;
    private String username;
    private String password;
    private String age;
    private String gender;
    private String cardNumber;
    private String cv;
    private String expireDate;
    private User userOne;
    private User userTwo;
    private User userThree;


    public Account(String name, String username, String password, String age, String gender, String cardNumber, String cv, String expireDate) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.cardNumber = cardNumber;
        this.cv = cv;
        this.expireDate = expireDate;
        this.userOne = null;
        this.userTwo = null;
        this.userThree = null;
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

    @Override
    public String toString() {
        return "" + name + "|" + username + "|" + password + "|" + age + "|" + gender + "|" + cardNumber + "|" + cv + "|" + expireDate;
    }
}//fin class
