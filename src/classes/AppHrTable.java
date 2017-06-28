package classes;

import java.util.Date;

/**
 * Created by IBM on 10/03/2017.
 * we will display
 */
public class AppHrTable extends Application {
    private String email;
    private int score1;
    private int timeHrm;
    private Date dateHrm;
    private boolean plan;
    private boolean mark;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getTimeHrm() {
        return timeHrm;
    }

    public void setTimeHrm(int timeHrm) {
        this.timeHrm = timeHrm;
    }

    public Date getDateHrm() {
        return dateHrm;
    }

    public void setDateHrm(Date dateHrm) {
        this.dateHrm = dateHrm;
    }

    public boolean getPlan() {
        return plan;
    }

    public void setPlan(boolean plan) {
        this.plan = plan;
    }

    public boolean getMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }






    public AppHrTable(){
        super();
    }

}
