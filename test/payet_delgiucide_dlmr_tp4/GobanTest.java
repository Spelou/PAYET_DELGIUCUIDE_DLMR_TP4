/*
 * test de la classe Goban
 */
package payet_delgiucide_dlmr_tp4;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quentin P
 */
public class GobanTest {

    /**
     * Test of afficher method, of class Goban.
     */
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        Goban monCrashGoban = new Goban(19);
       // monCrashGoban.afficher();
    }

    /**
     * Test of poserPierre method, of class Goban.
     */
    @Test
    public void testPoserPierre() {
        System.out.println("poserPierre");

    }

    /**
     * Test of calculLiberte method, of class Goban.
     */
    @Test
    public void testCalculLiberte() {
        System.out.println("calcul liberté");

        Goban monGobanCrash = new Goban(19);
        // initialisation  de 2 groupes de pierres blanches et un groupe de pierres noires.
        // premier groupe de pierres blanches
        Pierre pierreB1 = new Pierre("B", 2, 3, 1, 2, 1);
        Groupe groupe1 = new Groupe(1, pierreB1);
        Pierre pierreB2 = new Pierre("B", 2, 1, 1, 2, 2);
        Pierre pierreB3 = new Pierre("B", 2, 0, 1, 2, 3);
        Pierre pierreB4 = new Pierre("B", 2, 2, 1, 3, 2);
        groupe1.fusion(pierreB2);
        groupe1.fusion(pierreB3);
        groupe1.fusion(pierreB4);

        // Deuxième groupe de pierres blanches
        Pierre pierreB5 = new Pierre("B", 2, 3, 2, 3, 4);
        Groupe groupe2 = new Groupe(2, pierreB5);
        Pierre pierreB6 = new Pierre("B", 2, 1, 2, 3, 5);
        Pierre pierreB7 = new Pierre("B", 2, 0, 2, 4, 5);
        Pierre pierreB8 = new Pierre("B", 2, 2, 2, 5, 5);
        groupe2.fusion(pierreB6);
        groupe2.fusion(pierreB7);
        groupe2.fusion(pierreB8);

        // Groupe de pierres noires
        Pierre pierreN1 = new Pierre("N", 2, 3, 3, 4, 1);
        Groupe groupe3 = new Groupe(4, pierreN1);
        Pierre pierreN2 = new Pierre("N", 2, 1, 3, 4, 2);
        groupe3.fusion(pierreN2);
        Pierre pierreN3 = new Pierre("N", 2, 1, 3, 4, 3);
        groupe3.fusion(pierreN3);

        // Groupe d'une seule pierre blanche qui simule la pierre posée sur le goban
        Pierre pierreB9 = new Pierre("B", 2, 1, 4, 3, 3);
        Groupe groupe4 = new Groupe(5, pierreB9);

        ArrayList mesGroupes = new ArrayList();
        mesGroupes.add(groupe1);
        mesGroupes.add(groupe2);
        mesGroupes.add(groupe3);
        mesGroupes.add(groupe4);
        monGobanCrash.setListeGroupes(mesGroupes);

        // test
        monGobanCrash.getPlateau()[2][1] = pierreB1;
        monGobanCrash.getPlateau()[2][2] = pierreB2;
        monGobanCrash.getPlateau()[2][3] = pierreB3;
        monGobanCrash.getPlateau()[3][2] = pierreB4;
        monGobanCrash.getPlateau()[3][4] = pierreB5;
        monGobanCrash.getPlateau()[3][5] = pierreB6;
        monGobanCrash.getPlateau()[4][5] = pierreB7;
        monGobanCrash.getPlateau()[5][5] = pierreB8;
        monGobanCrash.getPlateau()[4][1] = pierreN1;
        monGobanCrash.getPlateau()[4][2] = pierreN2;
        monGobanCrash.getPlateau()[4][3] = pierreN3;
        System.out.println(monGobanCrash.getPlateau()[4][3].getCouleur());
        assertEquals(monGobanCrash.calculLiberte(groupe1),7);
        assertEquals(monGobanCrash.calculLiberte(groupe2),9);
        assertEquals(monGobanCrash.calculLiberte(groupe3),7);

        // monGobanCrash.getPlateau()[2][1] = pierreB9;
    }

    /**
     * Test of estVide method, of class Goban.
     */
    @Test
    public void testEstVide() {
        System.out.println("estVide");

    }

    /**
     * Test of nonSuicide method, of class Goban.
     */
    @Test
    public void testNonSuicide() {
        System.out.println("nonSuicide");

    }

    /**
     * Test of mettreAJourGroupe method, of class Goban.
     */
    @Test
    public void testMettreAJourGroupe() {
        System.out.println("mettreAJourGroupe");
    }

    /**
     * Test of mettreAJourDeg method, of class Goban.
     */
    @Test
    public void testMettreAJourDeg() {
        System.out.println("mettreAJourDeg");

    }

    /**
     * Test of estValide method, of class Goban.
     */
    @Test
    public void testEstValide() {
        System.out.println("estValide");

    }

}
