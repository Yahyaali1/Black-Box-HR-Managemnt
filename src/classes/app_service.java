package classes;

import javax.jws.WebService;
import javax.mail.MessagingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by IBM on 10/03/2017.
 */
@WebService
public class app_service extends service {
    private DOL_APP dol_app;
    private DOL_USER dol_user;

    public boolean setsme(int jobstatus,int sme,String Date, int Time) throws SQLException, MessagingException {

        int statusid=jobstatus;
        emailsend email=new emailsend();
        //

        User n=dol_user.getuserbyid(sme);
        email.settextforsmeinitial(n,Date,Time);


        if(dol_app.sendtosme(jobstatus,sme,Date,Time)) {
            email.sendmail(); //email send to
        }


        return true;
    }

    public  boolean removenewtable(int jobstatus) throws SQLException {

        dol_app.removenew(jobstatus);
        return true;
    }

    public app_service() {
        dol_app= dol.getappdol();
        dol_user=dol.getuserdol();

    }
    public boolean apply_job(int job_id,int app_id) throws SQLException {
        //check if already not applied

        return dol_app.apply_job(job_id,app_id);



    }

    public ArrayList<Jobs> getjoblisted() throws  SQLException {

        return dol_app.joblist();
    }

   public ArrayList<Jobs>  get_app_joblist(int app_id) throws SQLException {

        return dol_app.get_app_joblist(app_id);

    }

    public ArrayList<Jobs>  jobsavailable() throws SQLException {

        return dol_app.joblist();

    }
    public  ArrayList<newtable> getnewTable(int appid) throws SQLException {
        return dol_app.getnewTable(appid);
    }

    public  ArrayList<HrSmeTable> getHrSmeTable(int appid) throws SQLException {
        return dol_app.getHrSmeTable(appid);
    }

    public  ArrayList<HrFinalTable> getHrFinalTable(int appid) throws SQLException {
        return dol_app.getHrFinalTable(appid);
    }


    public boolean sendtohrm(int jobstatus) throws SQLException {

        dol_app.sendtohrm(jobstatus);
        //send to hrm

        return true;
    }

    public boolean removesecondstage(int jobstatus) throws SQLException {
        //remove from second stage


       dol_app.removesecondstage(jobstatus);
        return true;
    }

    public boolean sendoffer(int jobstatus) throws SQLException {

       dol_app.sendoffer(jobstatus);
        //send to hrm

        return true;
    }

    public boolean removethirdstage(int jobstatus) throws SQLException {
        //remove from second stage

        dol_app.removethirdstage(jobstatus);
        return true;
    }

    public ArrayList<AppSmeTable> smelistfirst(int smeid) throws SQLException {

        return dol_app.smelistfirst(smeid);
    }

    public ArrayList<AppSmeTable> smelistsecond(int smeid) throws SQLException {

        return dol_app.smelistsecond(smeid);
    }

    public boolean accpet_sme_for_mark(int statusid) throws SQLException{

        //send an email to the applicant that that they need to show up for the interview
        //email of applicant
        //date and time of sme
        //job desc
        AppHrTable n=dol_app.getdetailsforemail(statusid,1);
        emailsend e= new emailsend();
        dol_app.accpet_sme_for_mark(statusid);
        e.settextforsmeconfirm(n);
        e.sendmail();
        return true;
    }
    public boolean reject_sme_for_mark(int statusid) throws SQLException{
        dol_app.reject_sme_for_mark(statusid);
        return true;
    }
    public boolean sme_marks(int statusid,int marks) throws SQLException{
        dol_app.sme_marks(statusid,marks);
        return true;
    }

    public  boolean sme_marked(int statusid,ArrayList<String> a) throws SQLException {

        int marks=0;
        for(int i=0;i<a.size();i++){

            marks=Integer.valueOf(a.get(i).toString())+marks;

        }

        sme_marks(statusid,marks);


        return  true;
    }


    public boolean sethrmtime(int status,String Date, String Time) throws SQLException {

      dol_app.sethrmtime(status,Date,Integer.valueOf(Time));
        AppHrTable n=dol_app.getdetailsforemail(status,2); //we are using this object to load mass data
        emailsend e= new emailsend();
        e.settextforhrmconfirm(n);
        e.sendmail();

        return true;
    }

    public  boolean hrm_marked(int statusid,int salary,ArrayList<String> a) throws SQLException {

        int marks=0;
        for(int i=0;i<a.size();i++){

            marks=Integer.valueOf(a.get(i).toString())+marks;

        }

        dol_app.hrm_marks(statusid,marks,salary);


        return  true;
    }

    public Jobs activjob(int jobid) throws SQLException {
        return dol_app.activejob(jobid);
    }

    public ArrayList<AppHrTable> hrmlist(int jobid) throws SQLException {

        return dol_app.hrmlist(jobid);
    }
    public boolean postajob(String sdate,String edate, String jTitle, String descrp,String skill,String other, int utype) throws ParseException, SQLException {

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date sDate=df.parse(sdate);
        Date eDate=df.parse(edate);





        if (utype != 2) {
            return false;
        } else {

            Jobs newjob = new Jobs();
            newjob.setsDate(sDate);
            newjob.seteDate(eDate);
            newjob.setjTitle(jTitle);
            newjob.setjJobdes(descrp);
            newjob.setOther(other);



            dol_app.postajob(newjob,sdate,edate);

        }
        return true;
    }

    public AppHrTable getdetailsforemail(int status,int type) throws SQLException {
        return dol_app.getdetailsforemail(status,type);
    }
    }


