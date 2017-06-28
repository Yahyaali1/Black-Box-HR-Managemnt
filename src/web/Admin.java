package web;
import classes.*;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by IBM on 05/03/2017.
 */
public class Admin extends HttpServlet {


    private RequestDispatcher view;

   private user_service us= new user_service();
   private app_service app_s= new app_service();
    private String gerror;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String type=request.getParameter("adminformtype");

        if(type.equals("1")){

            //update user password via admin
            String email= request.getParameter("email");
            String newpass=request.getParameter("pass");
            try {
                us.updateuserpassword(email,newpass);
            } catch (SQLException e) {
                e.printStackTrace();
                out.print("email not valid");

            }

            ArrayList<User> userlist= null; //user list of all the user that cna be used to print again the same page
            try {
                userlist = us.userlist_admin();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.print("Change Password ");
            RequestDispatcher view = request.getRequestDispatcher("DashBoardMain_admin.jsp");
            request.setAttribute("userlist",userlist);
            //load the same page again with the update. We need array list of user objects in the database
            view.forward(request,response);
        }else if(type.equals("2")){
            //remove user via admin form
            String email= request.getParameter("email");

            try {
                us.removeuser_admin(email);
            } catch (SQLException e) {
                e.printStackTrace();
                out.print("Not delted");
            }

            ArrayList<User> userlist= null; //user list of all the user that cna be used to print again the same page
            try {
                userlist = us.userlist_admin();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher view = request.getRequestDispatcher("DashBoardMain_admin.jsp");
            request.setAttribute("userlist",userlist);
            //load the same page again with the update. We need array list of user objects in the database
            view.forward(request,response);
        }else if(type.equals("3")){
                //addduser via admin form
            String email= request.getParameter("email");
            String pass= request.getParameter("pass");
            int t=Integer.valueOf(request.getParameter("type"));

            try {
                us.adduser_admin(email,pass,t);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<User> userlist= null; //user list of all the user that cna be used to print again the same page
            try {
                userlist = us.userlist_admin();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher view = request.getRequestDispatcher("DashBoardMain_admin.jsp");
            request.setAttribute("userlist",userlist);
            //load the same page again with the update. We need array list of user objects in the database
            view.forward(request,response);
        }
        else if(type.equals("4")){

            //sign in form
            out.print("Sign in"+ request.getParameter("email"));
            String email= request.getParameter("inputid");
            String Pass=request.getParameter("password");


            try {
                if(us.authenticate_user(Pass,email)){
                    //user get authenticated
                    int temp;
                    temp=us.authenticate_userid(Pass,email);
                    User active= new User();
                    active=us.getuserbyid(temp);

                    //user object is created now, we will pass on

                    temp=active.getUserType();

                    //we need to create session object here so that we can accordingly manage everything else

                    HttpSession session=request.getSession();
                    session.setAttribute("uId",active.getUserId());
                    session.setAttribute("uType",active.getUserType());




                    if(temp==1){
                        //admin
                       // user logined in is of type admin

                        //user list for admin page is loaded here
                        ArrayList<User> userlist= null; //user list of all the user that cna be used to print again the same page

                        try {
                            userlist = us.userlist_admin();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        RequestDispatcher view = request.getRequestDispatcher("DashBoardMain_admin.jsp");
                        request.setAttribute("userlist",userlist);
                        //load the same page again with the update. We need array list of user objects in the database
                        view.forward(request,response);

                    }else if(temp==2){
                        //hr
                        //if the user loged in is of hr type


                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DashBoardMain.jsp");
                        requestDispatcher.forward(request,response);



                    }else if(temp==3){
                        //sme
                        //if the user of sme type
                        //load type of acceptance
                        //load type for marking

                        ArrayList<AppSmeTable> applist1 =app_s.smelistfirst(active.getUserId());
                        ArrayList<AppSmeTable> applist2 =app_s.smelistsecond(active.getUserId());



                        request.setAttribute("applists",applist1);
                        request.setAttribute("applistm",applist2);
                        view= request.getRequestDispatcher("DashBoardMain_SME_Mark.jsp");
                        view.forward(request,response);




                    }else if(temp==4){
                        ArrayList<Jobs> jobsList=app_s.jobsavailable();

                        request.setAttribute("joblist",jobsList);
                        view= request.getRequestDispatcher("DashBoardMain_HRM_Mark.jsp"); //if no user get to
                        view.forward(request,response);
                        //hrm
                        //if the user if of hrm type


                    }else if(temp==5){

                        if(us.userhascv(active.getUserId())){

                            ArrayList<Jobs> JobsCanApply=new ArrayList<Jobs>();
                            NormalUser normalUser= new NormalUser();
                            normalUser=us.getnormaluserbyid(active.getUserId());
                            try {
                                //getting the list of the job that are yet to be applied
                                JobsCanApply= app_s.get_app_joblist(active.getUserId());
                                //setting up the Job List under the request dispatcher
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            //seetting up request dispatcher
                            request.setAttribute("joblist",JobsCanApply);
                            request.setAttribute("normaluser",normalUser);

                            view= request.getRequestDispatcher("DashBoardMain_Applicant.jsp");
                            view.forward(request,response);
                        }else {

                            view= request.getRequestDispatcher("test.jsp");
                            view.forward(request,response);
                        }



                        //normal user
                        //if the user is of normal type
                    }else{
                        gerror="Hello, watch out for the User and its family, something fishy :) ";
                        request.setAttribute("gerror",gerror);
                        view= request.getRequestDispatcher("error.jsp");
                        view.forward(request,response);

                    }




                }else {


                    boolean result =false;
                    request.setAttribute("resultsignin",result);
                    ArrayList<Jobs> jobslist=new ArrayList<Jobs>();

                    jobslist=app_s.jobsavailable();
                    request.setAttribute("joblist",jobslist);
                    view= request.getRequestDispatcher("Login.jsp");
                    view.forward(request,response);


                    //redirect to the sign in page with a bool variable that login failed
                    out.print("Login Again ");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        else if(type.equals("5")){
            out.print("Sign up"+ request.getParameter("email"));

            NormalUser newuser= new  NormalUser();

           newuser.setfName(Jsoup.clean(request.getParameter("namefirst"), Whitelist.basic()));
            newuser.setlName(Jsoup.clean(request.getParameter("namelast"),Whitelist.basic()));
            newuser.setUserEmail(Jsoup.clean(request.getParameter("email"),Whitelist.basic()));
            newuser.setUserPassword(Jsoup.clean(request.getParameter("password"),Whitelist.basic()));
            newuser.setDescrp(Jsoup.clean(request.getParameter("descrp"),Whitelist.basic()));
            newuser.setSkill1(Jsoup.clean(request.getParameter("skill1"),Whitelist.basic()));
            newuser.setSkill2(Jsoup.clean(request.getParameter("skill2"),Whitelist.basic()));
            newuser.setPhone(Jsoup.clean(request.getParameter("tel"),Whitelist.basic()));
            newuser.setYear1(Integer.valueOf(request.getParameter("year1")));
            newuser.setYear1(Integer.valueOf(request.getParameter("year2")));

            if(request.getParameter("gender").equals("true")){
                newuser.setGender(true);
            }else {
                newuser.setGender(false);
            }


            try {

                boolean result =false;
                if(us.addnewuser(newuser)){
                    //means user have signed up completely
                    result=true;
                    request.setAttribute("result",result);
                    //means error singing up


                }else {
                    request.setAttribute("result",result);
                    //means error singing up

                }
                ArrayList<Jobs> jobslist=new ArrayList<Jobs>();
                jobslist=app_s.jobsavailable();
                request.setAttribute("joblist",jobslist);
                view= request.getRequestDispatcher("Login.jsp");
                view.forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();

            }


        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gerror="You are trying to do something that is not defined for you ! just go back and do it properly ";
        RequestDispatcher view;
        request.setAttribute("gerror",gerror);
        view= request.getRequestDispatcher("error.jsp");
        view.forward(request,response);
    }

}
