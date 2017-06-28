package classes;

/**
 * Created by IBM on 10/03/2017.
 */
public class HrSmeTable extends Application {
    String email;
    String smeName;
    Boolean smeMark;
    int score1;

   public HrSmeTable(){
       super();
   }

    public HrSmeTable(int appId, String appName, String appCv, String email, String smeName, Boolean smeMark, int score1) {
        super(appId, appName, appCv);
        this.email = email;
        this.smeName = smeName;
        this.smeMark = smeMark;
        this.score1 = score1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmeName() {
        return smeName;
    }

    public void setSmeName(String smeName) {
        this.smeName = smeName;
    }

    public Boolean getSmeMark() {
        return smeMark;
    }

    public void setSmeMark(Boolean smeMark) {
        this.smeMark = smeMark;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }
}
