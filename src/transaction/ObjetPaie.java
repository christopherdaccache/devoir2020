package transaction;

import java.io.Serializable;

public class ObjetPaie implements Serializable{
    String noP;
    String desc;
    String date;
    String montant;
    String mp;
    String oc;
    
    ObjetPaie(String noP, String desc, String date, String montant, String mp, String oc){
        this.date = date;
        this.desc = desc;
        this.montant = montant;
        this.mp = mp;
        this.noP = noP;
        this.oc = oc;
    }
    
    public String toString(){
        return ""+noP+":: "+desc;
    }
    
}