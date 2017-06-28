package classes;
import org.apache.commons.validator.routines.EmailValidator;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 10/03/2017.
 */
@WebService
public class user_service extends service {

   private DOL_USER dol_user;

   @WebMethod
   public boolean emailval(String e) throws SQLException {
       return dol_user.userexist(e);
   }
    @WebMethod
    public boolean insertcv(int userid ,String cv) throws SQLException {
            return dol_user.insertcv(userid,cv);

    }
    @WebMethod
    public boolean userhascv(int userId) throws SQLException {
        return dol_user.userhascv(userId);
    }

    public user_service() {
        dol_user= dol.getuserdol();

    }
    @WebMethod
    public  boolean addnewuser(NormalUser n) throws SQLException {

        if(dol_user.userexist(n.getUserEmail())){
            return false; //means user already exist application can not be processed
        }else if(EmailValidator.getInstance(true).isValid(n.getUserEmail())==false){
            return false;
        }
        else  {
            dol_user.signupnormaluser(n);
            return true;
        }

    }
    @WebMethod
    public ArrayList<User> getallsme() throws SQLException{
       return dol_user.getallsme();
    }
    @WebMethod
    public boolean authenticate_user(String password, String email) throws SQLException {


            return dol_user.authenticate_user(password, email);

    }
    @WebMethod
    public  int authenticate_userid(String password,String email) throws SQLException {

        return dol_user.authenticate_userid(password,email); //if the user is bogus
    }
    @WebMethod
    public User getuserbyid(int user_id) throws SQLException {


        return dol_user.getuserbyid(user_id);
    }
    @WebMethod
    public NormalUser getnormaluserbyid(int user_id) throws SQLException {


        return dol_user.getnormaluserbyid(user_id);
    }
    @WebMethod
    public boolean updateuserpassword(String email,String Pass) throws SQLException {

        dol_user.updateUserPassword(email,Pass);

        return true;
    }
    @WebMethod
   public ArrayList<User> userlist_admin() throws SQLException {

        return dol_user.getallusers_admin();
    }
    @WebMethod
    public void removeuser_admin(String email) throws SQLException{

        dol_user.removeuseradim(email);

    }
    @WebMethod
    public void adduser_admin(String email,String pass,int Type) throws SQLException{
        dol_user.adduser(email,pass,Type);
    }
}
