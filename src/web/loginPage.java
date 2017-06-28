package web;

import classes.*;
import classes.app_service;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 19/03/2017.
 */
public class loginPage extends HttpServlet {

    private app_service app_s= new app_service();
    private RequestDispatcher view;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Jobs> joblist=new ArrayList<Jobs>();
        try {
             joblist=app_s.jobsavailable();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("joblist",joblist);

        view= request.getRequestDispatcher("Login.jsp"); //if no user get to
        view.forward(request,response);

    }
}
