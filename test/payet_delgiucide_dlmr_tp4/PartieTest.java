/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

/**
 *
 * @author Quentin P
 */
public class PartieTest {

    /**
     * Test of NouvellePartie method, of class Partie.
     */
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    /*  @Test
     public void testNouvellePartie() {
     System.out.println("NouvellePartie");
     Joueur j1 = new Joueur("Romain", "N");
     Joueur j2 = new Joueur("Quentin", "B");
     Goban gob = new Goban(19);
     Partie maPartie = new Partie(j1, j2, gob, 19);
     maPartie.NouvellePartie();

     Cette méthode d'utilisation d'un robot ne semble pas fonctionner
     try {
     Robot robot = new Robot();
     robot.setAutoDelay(40);
     robot.setAutoWaitForIdle(true);
     robot.delay(500);
     robot.keyPress(KeyEvent.VK_1);
     robot.delay(500);
     Scanner scan2 = new Scanner(System.in);
     int x=scan2.nextInt();
     System.out.println(x);
     robot.keyRelease(KeyEvent.VK_1);
     robot.delay(500);
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.delay(500);
     robot.keyRelease(KeyEvent.VK_ENTER);
     } catch (AWTException e) {
     e.printStackTrace();
     }
         
     }

     /**
     * Test d'une prise en compte d'une entrée par System.in
     */
    @Test
    public void testPartieBidon() {
        systemInMock.provideText("1\n2\n");
        assertEquals(3, Partie.sumOfNumbersFromSystemIn());
    }

}
