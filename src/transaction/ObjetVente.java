package transaction;

import java.io.Serializable;
import java.util.Date;

public class ObjetVente implements Serializable{

    String no, desc, date, montant;
    ObjetVente(String no, String desc, String date, String montant){
        this.no = no;
        this.desc = desc;
        this.date = date;
        this.montant = montant;
    }
    
    public String toString(){
        return ""+no+":: "+desc; 
    }
    
}