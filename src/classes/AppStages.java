package classes;

/**
 * Created by IBM on 10/03/2017.
 */
public class AppStages extends Application {
    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public boolean isRemNew() {
        return remNew;
    }

    public void setRemNew(boolean remNew) {
        this.remNew = remNew;
    }

    public boolean isOffer() {
        return isOffer;
    }

    public void setOffer(boolean offer) {
        isOffer = offer;
    }

    public boolean isAccSme() {
        return accSme;
    }

    public void setAccSme(boolean accSme) {
        this.accSme = accSme;
    }

    String jd;
   private boolean remNew;
    private boolean isOffer;
    private boolean accSme;

    public AppStages(int appId, String appName, String appCv, String jd, boolean remNew, boolean isOffer, boolean accSme) {
        super(appId, appName, appCv);
        this.jd = jd;
        this.remNew = remNew;
        this.isOffer = isOffer;
        this.accSme = accSme;
    }
    public AppStages(){
        super();
    }
}

