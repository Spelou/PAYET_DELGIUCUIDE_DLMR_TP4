/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

/**
 *
 * @author Quentin
 */
public class PAYET_DELGIUCIDE_DLMR_TP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Goban gob = new Goban();
        gob.afficher();
        gob.poserPierre(0, 0, "N");
        gob.afficher();
        gob.poserPierre(0, 0, "B");
        gob.afficher();
        gob.poserPierre(0, 1, "N");
        gob.poserPierre(1, 0, "N");
        gob.poserPierre(0, 0, "B");
        gob.afficher();
    }

}
