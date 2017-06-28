package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 10/03/2017.
 */
public class DOL_USER extends DOL {
    public DOL_USER() {
        super();
    }

    public boolean insertcv(int userid ,String cv) throws SQLException {
        query="UPDATE  [User] SET [User].cvp=1,[User].Cv_Link='"+cv+"' WHERE User_ID ="+userid;
        stmt.execute(query);


        return true;
    }

    public  boolean userhascv(int userid) throws SQLException {
       query=" SELECT  cvp from [User] WHERE  USER_ID="+userid;
       rs=stmt.executeQuery(query);
        rs.next();
       if(rs.getBoolean(1)==true){
           return true;
       }
       return false;

    }


    public boolean userexist(String email) throws SQLException {
        query="SELECT * FROM [User] WHERE [User].U_Email='"+email+"'";
        rs=stmt.executeQuery(query);
        if(rs.next()){
            return  true;
        }else {
            return false;
        }
    }

    public boolean signupnormaluser(NormalUser n) throws SQLException {


        int temp=0;
        if(n.isGender()){
            temp=1; //true
        }else {
            temp=0;
        }
        query="INSERT  INTO  [User] (U_Email, U_Password, U_Type, F_Name, L_Name, Gender, Descrp, Skill1, Skill2, Year1, Year2, Phone)\n" +
                "VALUES ('"+n.getUserEmail()+"','"+n.getUserPassword()+"',"+5+",'"+n.getfName()+"','"+n.getlName()+"',"+temp+",'"+n.getDescrp()+"','"+n.getSkill1()+"','"+n.getSkill2()+"',"+n.getYear1()+","+n.getYear2()+",'"+n.getPhone()+"')";

        stmt.execute(query);

        return  true;
    }

    public boolean authenticate_user(String password, String email) throws SQLException {

         prp =conn.prepareStatement("SELECT * FROM [User] WHERE [User].U_Email=? AND [User].U_Password=?");

        //query="SELECT * FROM [User] WHERE [User].U_Email='"+email+"' AND [User].U_Password='"+password+"'";

        //rs=stmt.executeQuery(query);
        prp.setString(1,email);
        prp.setString(2,password);
        rs=prp.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;

    }
    public  int authenticate_userid(String password,String email) throws SQLException {


        query="SELECT * FROM [User] WHERE [User].U_Email='"+email+"' AND [User].U_Password='"+password+"'";
        rs=stmt.executeQuery(query);
        if(rs.next()){
            return rs.getInt("User_ID");
        }
        return -1;
    }

    public User getuserbyid(int user_id) throws  SQLException{



        User n=new User();
        query="SELECT * FROM [User] WHERE [User].User_ID="+user_id;
        rs=stmt.executeQuery(query);
        rs.next();
        n.setUserEmail(rs.getString("U_Email"));
        n.setUserId(rs.getInt("User_ID"));
        n.setUserType(rs.getInt("U_Type"));
        n.setUserPassword(rs.getString("U_Password"));

        return  n;


    }

    public boolean updateUserPassword(String email,String newpass) throws SQLException {


        query="UPDATE [User] SET U_Password="+newpass+" WHERE U_Email='"+email+"'";
        stmt.execute(query);


        return true;
    }

    public ArrayList<User> getallsme() throws SQLException {
        ArrayList<User> userlist= new ArrayList<User>();

        User n;
        query="SELECT * FROM [User] WHERE U_Type=3";
        rs=stmt.executeQuery(query);

        while(rs.next()) {

            n=new User();
            n.setUserId(rs.getInt(1));
            n.setfName(rs.getString(5));
            n.setlName(rs.getString(6));
            userlist.add(n);

        }
        return userlist;
    }





    public ArrayList<User> getallusers_admin() throws SQLException {
        ArrayList<User> userlist= new ArrayList<User>();

        User n;
        query="SELECT [User].U_Email,[User].U_Password,[User].U_Type FROM [User]";
        rs=stmt.executeQuery(query);

        while(rs.next()) {

            n=new User();
            n.setUserEmail(rs.getString(1));

            n.setUserType(rs.getInt(3));
            n.setUserPassword(rs.getString(2));
            userlist.add(n);

        }
        return userlist;
    }

    public boolean removeuseradim(String email) throws SQLException{

        query="DELETE [User] WHERE U_Email='"+email+"'";
        stmt.execute(query);

        return true;
    }

    public  void adduser(String email, String pass, int Type) throws SQLException{
        query="INSERT INTO [User] (U_Email,U_Password,U_Type) VALUES ('"+email+"','"+pass+"',"+Type+")";
        stmt.execute(query);


    }
    public NormalUser getnormaluserbyid(int user_id) throws  SQLException{

        NormalUser n=new NormalUser();
        query="SELECT * FROM [User] WHERE [User].User_ID="+user_id;
        rs=stmt.executeQuery(query);
        rs.next();
        n.setUserEmail(rs.getString("U_Email"));
        n.setUserId(rs.getInt("User_ID"));
        n.setUserType(rs.getInt("U_Type"));
        n.setUserPassword(rs.getString("U_Password"));
        n.setfName(rs.getString(5));
        n.setlName(rs.getString(6));
        n.setDescrp(rs.getString(8));
        n.setSkill1(rs.getString(9));
        n.setSkill2(rs.getString(10));
        n.setYear1(rs.getInt(11));
        n.setYear2(rs.getInt(12));
        n.setGender(rs.getBoolean(7)); //1 for male 0 for female

        return  n;


    }
}
