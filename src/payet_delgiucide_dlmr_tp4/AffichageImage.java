/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Romain
 */
class AfficheImage extends JPanel {

    Image eau;

    AfficheImage(String s) {
        eau = getToolkit().getImage(s);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(eau, 0, 0, getWidth(), getHeight(), this);
        g.fillOval(70, 70, 30, 30);
        g.drawOval(20, 20, 30, 30);
    }
}
