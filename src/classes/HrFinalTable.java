package classes;

/**
 * Created by IBM on 10/03/2017.
 */
public class HrFinalTable extends  Application {
    String email;
    String telF;
    int score1;
    int score2;
    int salary;
    boolean isPlan;
    boolean isMark;
    boolean isOffer;

    public  HrFinalTable(){
        super();
    }
    public HrFinalTable(int appId, String appName, String appCv, String email, String telF, int score1, int score2, int salary, boolean isPlan, boolean isMark, boolean isOffer) {
        super(appId, appName, appCv);
        this.email = email;
        this.telF = telF;
        this.score1 = score1;
        this.score2 = score2;
        this.salary = salary;
        this.isPlan = isPlan;
        this.isMark = isMark;
        this.isOffer = isOffer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelF() {
        return telF;
    }

    public void setTelF(String telF) {
        this.telF = telF;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isPlan() {
        return isPlan;
    }

    public void setPlan(boolean plan) {
        isPlan = plan;
    }

    public boolean getIsMark() {
        return isMark;
    }

    public void setMark(boolean mark) {
        isMark = mark;
    }

    public boolean getIsOffer() {
        return isOffer;
    }

    public void setOffer(boolean offer) {
        isOffer = offer;
    }
}
