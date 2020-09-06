package transaction;

import java.io.Serializable;

public class ObjetCategorie implements Serializable{
    String noC;
    String nom;
    ObjetCategorie(String noC, String nom){
        this.noC = noC;
        this.nom = nom;
    }
    
    public String toString(){
        return ""+noC+":: "+nom;
    }
}