package classes;

/**
 * Created by IBM on 10/03/2017.
 */
public class User {
    private int userId;
    private int userType;
    private String userEmail;
    private  String userPassword;
    private String fName;
    private String lName;
    private boolean gender;

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public User(){

    }

    public User(int userId, int userType, String userEmail, String userPassword, String fName, String lName,boolean gender) {
        this.userId = userId;
        this.userType = userType;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.fName = fName;
        this.lName = lName;
        this.gender=gender;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }






}
