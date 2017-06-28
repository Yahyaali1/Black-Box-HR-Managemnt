package web;

import classes.*;
import classes.Jobs;
import classes.app_service;
import classes.user_service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 18/03/2017.
 */
public class HrJobList extends HttpServlet {

    private RequestDispatcher view;

    private user_service us= new user_service();
    private app_service app_s= new app_service();
    private int userId;
    private int userType;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.

            view= request.getRequestDispatcher("Login.jsp"); //if no user get to
            view.forward(request,response);


        }else {

            userId=(int) session.getAttribute("uId");
            userType=(int) session.getAttribute("uType");


            if(userType!=2){
                view= request.getRequestDispatcher("Login.jsp"); //if no user get to
                view.forward(request,response);

            }else {
                ArrayList<Jobs> jobsList;
                ArrayList<newtable> newApp= new ArrayList<newtable>();
                ArrayList<HrSmeTable> hrSmeTable= new ArrayList<HrSmeTable>();
                ArrayList<HrFinalTable> hrFinalTable= new ArrayList<HrFinalTable>();
                ArrayList<User> sme= new ArrayList<User>();

                try {
                    jobsList=app_s.jobsavailable();
                    request.setAttribute("joblist",jobsList);
                    request.setAttribute("newApp",newApp);
                    request.setAttribute("hrSmeTable",hrSmeTable);
                    request.setAttribute("hrFinalTable",hrFinalTable);
                    request.setAttribute("sme",sme);



                } catch (SQLException e) {
                    e.printStackTrace();
                }
                view= request.getRequestDispatcher("DashBoardMainJobList.jsp"); //if no user get to
                view.forward(request,response);
            }













        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        view= request.getRequestDispatcher("Login.jsp"); //if no user get to
        view.forward(request,response);
    }


}
