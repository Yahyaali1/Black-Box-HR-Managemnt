package classes;

import java.sql.*;

/**
 * Created by IBM on 10/03/2017.
 */
public class DOL {
    private String URL;
    protected Connection conn;
    protected Statement stmt;
    protected String query;
    protected ResultSet rs;
    protected PreparedStatement prp;

    public DOL() {
        URL = "jdbc:sqlserver://DESKTOP-U1PLQCK:1434;databaseName=blackbox;integratedSecurity=true";


        try {
            conn = DriverManager.getConnection(URL);
            stmt=conn.createStatement();
            rs=null;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.stmt = stmt;
        this.rs = rs;
    }
}
