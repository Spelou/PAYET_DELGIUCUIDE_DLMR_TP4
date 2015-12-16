/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class PAYET_DELGIUCIDE_DLMR_TP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        System.out.println("Bienvenue dans le jeu de go, création du Goban");
        FenetreT fen =new FenetreT();
        Partie laPartie = new Partie();
        laPartie.NouvellePartie();
        */
        Goban gob=new Goban(19);
        System.out.println(gob.estValideCoord(-1,-1));
        
}
}
