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
    private String nom;
    private String couleur;

    public Joueur(String Nom,String coul) {
        this.nom = Nom;
        this.couleur = coul;
    }
//getters
    public String getNom() {
        return nom;
    }
//setters
    public void setNom(String Nom) {
        this.nom = Nom;
    }
    
}
