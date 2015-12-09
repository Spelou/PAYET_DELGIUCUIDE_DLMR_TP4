/*
* fichier de tests de la classe groupe
 */
package payet_delgiucide_dlmr_tp4;

import java.util.LinkedList;
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
     */
    @Test
    public void testAjouterPierre() {
        System.out.println("ajouterPierre");
        Random alea=new Random();
        Pierre pierre0=new Pierre("B",2,3,1);
        int compteurlib=0; // on rajoute les 3 libertes de la pierre0 au moment de la comparaison
        Groupe groupe1=new Groupe(1,pierre0);
        int a=alea.nextInt(50);
        
        for (int i = 1; i <= a; i++) {
        int lib=alea.nextInt(4);
        compteurlib=compteurlib+lib;
        Pierre pierrei=new Pierre("B",2,lib,1);
        groupe1.ajouterPierre(pierrei);
        }
        // on controle que la liste de pierres contient bien le nombre de pierres ajoutees
        assertEquals(groupe1.getListePierres().size(),a+1);
        // on controle que le degre de liberte correspond bien
        assertEquals(groupe1.getLiberte(),compteurlib+3);
        // on controle qu'on ne peut pas ajouter une pierre noire à un groupe
        Pierre pierreN=new Pierre("N",2,3,1);
        groupe1.ajouterPierre(pierreN);
        assertEquals(groupe1.getListePierres().size(),a+1);
    }

    /**
     * Test of fusion method, of class Groupe.
     */
    @Test
    public void testFusion() {
        System.out.println("fusion");
        
    }

    /**
     * Test of calculLiberte method, of class Groupe.
     */
    @Test
    public void testCalculLiberte() {
        System.out.println("calculLiberte");
       
    }

    /**
     * Test of changerEtat method, of class Groupe.
     */
    @Test
    public void testChangerEtat() {
        System.out.println("changerEtat");
       
    } 
}
