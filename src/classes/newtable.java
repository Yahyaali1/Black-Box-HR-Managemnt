package classes;

import java.util.Date;

/**
 * Created by IBM on 10/03/2017.
 */
public class newtable extends Application {
    private String major;
    private String minor;
    private boolean sme;
    private int timeSme;
    private Date dateSme;
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public newtable(int appId, String appName, String appCv, String major, String minor) {
        super(appId, appName, appCv);
        this.major = major;
        this.minor = minor;
    }
    public newtable(){
        super();
    }



    public int getTimeSme() {
        return timeSme;
    }

    public void setTimeSme(int timeSme) {
        this.timeSme = timeSme;
    }

    public Date getDateSme() {
        return dateSme;
    }

    public void setDateSme(Date dateSme) {
        this.dateSme = dateSme;
    }


    public boolean isSme() {
        return sme;
    }

    public void setSme(boolean sme) {
        this.sme = sme;
    }
}
