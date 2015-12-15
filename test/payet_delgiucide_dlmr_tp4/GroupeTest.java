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

    /**
     * Test of fusion method, of class Groupe.
     */
    @Test
    public void testFusion() {
        System.out.println("fusion");
        // initialisation et complétion de 2 groupes de pierres blanches et un groupe de pierres noires.
        // premier groupe de pierres blanches
        Pierre pierreB1 = new Pierre("B", 2, 3, 1, 1, 1);
        Groupe groupe1 = new Groupe(1, pierreB1);

        Pierre pierreB2 = new Pierre("B", 2, 1, 1, 1, 2);
        Pierre pierreB3 = new Pierre("B", 2, 0, 1, 1, 3);
        Pierre pierreB4 = new Pierre("B", 2, 2, 1, 1, 4);
        groupe1.fusion(pierreB2);
        groupe1.fusion(pierreB3);
        groupe1.fusion(pierreB4);

        // Deuxième groupe de pierres blanches
        Pierre pierreB5 = new Pierre("B", 2, 3, 2, 3, 1);
        Groupe groupe2 = new Groupe(2, pierreB5);

        Pierre pierreB6 = new Pierre("B", 2, 1, 2, 3, 2);
        Pierre pierreB7 = new Pierre("B", 2, 0, 2, 3, 3);
        Pierre pierreB8 = new Pierre("B", 2, 2, 2, 3, 4);
        groupe2.fusion(pierreB6);
        groupe2.fusion(pierreB7);
        groupe2.fusion(pierreB8);

        // Groupe de pierres noires
        Pierre pierreN1 = new Pierre("N", 2, 3, 3, 5, 1);
        Groupe groupe3 = new Groupe(4, pierreN1);
        Pierre pierreN2 = new Pierre("N", 2, 1, 3, 5, 2);
        groupe3.fusion(pierreN2);
        Pierre pierreN3 = new Pierre("N", 2, 1, 3, 5, 3);
        groupe3.fusion(pierreN3);

        // Premier test: fusion d'un groupe de pierres blanches et de pierres noires
        groupe3.fusion(groupe1);
        assertEquals(groupe3.getListePierres().size(), 3);

        // La suite des tests sert à vérifier la bonne fusion de deux groupes  
        // de pierres blanches
        groupe1.fusion(groupe2);
        // 1. Que le groupe créé contient le bon nombre de pierres
        assertEquals(groupe1.getListePierres().size(), 8);
        // 2. Que toutes les pierres du groupe2 ont changé de groupe
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
        Pierre pierreB1 = new Pierre("B", 2, 3, 1, 1, 1);
        Groupe groupe1 = new Groupe(1, pierreB1);
        Pierre pierreB2 = new Pierre("B", 2, 1, 1, 1, 2);
        Pierre pierreB3 = new Pierre("B", 2, 0, 1, 1, 3);
        Pierre pierreB4 = new Pierre("B", 2, 2, 1, 1, 4);
        groupe1.fusion(pierreB2);
        groupe1.fusion(pierreB3);
        groupe1.fusion(pierreB4);

         // Deuxième groupe de pierres blanches
        Pierre pierreB5 = new Pierre("B", 2, 3, 2, 3, 1);
        Groupe groupe2 = new Groupe(2, pierreB5);

        Pierre pierreB6 = new Pierre("B", 2, 1, 2, 3, 2);
        Pierre pierreB7 = new Pierre("B", 2, 0, 2, 3, 3);
        Pierre pierreB8 = new Pierre("B", 2, 2, 2, 3, 4);
        groupe2.fusion(pierreB6);
        groupe2.fusion(pierreB7);
        groupe2.fusion(pierreB8);

        /* test du changement d'état à mort
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
*/
    }
}
