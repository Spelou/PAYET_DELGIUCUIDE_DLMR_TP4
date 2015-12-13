/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.ArrayList;

/**
 *
 * @author Romain & Quentin P
 */
public class Groupe {

    //attributs
    private int numGroupe;
    private int liberte; //commence à 0, somme des liberté de chaque pierre du groupe
    private int etat; // 0 mort, 1 pris, 2 en jeu
    private String couleur; //idem que pour celle de pierre (N ou B)
    private ArrayList<Pierre> listePierres;

    public Groupe(int numGroupe, Pierre premierePierre) {
          
        this.numGroupe = numGroupe;
        this.liberte = premierePierre.getLiberte();
        this.etat = premierePierre.getEtat();
        this.couleur = premierePierre.getCouleur();;

        listePierres = new ArrayList<Pierre>();
        listePierres.add(premierePierre);
    }

    public void fusion(Groupe g) {
        if (g.couleur.equals(this.couleur)) {

            for (int i = 0; i < g.listePierres.size(); i++) { //On change le numéro de groupe de chaque pierre du groupe qui va être supprimé.
                g.listePierres.get(i).setNumGroupe(this.numGroupe);
            }
            listePierres.addAll(g.listePierres); // fusion des listes de pierres des 2 groupe

            g = null;  //suppression du groupe en paramétre. Le garbage collector s'occupe du reste (Vive Java)

        } else {
            System.out.println("Erreur: impossible de fusionner 2 groupes de couleurs différentes.");
        }
    }
    
    //ajout d'une pierre à un groupe
    public void fusion(Pierre p) {
        if (p.getCouleur().equals(this.couleur)) {
            listePierres.add(p); // fusion des listes de pierres des 2 groupes
        } else {
            System.out.println("Erreur: impossible de fusionner 2 groupes de couleurs différentes.");
        }
    }

    public void changerEtat(int etat) {

    }

    public void afficherliste() {
        for (int i = 0; i < listePierres.size(); i++) {
            System.out.println(listePierres.get(i).getCouleur().toString());
        }
    }

//getteurs
    public int getNumGroupe() {
        return numGroupe;
    }

    public int getLiberte() {
        return liberte;
    }

    public int getEtat() {
        return etat;
    }

    public String getCouleur() {
        return couleur;
    }

    public ArrayList<Pierre> getListePierres() {
        return listePierres;
    }

//setteurs sans celui de couleur (car à priori une pierre ne change pas de couleur) et sans celui du tableau (inutile)
    public void setNumGroupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }

    public void setLiberte(int liberte) {
        this.liberte = liberte;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

}
