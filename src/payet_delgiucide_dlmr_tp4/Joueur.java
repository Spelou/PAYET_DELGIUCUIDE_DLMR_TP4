/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

/**
 *
 * @author Romain
 */
public class Joueur {
    //attributs
    private String Nom;

    public Joueur(String Nom) {
        this.Nom = Nom;
    }
//getters
    public String getNom() {
        return Nom;
    }
//setters
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    
}
