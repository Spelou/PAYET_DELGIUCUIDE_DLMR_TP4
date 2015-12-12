/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.ImageObserver;
import static javafx.application.ConditionalFeature.GRAPHICS;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Romain
 */
public class FenetreT extends JFrame {

    private JButton bouton1 = new JButton("oOh"); //importé java.swing.JButton
    private JPanel pan = new JPanel(); //importé java.swing.JPanel
public FenetreT(){
// titre de la fenêtre          
this.setTitle("Goban inutile juste pour faire joli...");
// emplacement d'origine, ici centrée
this.setLocationRelativeTo(null);
// permet de pouvoir réellement fermer le processus de la fenêtre via la croix rouge habituel en haut à droite de Windows
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setContentPane(new AfficheImage("goban19.png"));
getContentPane().setLayout(new BorderLayout()); 
this.setVisible(true);

//Bordel de test inutile maintenant mais qui montre que j'y ai passé du temps : 
/*
//mettre une image de fond
 this.add(new JLabel(new ImageIcon("goban19.png")));	
	//this.pack();       
//taille abscisse puis ordonnée
this.setSize(400,500);
*/	


//ImageIcon ima = new ImageIcon("goban19.png");

//drawImage(ima,0,0,ImageObserver);



//instanciation du JPanel, ce qu'il va y avoir dans la fenêtre
//pan.setBackground(Color.ORANGE); // normalement on obtiendra un fond orange... ATTention importé java.awt.Color
//on met notre JPanel dans la fenête!
//this.setContentPane(pan);

//met le bouton dans le JPanel
//pan.add(bouton1);

//this.setLayout(new BorderLayout());
//this.getContentPane().add(new JButton("Centre"),BorderLayout.CENTER);
//this.getContentPane().add(new JButton("le nord..."),BorderLayout.NORTH);
// permet de rendre la fenêtre visible!!!
      
    }
}
    

