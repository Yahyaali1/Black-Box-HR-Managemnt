package classes;

import java.util.Date;

/**
 * Created by IBM on 10/03/2017.
 */
public class Jobs {
    private Date sDate;
    private Date eDate;
    private Integer jId;
    private String jTitle;
    private String jJobdes;
    private String jSkill;

    public Jobs(Date sDate, Date eDate, Integer jId, String jTile, String jJobdes, String jSkill, String other) {
        this.sDate = sDate;
        this.eDate = eDate;
        this.jId = jId;
        this.jTitle = jTile;
        this.jJobdes = jJobdes;
        this.jSkill = jSkill;
        this.other = other;
    }
    public Jobs(){

    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjTitle() {
        return jTitle;
    }

    public void setjTitle(String jTitle) {
        this.jTitle = jTitle;
    }

    public String getjJobdes() {
        return jJobdes;
    }

    public void setjJobdes(String jJobdes) {
        this.jJobdes = jJobdes;
    }

    public String getjSkill() {
        return jSkill;
    }

    public void setjSkill(String jSkill) {
        this.jSkill = jSkill;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    private String other;




}
