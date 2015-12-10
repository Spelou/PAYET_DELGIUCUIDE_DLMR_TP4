/*
 * fichier de tests de la classe groupe
 */
package payet_delgiucide_dlmr_tp4;

import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quentin P
 */
public class GroupeTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* UtilsJUnit4Test: @Class method");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of ajouterPierre method, of class Groupe.
     * méthode supprimée, redondante avec la fusion de deux groupes.
     
    @Test
    public void testAjouterPierre() {
        System.out.println("ajouterPierre");
        Random alea = new Random();
        Pierre pierre0 = new Pierre("B", 2, 3, 1);
        int compteurlib = 0; // on rajoute les 3 libertes de la pierre0 au moment de la comparaison
        Groupe groupe1 = new Groupe(1, pierre0);
        int a = alea.nextInt(50);

        for (int i = 1; i <= a; i++) {
            int lib = alea.nextInt(4);
            compteurlib = compteurlib + lib;
            Pierre pierrei = new Pierre("B", 2, lib, 1);
            groupe1.ajouterPierre(pierrei);
        }
        // on controle que la liste de pierres contient bien le nombre de pierres ajoutees
        assertEquals(groupe1.getListePierres().size(), a + 1);
        // on controle que le degre de liberte correspond bien
        assertEquals(groupe1.getLiberte(), compteurlib + 3);
        // on controle qu'on ne peut pas ajouter une pierre noire à un groupe de pierres blanches
        Pierre pierreN = new Pierre("N", 2, 3, 1);
        groupe1.ajouterPierre(pierreN);
        assertEquals(groupe1.getListePierres().size(), a + 1);
    }
    */
    
    /**
     * Test of fusion method, of class Groupe.
     */
    @Test
    public void testFusion() {
        System.out.println("fusion");
        // initialisation et complétion de 2 groupes de pierres blanches et un groupe de pierres noires.
        // premier groupe de pierres blanches
        Pierre pierreB1 = new Pierre("B", 2, 3, 1);
        Groupe groupe1 = new Groupe(1, pierreB1);

        Pierre pierreB2 = new Pierre("B", 2, 1, 1);
        Pierre pierreB3 = new Pierre("B", 2, 0, 1);
        Pierre pierreB4 = new Pierre("B", 2, 2, 1);
        groupe1.ajouterPierre(pierreB2);
        groupe1.ajouterPierre(pierreB3);
        groupe1.ajouterPierre(pierreB4);

        // Deuxième groupe de pierres blanches
        Pierre pierreB5 = new Pierre("B", 2, 3, 2);
        Groupe groupe2 = new Groupe(2, pierreB5);

        Pierre pierreB6 = new Pierre("B", 2, 1, 2);
        Pierre pierreB7 = new Pierre("B", 2, 0, 2);
        Pierre pierreB8 = new Pierre("B", 2, 2, 2);
        groupe2.ajouterPierre(pierreB6);
        groupe2.ajouterPierre(pierreB7);
        groupe2.ajouterPierre(pierreB8);

        // Groupe de pierres noires
        Pierre pierreN1 = new Pierre("N", 2, 3, 3);
        Groupe groupe3 = new Groupe(4, pierreN1);
        Pierre pierreN2 = new Pierre("N", 2, 1, 3);
        groupe3.ajouterPierre(pierreN2);
        Pierre pierreN3 = new Pierre("N", 2, 1, 3);
        groupe3.ajouterPierre(pierreN3);

        // Premier test: fusion d'un groupe de pierres blanches et de pierres noires
        groupe3.fusion(groupe1);
        assertEquals(groupe3.getListePierres().size(), 3);

        // La suite des tests sert à vérifier la bonne fusion de deux groupes  
        // de pierres blanches
        groupe1.fusion(groupe2);
        // 1. Que le groupe créé contient le bon nombre de pierres
        assertEquals(groupe1.getListePierres().size(), 8);
        // 2. Que le degré de liberté du nouveau groupe correspond bien à la somme des degrés de liberté des groupes
        assertEquals(groupe1.getLiberte(), 12);
        // 3. Que toutes les pierres du groupe2 ont changé de groupe
        assertEquals(pierreB5.getNumGroupe(), 1);
        assertEquals(pierreB6.getNumGroupe(), 1);
        assertEquals(pierreB7.getNumGroupe(), 1);
        assertEquals(pierreB8.getNumGroupe(), 1);

    }

    // Vérification que le groupe en paramètre d'une fusion pointe vers null
    /* @Test(expected = NullPointerException.class)
     public void checkExpectedException() {
     System.out.println("checkExpectedException");
     Pierre pierreB1 = new Pierre("B", 2, 3, 1);
     Groupe groupe1 = new Groupe(1, pierreB1);
     Pierre pierreB2 = new Pierre("B", 2, 3, 2);
     Groupe groupe2 = new Groupe(2, pierreB2);
     groupe1.fusion(groupe2);
     int taille = groupe2.getListePierres().size();
     }
     */
    /**
     * Test of changerEtat method, of class Groupe.
     */
    @Test
    public void testChangerEtat() {
        System.out.println("changerEtat");
        // initialisation de deux groupes de pierres blanches
        Pierre pierreB1 = new Pierre("B", 2, 3, 2);
        Groupe groupe1 = new Groupe(1, pierreB1);
        Pierre pierreB2 = new Pierre("B", 2, 1, 2);
        Pierre pierreB3 = new Pierre("B", 2, 0, 2);
        Pierre pierreB4 = new Pierre("B", 2, 2, 2);
        groupe1.ajouterPierre(pierreB2);
        groupe1.ajouterPierre(pierreB3);
        groupe1.ajouterPierre(pierreB4);

        Pierre pierreB5 = new Pierre("B", 2, 3, 2);
        Groupe groupe2 = new Groupe(2, pierreB5);
        Pierre pierreB6 = new Pierre("B", 2, 1, 2);
        Pierre pierreB7 = new Pierre("B", 2, 0, 2);
        Pierre pierreB8 = new Pierre("B", 2, 2, 2);
        groupe2.ajouterPierre(pierreB6);
        groupe2.ajouterPierre(pierreB7);
        groupe2.ajouterPierre(pierreB8);

        // test du changement d'état à mort
        groupe1.changerEtat(0);
        assertEquals(groupe1.getEtat(), 0);
        assertEquals(pierreB1.getEtat(), 0);
        assertEquals(pierreB2.getEtat(), 0);
        assertEquals(pierreB3.getEtat(), 0);
        assertEquals(pierreB4.getEtat(), 0);

        // test du changement d'état à pris
        groupe2.changerEtat(1);
        assertEquals(groupe2.getEtat(), 1);
        assertEquals(pierreB5.getEtat(), 1);
        assertEquals(pierreB6.getEtat(), 1);
        assertEquals(pierreB7.getEtat(), 1);
        assertEquals(pierreB8.getEtat(), 1);
        
    }
}
