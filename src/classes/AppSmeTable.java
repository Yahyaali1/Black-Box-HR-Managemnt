package classes;

import java.util.Date;

/**
 * Created by IBM on 10/03/2017.
 * we will use the bool variable to determine if we need to pur it under first tab or second
 */
public class AppSmeTable extends Application {


    private String jd;
    private boolean accSme;
    private Date dateSme;
    private int timeSme;
    public AppSmeTable(){

    }

    public AppSmeTable(int appId, String appName, String appCv, String jd, boolean accSme, Date dateSme, int timeSme) {
        super(appId, appName, appCv);
        this.jd = jd;
        this.accSme = accSme;
        this.dateSme = dateSme;
        this.timeSme = timeSme;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public boolean isAccSme() {
        return accSme;
    }

    public void setAccSme(boolean accSme) {
        this.accSme = accSme;
    }

    public Date getDateSme() {
        return dateSme;
    }

    public void setDateSme(Date dateSme) {
        this.dateSme = dateSme;
    }

    public int getTimeSme() {
        return timeSme;
    }

    public void setTimeSme(int timeSme) {
        this.timeSme = timeSme;
    }
}
