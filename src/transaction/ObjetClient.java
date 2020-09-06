package transaction;

import java.io.Serializable;

public class ObjetClient implements Serializable{
    String noC;
    String nom;
    String ville;
    String solde;
    String etat;
    
    ObjetClient(String noC, String nom, String ville, String solde, String etat){
        this.noC = noC;
        this.nom = nom;
        this.ville = ville;
        this.solde = solde; 
        this.etat = etat;
    }
    
    public String toString(){
        return noC+"::"+nom;
    }
    
}