package classes;

/**
 * Created by IBM on 10/03/2017.
 */
public class service {
    protected DOL_FACTORY dol;
    public service() {
        dol = new DOL_FACTORY();

    }

    public boolean isemptystring(String a){
        if(a.equals("")){
            return false;
        }
        return true;
    }
    public boolean isvalidint(int a){
        if(a<0){
            return false;
        }
        return true;
    }
    public boolean isvalidinttime(int a){
        if(a<0 || a>16){
            return false;
        }
        return true;
    }


}
