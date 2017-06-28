package web;

import classes.user_service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by IBM on 22/04/2017.
 */
public class emailval extends HttpServlet {
    private user_service us= new user_service();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String email= request.getParameter("email");
        try {
            boolean status=us.emailval(email);
            if(status){
                response.getWriter().write("2");
            }else {
                response.getWriter().write("1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }


}
