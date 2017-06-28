package web;

import classes.AppSmeTable;
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
 * Created by IBM on 05/03/2017.
 */

public class SmeForm extends HttpServlet {

    private RequestDispatcher view;

    private user_service us= new user_service();
    private app_service app_s= new app_service();
    private int smeId;
    private int uType;

    public void tologin_page(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        view= request.getRequestDispatcher("Login.jsp"); //if no user get to
        view.forward(request,response);
    }
    public  void reloadmarkingpage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {

        //load the list with name,cv link, timing data, jobdescription

        ArrayList<AppSmeTable> applist1 =app_s.smelistfirst(smeId);
        ArrayList<AppSmeTable> applist2 =app_s.smelistsecond(smeId);


        request.setAttribute("applists",applist1);
        request.setAttribute("applistm",applist2);


        view= request.getRequestDispatcher("DashBoardMain_SME_Mark.jsp"); //if no user get to
        view.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String type=request.getParameter("smeformtype");
             PrintWriter out=response.getWriter();
            HttpSession session = request.getSession(false);
             if (session == null) {
            // Not created yet. Now do so yourself.
                 tologin_page(request,response);
             }else {

                 smeId= (int) session.getAttribute("uId");
                 uType= (int) session.getAttribute("uType");

                 if(uType!=3){
                     tologin_page(request,response);
                 }else {


                     if(type.equals("1")){
                         try {
                             reloadmarkingpage(request,response);
                         } catch (SQLException e) {
                             e.printStackTrace();
                         }
                         out.print("Update sme info");
                     }else if(type.equals("2")){

                         int temp=Integer.valueOf(request.getParameter("jobid"));
                         if(request.getParameter("status").equals("true")){

                             try {
                                 app_s.accpet_sme_for_mark(temp);
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                         }else {

                             try {
                                 app_s.reject_sme_for_mark(temp);
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }

                         }


                         try {
                             reloadmarkingpage(request,response);
                         } catch (SQLException e) {
                             e.printStackTrace();
                         }
                         out.print("Accept/Reject Application");

                     }else if(type.equals("3")){

                         int temp=Integer.valueOf(request.getParameter("jobid"));

                        ArrayList<String> a=new ArrayList<String>();
                        for(int i=1;i<=5;i++){


                            a.add(request.getParameter("skill"+i));
                        }
                         try {
                             app_s.sme_marked(temp,a);
                         } catch (SQLException e) {
                             e.printStackTrace();
                         }


                         try {
                             reloadmarkingpage(request,response);
                         } catch (SQLException e) {
                             e.printStackTrace();
                         }
                         out.print("Application Marked " + request.getParameter("skill1"));
                     }



                 }


             }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            reloadmarkingpage(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
