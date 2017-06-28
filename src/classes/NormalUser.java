package classes;

/**
 * Created by IBM on 16/03/2017.
 */
public class NormalUser extends User {
    private String skill1;
    private String skill2;
    private String descrp;
    private int year1;
    private int year2;
    private String phone;

    public NormalUser (){
        super();
    }

    public NormalUser(String skill1, String skill2, String descrp, int year1, int year2, String phone) {
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.descrp = descrp;
        this.year1 = year1;
        this.year2 = year2;
        this.phone = phone;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
