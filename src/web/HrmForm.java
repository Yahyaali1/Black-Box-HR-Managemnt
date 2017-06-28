package web;
import classes.*;
import classes.Jobs;
import classes.app_service;
import classes.user_service;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

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
 * Created by IBM on 05/03/2017.
 */
public class HrmForm extends HttpServlet {


    private RequestDispatcher view;
    private user_service us= new user_service();
    private app_service app_s= new app_service();
    private int ManagerId;
    private int uType;
    private int activeJob;

    public void tologin_page(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        view= request.getRequestDispatcher("Login.jsp"); //if no user get to
        view.forward(request,response);
    }

    public void reload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {

        ArrayList<Jobs> jobsList=app_s.jobsavailable();
        ArrayList<AppHrTable> apphrlist=app_s.hrmlist(activeJob);
        Jobs j=app_s.activjob(activeJob);

        request.setAttribute("apphrlist",apphrlist);
        request.setAttribute("joblist",jobsList);
        request.setAttribute("active",j);
        view= request.getRequestDispatcher("DashBoardMain_HRM_Mark.jsp"); //if no user get to
        view.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.
            tologin_page(request,response);
        }else {
            ManagerId= (int) session.getAttribute("uId");
            uType= (int) session.getAttribute("uType");

            if(uType!=4){
                tologin_page(request,response);
            }else {

                String type = request.getParameter("hrmformtype");
                PrintWriter out=response.getWriter();
                if(type.equals("1")){

                    activeJob= Integer.valueOf(request.getParameter("jobid"));
                    session.setAttribute("activejob",activeJob);
                    try {
                        reload(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    out.print("Reload list "+request.getParameter("list"));
                }else if(type.equals("2")){

                    int temp=Integer.valueOf(request.getParameter("statusid"));
                    String date= Jsoup.clean(request.getParameter("date"), Whitelist.basic());

                    String time=Jsoup.clean(request.getParameter("time"),Whitelist.basic());

                    try {
                        app_s.sethrmtime(temp,date,time);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        reload(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    out.print("Accept/Reject Application");
                }else if(type.equals("3")){

                    int temp=Integer.valueOf(request.getParameter("jobid"));
                    int salary=Integer.valueOf(request.getParameter("salary"));
                    ArrayList<String> a=new ArrayList<String>();
                    for(int i=1;i<=5;i++){
                        a.add(request.getParameter("skill"+i));
                    }

                    try {
                        app_s.hrm_marked(temp,salary,a);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        reload(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    out.print("Application Marked " + request.getParameter("jobid"));
                }


            }
        }



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            reload(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
