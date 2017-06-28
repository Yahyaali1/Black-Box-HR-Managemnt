package web;
import classes.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 05/03/2017.
 */
public class AppForm extends HttpServlet {
    private RequestDispatcher view;
    private user_service us= new user_service();
    app_service app_s= new app_service();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String type=request.getParameter("appformtype");



        int appid= (int)request.getSession().getAttribute("uId");


        if(type.equals("1")){
            //just relaoding the page with no imformation changed at the end. Form must update informationthough
            ArrayList<Jobs> JobsCanApply=new ArrayList<Jobs>();
            NormalUser normalUser= new NormalUser();

            try {
                JobsCanApply= app_s.get_app_joblist(appid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                normalUser=us.getnormaluserbyid(appid);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.setAttribute("joblist",JobsCanApply);
            request.setAttribute("normaluser",normalUser);

            view= request.getRequestDispatcher("DashBoardMain_Applicant.jsp");
            view.forward(request,response);


        }else if(type.equals("2")){

            boolean result=false;

            //getting the value for the job applied

            int jobid=Integer.valueOf(request.getParameter("jobid"));


           //apply for the job
            try {
                 result=app_s.apply_job(jobid,appid);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Jobs> JobsCanApply=new ArrayList<Jobs>();
            NormalUser normalUser= new NormalUser();

            try {
                JobsCanApply= app_s.get_app_joblist(appid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                normalUser=us.getnormaluserbyid(appid);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.setAttribute("joblist",JobsCanApply);
            request.setAttribute("normaluser",normalUser);
            request.setAttribute("result",result);

            view= request.getRequestDispatcher("DashBoardMain_Applicant.jsp");
            view.forward(request,response);



        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        view= request.getRequestDispatcher("Login.jsp"); //if no user get to
        view.forward(request,response);

    }
}
