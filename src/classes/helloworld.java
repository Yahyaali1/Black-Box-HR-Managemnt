package classes;

import com.thoughtworks.xstream.XStream;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 24/04/2017.
 */
@WebService
public class helloworld {

    @WebMethod
    public String say() throws SQLException {
        app_service app= new app_service();
        String temp = "";
       ArrayList<Jobs> joblist= app.getjoblisted();
        XStream X= new XStream();
       temp=X.toXML(joblist);


        return temp;
    }
    @WebMethod
    public String app(int id) throws SQLException {
        user_service app= new user_service();
        String temp = "";
        NormalUser nm= app.getnormaluserbyid(id);

        nm.setUserPassword("");
        XStream X= new XStream();
        temp=X.toXML(nm);


        return temp;
    }
}
