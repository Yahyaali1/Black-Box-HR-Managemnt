package classes;

/**
 * Created by IBM on 10/03/2017.
 */
public class DOL_FACTORY {
    DOL_APP getappdol(){
        return new DOL_APP();
    }
    DOL_USER getuserdol(){
        return new DOL_USER();
    }
}
