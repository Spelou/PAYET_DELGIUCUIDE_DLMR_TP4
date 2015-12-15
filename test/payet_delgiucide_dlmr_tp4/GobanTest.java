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

        // Groupe d'une seule pierre blanche qui simule la pose d'une pierre blanche sur le goban
        Pierre pierreB9 = new Pierre("B", 2, 1, 4, 3, 3);
        Groupe groupe4 = new Groupe(4, pierreB9);
        // Groupe d'une seule pierre noire qui simule la pose d'une pierre noire sur le goban
        Pierre pierreN4 = new Pierre("N", 2, 1, 5, 3, 1);
        Groupe groupe5 = new Groupe(5, pierreN4);

        ArrayList mesGroupes = new ArrayList();
        mesGroupes.add(groupe1);
        mesGroupes.add(groupe2);
        mesGroupes.add(groupe3);
        mesGroupes.add(groupe4);
        mesGroupes.add(groupe5);
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
        assertEquals(monGobanCrash.calculLiberte(groupe1), 7);
        assertEquals(monGobanCrash.calculLiberte(groupe2), 9);
        assertEquals(monGobanCrash.calculLiberte(groupe3), 7);

        monGobanCrash.getPlateau()[3][3] = pierreB9;
        groupe1.fusion(groupe2);
        groupe1.fusion(groupe4);
        assertEquals(monGobanCrash.calculLiberte(groupe1), 13);
        assertEquals(monGobanCrash.calculLiberte(groupe3), 6);

        monGobanCrash.getPlateau()[3][1] = pierreN4;
        groupe3.fusion(groupe5);
        assertEquals(monGobanCrash.calculLiberte(groupe1), 12);
        assertEquals(monGobanCrash.calculLiberte(groupe3), 6);

    }

    /**
     * Test of degreLib method, of class Goban.
     */
    @Test
    public void testDegreLib() {
        System.out.println("degreLib");
        Goban monGobanCrash = new Goban(19);
        // initialisation d'un groupe de pierres blanches de test
        Pierre pierreB1 = new Pierre("B", 2, 2, 1, 0, 0);
        Groupe groupe1 = new Groupe(1, pierreB1);
        Pierre pierreB2 = new Pierre("B", 2, 3, 1, 1, 1);
        Pierre pierreB3 = new Pierre("B", 2, 3, 1, 2, 2);
        Pierre pierreB4 = new Pierre("B", 2, 2, 1, 2, 1);
        Pierre pierreB5 = new Pierre("B", 2, 4, 1, 1, 3);
        Pierre pierreB6 = new Pierre("B", 2, 4, 1, 2, 4);
        Pierre pierreB7 = new Pierre("B", 2, 4, 1, 3, 3);
        groupe1.fusion(pierreB2);
        groupe1.fusion(pierreB3);
        groupe1.fusion(pierreB4);
        monGobanCrash.getPlateau()[0][0] = pierreB1;
        monGobanCrash.getPlateau()[1][1] = pierreB2;
        monGobanCrash.getPlateau()[2][2] = pierreB3;
        monGobanCrash.getPlateau()[2][1] = pierreB4;
        monGobanCrash.getPlateau()[1][3] = pierreB5;
        monGobanCrash.getPlateau()[2][4] = pierreB6;
        monGobanCrash.getPlateau()[3][3] = pierreB7;
        assertEquals(monGobanCrash.degreLib(1, 0), 1);
        assertEquals(monGobanCrash.degreLib(3, 1), 3);
        assertEquals(monGobanCrash.degreLib(1, 2), 1);
        assertEquals(monGobanCrash.degreLib(2, 3), 0);
        assertEquals(monGobanCrash.degreLib(2, 5), 3);

    }

    /**
     * Test of nonSuicide method, of class Goban.
     */
    @Test
    public void testNonSuicide() {
        System.out.println("nonSuicide");
        Goban monGobanCrash = new Goban(9);

        //la pose d'une pierre dans un oeil n'est pas traitée, on vérifie cela simplement 
        // avec la méthode degLiberte. '
        Pierre pierreB1 = new Pierre("B", 2, 3, 1, 2, 1);
        Groupe groupe1 = new Groupe(1, pierreB1);
        Pierre pierreB2 = new Pierre("B", 2, 1, 1, 1, 2);
        Pierre pierreB3 = new Pierre("B", 2, 0, 1, 2, 4);
        Pierre pierreB4 = new Pierre("B", 2, 2, 1, 3, 2);
        Pierre pierreB5 = new Pierre("B", 2, 0, 1, 1, 3);
        Pierre pierreB6 = new Pierre("B", 2, 2, 1, 3, 3);
        groupe1.fusion(pierreB2);
        groupe1.fusion(pierreB3);
        groupe1.fusion(pierreB4);
        groupe1.fusion(pierreB5);
        groupe1.fusion(pierreB6);

        Pierre pierreN1 = new Pierre("N", 2, 3, 2, 2, 2);
        Groupe groupe2 = new Groupe(2, pierreN1);

        ArrayList mesGroupes = new ArrayList();
        mesGroupes.add(groupe1);
        mesGroupes.add(groupe2);
        monGobanCrash.setListeGroupes(mesGroupes);

        monGobanCrash.getPlateau()[2][1] = pierreB1;
        monGobanCrash.getPlateau()[1][2] = pierreB2;
        monGobanCrash.getPlateau()[2][4] = pierreB3;
        monGobanCrash.getPlateau()[3][2] = pierreB4;
        monGobanCrash.getPlateau()[1][3] = pierreB5;
        monGobanCrash.getPlateau()[3][3] = pierreB6;
        monGobanCrash.getPlateau()[2][2] = pierreN1;

        assertTrue(monGobanCrash.nonSuicide(2, 3, "B"));
        assertEquals((monGobanCrash.nonSuicide(2, 3, "N")), false);

        // prise en compte d'une situation plus complexe: on peut jouer une pierre
        // si en jouant on prend une pierre.
        // ajoutons quelques pierres noires pour que l'ajout d'une pierre noire en (2,3)
        // permette de prendre une pierre blanche et ne constitue plus un suicide
        Pierre pierreN2 = new Pierre("N", 2, 3, 2, 1, 4);
        Pierre pierreN3 = new Pierre("N", 2, 3, 2, 2, 5);
        Pierre pierreN4 = new Pierre("N", 2, 3, 2, 3, 4);
        groupe2.fusion(pierreN2);
        groupe2.fusion(pierreN3);
        groupe2.fusion(pierreN4);
        assertTrue(monGobanCrash.nonSuicide(2, 3, "B"));
        assertTrue(monGobanCrash.nonSuicide(2, 3, "N"));

    }

    /**
     * Test of mettreAJourGroupe method, of class Goban.
     */
    @Test
    public void testMettreAJourGroupe() {
        System.out.println("mettreAJourGroupe");
        Goban monGobanCrash = new Goban(19);

        Pierre pierreB1 = new Pierre("B", 2, 4, 1, 5, 4);
        Groupe groupe1 = new Groupe(1, pierreB1);

        Pierre pierreB2 = new Pierre("B", 2, 4, 2, 5, 6);
        Groupe groupe2 = new Groupe(2, pierreB2);

        Pierre pierreB3 = new Pierre("B", 2, 4, 3, 4, 5);
        Groupe groupe3 = new Groupe(3, pierreB3);

        Pierre pierreN1 = new Pierre("N", 2, 4, 4, 6, 5);
        Groupe groupe4 = new Groupe(4, pierreN1);

        Pierre pierreB4 = new Pierre("B", 2, 4, 8, 5, 5);

        ArrayList mesGroupes = new ArrayList();
        mesGroupes.add(groupe1);
        mesGroupes.add(groupe2);
        mesGroupes.add(groupe3);
        mesGroupes.add(groupe4);
        monGobanCrash.setListeGroupes(mesGroupes);

        monGobanCrash.getPlateau()[5][4] = pierreB1;
        monGobanCrash.getPlateau()[5][6] = pierreB2;
        monGobanCrash.getPlateau()[4][5] = pierreB3;
        monGobanCrash.getPlateau()[6][5] = pierreN1;
        monGobanCrash.getPlateau()[5][5] = pierreB4;

        monGobanCrash.mettreAJourGroupe(5, 5, "B");

        // vérification des degrés de liberté des pierres 
        assertEquals(pierreB1.getLiberte(), 3);
        assertEquals(pierreB2.getLiberte(), 3);
        assertEquals(pierreB3.getLiberte(), 3);
        assertEquals(pierreN1.getLiberte(), 3);
        assertEquals(pierreB4.getLiberte(), 0);

        // vérification de la fusion des groupes 1, 2 et 3.
        //1. bonne taille de la liste de groupes
        assertEquals(monGobanCrash.getListeGroupes().size(), 2);
        //2. bon numéro pour le nouveau groupe
        assertEquals(monGobanCrash.getPlateau()[5][5].getNumGroupe(), 5);
        assertEquals(monGobanCrash.getPlateau()[5][4].getNumGroupe(), 5);
        assertEquals(monGobanCrash.getPlateau()[5][6].getNumGroupe(), 5);
        assertEquals(monGobanCrash.getPlateau()[4][5].getNumGroupe(), 5);
        assertEquals(monGobanCrash.getPlateau()[6][5].getNumGroupe(), 4);
        //3.vérification des numéros de groupe des pierres
        assertEquals(pierreB1.getNumGroupe(), 5);
        assertEquals(pierreB2.getNumGroupe(), 5);
        assertEquals(pierreB3.getNumGroupe(), 5);
        assertEquals(pierreN1.getNumGroupe(), 4);
        assertEquals(pierreB4.getNumGroupe(), 5);
    }

}
