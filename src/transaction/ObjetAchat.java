package transaction;

import java.io.Serializable;

public class ObjetAchat implements Serializable{
    String no, desc, date, montant, fourn;
    
    ObjetAchat(String no, String desc,String date, String montant, String fourn){
        this.no = no;
        this.desc = desc;
        this.date = date;
        this.montant = montant;
        this.fourn = fourn;
    }
    
    public String toString(){
        return ""+no+":: "+desc;
    }
}