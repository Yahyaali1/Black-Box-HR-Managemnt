package classes;


/**
 * Created by IBM on 10/03/2017.
 * objects required to fill the table
 */
public class Application {


    protected int appId;
    protected String appName;
    protected String appCv;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



    public Application(int appId, String appName, String appCv) {
        this.appId = appId;
        this.appName = appName;
        this.appCv = appCv;

    }

    public  Application(){

    }
    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCv() {
        return appCv;
    }

    public void setAppCv(String appCv) {
        this.appCv = appCv;
    }
}
