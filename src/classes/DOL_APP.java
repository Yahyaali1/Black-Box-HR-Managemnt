package classes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IBM on 10/03/2017.
 */
public class DOL_APP extends DOL {
    public DOL_APP() {
    super();
    }
    boolean job_already_applied(int jobid,int appid){

        return  true;
    }

    public  ArrayList<newtable> getnewTable(int jobid) throws SQLException {
        ArrayList<newtable> newtablelist= new ArrayList<newtable>();

        query="SELECT Status_ID,Set_SME,Date_SME,Time_SME,u.F_Name,u.L_Name,u.Cv_Link,u.Skill1,u.Skill2 FROM [Jobs Status] as js JOIN [User] as u ON js.App_ID=u.User_ID WHERE Rem_New='False' AND (SME_Mark='False' OR SME_Mark Is NULL) AND Job_Id="+jobid;
        rs=stmt.executeQuery(query);

        newtable n;
        while (rs.next()){
            n= new newtable();

            n.setAppId(rs.getInt(1));
            n.setSme(rs.getBoolean(2));
            n.setDateSme(rs.getDate(3));
            n.setTimeSme(rs.getInt(4));
            n.setAppName(rs.getString(5)+" "+rs.getString(6));
            n.setAppCv(rs.getString(7));
            n.setMajor(rs.getString(8));
            n.setMinor(rs.getString(9));

            newtablelist.add(n);
        }
        return newtablelist;
    }
    public boolean apply_job(int job_id, int app_id) throws SQLException {

        prp=conn.prepareStatement("INSERT  INTO [Jobs Status] (Job_ID,App_ID,Rem_New) VALUES (?,?,?)");
        prp.setInt(1,job_id);
        prp.setInt(2,app_id);
        prp.setInt(3,0);

        prp.executeUpdate();

        //query="INSERT  INTO [Jobs Status] (Job_ID,App_ID,Rem_New) VALUES ('"+job_id+"','"+app_id+"',"+0+")";
        //stmt.execute(query);
        return true;

    }

    public AppHrTable getdetailsforemail(int status,int type) throws SQLException {



        AppHrTable temp=new AppHrTable();

       if(type==1){ //smedetails
           query="SELECT js.Status_ID,Date_SME,Time_SME,j.J_JobDes,U.L_Name,U.F_Name,U.Cv_Link,U.U_Email,js.Score1,js.Is_Mark,js.Is_Plan FROM [Jobs Status] AS js LEFT JOIN Jobs as j on js.Job_ID = j.J_ID LEFT JOIN [User] AS U on U.User_ID=js.App_ID\n" +
                   "WHERE Status_ID="+status;//sme
       }else if(type==2){ //hrmdetails
            query="SELECT js.Status_ID,Date_HRM,Time_HRM,j.J_JobDes,U.L_Name,U.F_Name,U.Cv_Link,U.U_Email,js.Score1,js.Is_Mark,js.Is_Plan FROM [Jobs Status] AS js LEFT JOIN Jobs as j on js.Job_ID = j.J_ID LEFT JOIN [User] AS U on U.User_ID=js.App_ID\n" +
                    "WHERE Status_ID="+status;

       }
        rs=stmt.executeQuery(query);
        rs.next();
        temp.setAppId(rs.getInt(1));
        temp.setDateHrm(rs.getDate(2));
        temp.setTimeHrm(rs.getInt(3));
        temp.setAppName(rs.getString(6)+" "+rs.getString(5));
        temp.setAppCv(rs.getString(4)); //cvhasjobdescription
        temp.setEmail(rs.getString(8));
        temp.setScore1(rs.getInt(9));
        temp.setMark(rs.getBoolean(10));
        temp.setPlan(rs.getBoolean(11));

        return  temp;
    }

    ArrayList<Jobs> get_app_joblist(int app_id) throws SQLException {


        ArrayList<Jobs> jobslist= new ArrayList<Jobs>();


        Jobs n;
        query="SELECT job.S_Date,job.J_JobDes,job.J_Skill,job.Other,job.J_ID FROM [Jobs] as job";

        rs=stmt.executeQuery(query);

        while(rs.next()) {
           n= new Jobs();
           n.setsDate(rs.getDate(1));
           n.setjJobdes(rs.getString(2));
           n.setjSkill(rs.getString(3));
           n.setOther(rs.getString(4));
           n.setjId(rs.getInt(5));

           jobslist.add(n);

        }

        query="SELECT DISTINCT [Jobs Status].Job_ID FROM [Jobs Status] WHERE [Jobs Status].App_ID="+app_id;
        rs=stmt.executeQuery(query);

        while (rs.next()){

            for(int i=0;i<jobslist.size();i++){
                if(rs.getInt(1)==jobslist.get(i).getjId()){

                    jobslist.remove(i);
                }
            }


        }




        return jobslist;



    }

    public ArrayList<Jobs> joblist() throws SQLException {


        ArrayList<Jobs> jobslist = new ArrayList<Jobs>();


        Jobs n;
        query = "SELECT job.S_Date,job.J_JobDes,job.J_Skill,job.Other,job.J_ID,job.J_Title FROM [Jobs] as job";

        rs = stmt.executeQuery(query);

        while (rs.next()) {
            n = new Jobs();
            n.setsDate(rs.getDate(1));
            n.setjJobdes(rs.getString(2));
            n.setjSkill(rs.getString(3));
            n.setOther(rs.getString(4));
            n.setjId(rs.getInt(5));
            n.setjTitle(rs.getString(6));

            jobslist.add(n);

        }
        return  jobslist;
    }

    public void postajob(Jobs newpost,String sdate,String edate ) throws SQLException {

        query="INSERT INTO Jobs (S_Date, E_Date, J_Title, J_JobDes, J_Skill, Other)  \n" +
                "    VALUES ('"+sdate+"','"+edate+"','"+newpost.getjTitle()+"','"+newpost.getjJobdes()+"','"+newpost.getjSkill()+"','"+newpost.getOther()+"')";






        stmt.execute(query);



    }

    public  ArrayList<HrSmeTable> getHrSmeTable(int jobid) throws SQLException {
        ArrayList<HrSmeTable> newtablelist= new ArrayList<HrSmeTable>();

        query="SELECT Status_ID,u.F_Name,u.L_Name,u.Cv_Link,u.U_Email,SME_Mark,Score1 FROM [Jobs Status] as js JOIN [User] as u ON js.App_ID=u.User_ID WHERE SME_Mark='True' AND (Rem_SME='False' Or Rem_SME is NULL ) AND Job_Id="+jobid;
        rs=stmt.executeQuery(query);

        HrSmeTable n;
        while (rs.next()){
            n= new HrSmeTable();

            n.setAppId(rs.getInt(1));
            n.setAppName(rs.getString(2)+" "+rs.getString(3));
            n.setAppCv(rs.getString(4));
            n.setEmail(rs.getString(5));
            n.setSmeMark(rs.getBoolean(6));
            n.setScore1(rs.getInt(7));


            newtablelist.add(n);
        }
        return newtablelist;
    }

    public  ArrayList<HrFinalTable> getHrFinalTable(int jobid) throws SQLException {
        ArrayList<HrFinalTable> newtablelist= new ArrayList<HrFinalTable>();

        query="SELECT Status_ID,u.F_Name,u.L_Name,u.Cv_Link,u.U_Email,Score1,Score2,Salary,Is_Mark,Is_Offer,Is_Plan,u.Phone FROM [Jobs Status] as js JOIN [User] as u ON js.App_ID=u.User_ID WHERE To_Man='True' AND (Is_Offer='TRUE' OR Is_Offer is NULL  ) AND Job_Id="+jobid;
        rs=stmt.executeQuery(query);

        HrFinalTable n;
        while (rs.next()){
            n= new HrFinalTable();

            n.setAppId(rs.getInt(1));
            n.setAppName(rs.getString(2)+" "+rs.getString(3));
            n.setAppCv(rs.getString(4));
            n.setEmail(rs.getString(5));
            n.setScore1(rs.getInt(6));
            n.setScore2(rs.getInt(7));
            n.setSalary(rs.getInt(8));
            n.setMark(rs.getBoolean(9));
            n.setOffer(rs.getBoolean(10));
            n.setPlan(rs.getBoolean(11));
            n.setTelF(rs.getString(12));

            newtablelist.add(n);
        }
        return newtablelist;
    }


    public boolean removenew(int jobstatus) throws SQLException {

        prp=conn.prepareStatement("UPDATE [Jobs Status] SET [Jobs Status].Rem_New=1 WHERE Status_ID =?");

        //query="UPDATE [Jobs Status] SET [Jobs Status].Rem_New=1 WHERE Status_ID ="+jobstatus;
        //stmt.execute(query);
        prp.setInt(1,jobstatus);
        prp.executeUpdate();


        return true;

    }

    public boolean sendtosme(int jobstatus,int sme,String Date, int Time) throws SQLException {

        prp=conn.prepareStatement("UPDATE [Jobs Status] SET [Jobs Status].Set_SME=1,[Jobs Status].SME_ID=?,[Jobs Status].Date_SME=?,[Jobs Status].Time_SME=? WHERE Status_ID =?");

        //query="UPDATE [Jobs Status] SET [Jobs Status].Set_SME=1,[Jobs Status].SME_ID="+sme+",[Jobs Status].Date_SME='"+Date+"',[Jobs Status].Time_SME="+Time+" WHERE Status_ID ="+jobstatus;
        //stmt.execute(query);
        prp.setInt(1,sme);
        prp.setString(2,Date);
        prp.setInt(3,Time);
        prp.setInt(4,jobstatus);
        prp.executeUpdate();


        return true;
    }
    public boolean sendtohrm(int jobstatus) throws SQLException {

        query="UPDATE [Jobs Status] SET [Jobs Status].To_Man=1,[Jobs Status].Is_Plan=0 WHERE Status_ID ="+jobstatus;
        stmt.execute(query);
        //send to hrm

        return true;
    }

    public boolean removesecondstage(int jobstatus) throws SQLException {
        //remove from second stage



        query="UPDATE [Jobs Status] SET [Jobs Status].Rem_SME=1 WHERE Status_ID ="+jobstatus;
        stmt.execute(query);
        return true;
    }

    public boolean sendoffer(int jobstatus) throws SQLException {

        query="UPDATE [Jobs Status] SET [Jobs Status].Is_Offer=1 WHERE Status_ID ="+jobstatus;
        stmt.execute(query);
        //send to hrm

        return true;
    }

    public boolean removethirdstage(int jobstatus) throws SQLException {
        //remove from second stage


        query="UPDATE [Jobs Status] SET [Jobs Status].Is_Offer=0 WHERE Status_ID ="+jobstatus;
        stmt.execute(query);
        return true;
    }

    public ArrayList<AppSmeTable> smelistfirst(int smeid) throws SQLException{
        query="SELECT js.Status_ID,Date_SME,Time_SME,j.J_JobDes,U.L_Name,U.F_Name,U.Cv_Link FROM [Jobs Status] AS js LEFT JOIN Jobs as j on js.Job_ID = j.J_ID LEFT JOIN [User] AS U on U.User_ID=js.App_ID\n" +
                "WHERE Set_SME='True'AND ((Acc_SME is NULL Or js.Acc_SME='False')) AND SME_ID="+smeid;
        rs=stmt.executeQuery(query);

        ArrayList<AppSmeTable> app_list= new ArrayList<AppSmeTable>();

        AppSmeTable temp;
        while (rs.next()){
            temp= new AppSmeTable();

            temp.setAppId(rs.getInt(1));
            temp.setDateSme(rs.getDate(2));
            temp.setTimeSme(rs.getInt(3));
            temp.setJd(rs.getString(4));
             temp.setAppName(rs.getString(6)+" "+rs.getString(5));
            temp.setAppCv(rs.getString(7));

        app_list.add(temp);
        }
        return app_list;

    }

    public boolean accpet_sme_for_mark(int statusid) throws SQLException{
        query="UPDATE [Jobs Status] SET [Jobs Status].Acc_SME=1,[Jobs Status].SME_Mark=0 WHERE Status_ID ="+statusid;
        stmt.execute(query);
        return true;
    }

    public boolean reject_sme_for_mark(int statusid) throws SQLException{
        query="UPDATE [Jobs Status] SET [Jobs Status].Acc_SME=0,[Jobs Status].Set_SME=0 WHERE Status_ID ="+statusid;
        stmt.execute(query);
        return true;
    }

    public boolean sme_marks(int statusid,int marks) throws SQLException{
        query="UPDATE [Jobs Status] SET [Jobs Status].SME_Mark=1,[Jobs Status].Score1="+marks+" WHERE Status_ID ="+statusid;
        stmt.execute(query);
        return true;
    }

    public ArrayList<AppSmeTable> smelistsecond(int smeid) throws SQLException{
        query="SELECT js.Status_ID,Date_SME,Time_SME,j.J_JobDes,U.L_Name,U.F_Name,U.Cv_Link FROM [Jobs Status] AS js LEFT JOIN Jobs as j on js.Job_ID = j.J_ID LEFT JOIN [User] AS U on U.User_ID=js.App_ID\n" +
                "WHERE Set_SME='True'AND (js.Acc_SME='True') AND js.SME_Mark ='False' AND SME_ID="+smeid;
        rs=stmt.executeQuery(query);

        ArrayList<AppSmeTable> app_list= new ArrayList<AppSmeTable>();

        AppSmeTable temp;
        while (rs.next()){
            temp= new AppSmeTable();

            temp.setAppId(rs.getInt(1));
            temp.setDateSme(rs.getDate(2));
            temp.setTimeSme(rs.getInt(3));
            temp.setJd(rs.getString(4));
            temp.setAppName(rs.getString(6)+" "+rs.getString(5));
            temp.setAppCv(rs.getString(7));

            app_list.add(temp);
        }
        return app_list;

    }

    public boolean sethrmtime(int status,String date, int Time) throws SQLException {

        query="UPDATE [Jobs Status] SET [Jobs Status].Is_Mark=0,[Jobs Status].Is_Plan=1,[Jobs Status].Date_HRM='"+date+"',[Jobs Status].Time_HRM="+Time+" WHERE Status_ID ="+status;
         stmt.execute(query);

             return true;
    }

    public boolean hrm_marks(int statusid,int marks, int Salary) throws SQLException{
        query="UPDATE [Jobs Status] SET [Jobs Status].Is_Mark=1,[Jobs Status].Score2="+marks+",[Jobs Status].Salary="+Salary+" WHERE Status_ID ="+statusid;
        stmt.execute(query);
        return true;
    }

    public  Jobs activejob(int jobid) throws SQLException {
        Jobs n;
        query="SELECT job.S_Date,job.J_JobDes,job.J_Skill,job.Other,job.J_ID,job.J_Title FROM [Jobs] as job WHERE job.J_ID="+jobid;

        rs=stmt.executeQuery(query);

        rs.next();
            n= new Jobs();
            n.setsDate(rs.getDate(1));
            n.setjJobdes(rs.getString(2));
            n.setjSkill(rs.getString(3));
            n.setOther(rs.getString(4));
            n.setjId(rs.getInt(5));
            n.setjTitle(rs.getString(6));

            return  n;

    }
    public ArrayList<AppHrTable> hrmlist(int jobid) throws SQLException {
        query="SELECT js.Status_ID,Date_HRM,Time_HRM,j.J_JobDes,U.L_Name,U.F_Name,U.Cv_Link,U.U_Email,js.Score1,js.Is_Mark,js.Is_Plan FROM [Jobs Status] AS js LEFT JOIN Jobs as j on js.Job_ID = j.J_ID LEFT JOIN [User] AS U on U.User_ID=js.App_ID\n" +
                "WHERE To_Man='True'AND (js.Is_Mark='False' Or js.Is_Mark is NULL )AND js.Job_ID="+jobid;

        ArrayList<AppHrTable> hrmlist= new ArrayList<AppHrTable>();

        AppHrTable temp;

        rs=stmt.executeQuery(query);
        while (rs.next()){
            temp= new AppHrTable();


            temp.setAppId(rs.getInt(1));
            temp.setDateHrm(rs.getDate(2));
            temp.setTimeHrm(rs.getInt(3));
            temp.setAppName(rs.getString(6)+" "+rs.getString(5));
            temp.setAppCv(rs.getString(7));
            temp.setEmail(rs.getString(8));
            temp.setScore1(rs.getInt(9));
            temp.setMark(rs.getBoolean(10));
            temp.setPlan(rs.getBoolean(11));

            hrmlist.add(temp);
        }


        return hrmlist;

    }
}
