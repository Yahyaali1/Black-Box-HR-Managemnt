package web;
import classes.*;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by IBM on 05/03/2017.
 */
public class HrForm extends HttpServlet {
    private RequestDispatcher view;

    private user_service us= new user_service();
    private app_service app_s= new app_service();
    private int userId;
    private  int userType;
    private int jobid;
    private  int error;
    private String message;

    ArrayList<Jobs> jobsList;
    ArrayList<newtable> newApp= new ArrayList<newtable>();
    ArrayList<HrSmeTable> hrSmeTable= new ArrayList<HrSmeTable>();
    ArrayList<HrFinalTable> hrFinalTable= new ArrayList<HrFinalTable>();
    ArrayList<User> sme= new ArrayList<User>();


    private void setdata(HttpServletRequest request,int jobid){
        try {
            jobsList=app_s.jobsavailable();
            newApp=app_s.getnewTable(jobid);
            hrSmeTable=app_s.getHrSmeTable(jobid);
            hrFinalTable=app_s.getHrFinalTable(jobid);
            sme=us.getallsme();

            request.setAttribute("joblist",jobsList);
            request.setAttribute("newApp",newApp);
            request.setAttribute("hrSmeTable",hrSmeTable);
            request.setAttribute("hrFinalTable",hrFinalTable);
            request.setAttribute("sme",sme);
            request.setAttribute("error",error);
            request.setAttribute("msg",message);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private void gotoerrorpage(HttpServletRequest request,HttpServletResponse response,int type) throws ServletException, IOException {


        view= request.getRequestDispatcher("error.jsp");
        view.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        error=0;
        message="";
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.

            view= request.getRequestDispatcher("Login.jsp"); //if no user get to
            view.forward(request,response);


        } else {
            // Already created.

            userId=(int) session.getAttribute("uId");
            userType=(int) session.getAttribute("uType");


            if(request.getParameter("formtype").equals("1")){
                out.print("Job selection print" + request.getParameter("jobid"));
                jobid= Integer.valueOf(request.getParameter("jobid"));
                boolean setjobid=true;
                session.setAttribute("jobselected",jobid); // for refresh purpose
                session.setAttribute("setjobid",setjobid); //will use to see if have to load list or not
                setdata(request,jobid);
                view= request.getRequestDispatcher("DashBoardMainJobList.jsp"); //if no user get to
                view.forward(request,response);

            }else  if(request.getParameter("formtype").equals("2")){
                jobid= (int) session.getAttribute("jobselected");

                if(request.getParameter("accept").equals("true")){
                    //set timings and etc
                    try {
                        error=1;
                        if(app_s.setsme(Integer.valueOf(request.getParameter("jobid")), Integer.valueOf(request.getParameter("smeid")), Jsoup.clean(request.getParameter("date"), Whitelist.basic()), Integer.valueOf(request.getParameter("time")))){

                            message="Timed with Sme Succesfully, Notified via email ";
                        }else {
                            message="Something is fishy, stop messing with javascript ";
                        }



                    }catch (SQLException e ){
                        e.printStackTrace();
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }else {
                    //set remove
                    int removeapp= Integer.valueOf(request.getParameter("jobid")); //jobid is mentioned as status id
                    try {
                        app_s.removenewtable(removeapp);
                        message="Removed as new applicant";
                        error=2;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                }

                setdata(request,jobid);
                view= request.getRequestDispatcher("DashBoardMainJobList.jsp"); //if no user get to
                view.forward(request,response);
                out.print("New Application ");
            }else if(request.getParameter("formtype").equals("3")){

                int tempstatus= Integer.valueOf(request.getParameter("jobid2"));
                jobid= (int) session.getAttribute("jobselected");
                if(request.getParameter("accept2").equals("true")){
                    //forward the request to manager

                    try {
                        if( app_s.sendtohrm(tempstatus)){
                            message="Request forward to Hrm, to mark";
                        }else {
                            message="Stop messing with javascript ";
                        }

                        error=3;

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                }else {
                    //sRemove the request

                    try {
                        app_s.removesecondstage(tempstatus);
                        error=4;
                        message="Removed from the list";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

                setdata(request,jobid);
                view= request.getRequestDispatcher("DashBoardMainJobList.jsp"); //if no user get to
                view.forward(request,response);

                out.print("To Manager ");
            }else  if(request.getParameter("formtype").equals("4")){

                int tempstatus= Integer.valueOf(request.getParameter("jobid3"));
                jobid= (int) session.getAttribute("jobselected");
                if(request.getParameter("accept3").equals("true")){


                    try {
                        app_s.sendoffer(tempstatus);
                        error=5;
                        message="Offer Letter send to the Applicant";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    //send request to offer

                }else {
                    //sRemove the request

                    try {
                        error=6;
                        app_s.removethirdstage(tempstatus);
                        message="Rejections Letter send to the Applicant";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

                setdata(request,jobid);
                view= request.getRequestDispatcher("DashBoardMainJobList.jsp"); //if no user get to
                view.forward(request,response);

                out.print("To Offer Job ");

            }else if(request.getParameter("formtype").equals("5")){

                // new job is being posted here

                try {
                    if(app_s.postajob(Jsoup.clean(request.getParameter("startdate"),Whitelist.basic()),Jsoup.clean(request.getParameter("enddate"),Whitelist.basic()),Jsoup.clean(request.getParameter("jobtitle"),Whitelist.basic()),Jsoup.clean(request.getParameter("descrp"),Whitelist.basic()),request.getParameter("skillreq"),request.getParameter("otherreq"),userType)){


                        error=7;
                        request.setAttribute("error",error);
                        view= request.getRequestDispatcher("DashBoardMain.jsp"); //if no user get to
                        view.forward(request,response);

                    }else {

                        view= request.getRequestDispatcher("Login.jsp"); //if no user get to
                        view.forward(request,response);

                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                out.print("New Request of Job listing");



            }
        }






    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        gotoerrorpage(request,response,1);


    }

}
