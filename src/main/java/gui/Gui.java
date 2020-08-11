package gui;

import draw.Draw;

import javax.swing.*;

public class Gui {
    public static final int WIDTH = 1242, HIGHT = 662, XOFF = 10, YOFF = 10;
    public static Draw d;
    JFrame jf;

    public void create() {
        // Window title
        jf = new JFrame("Game of Life");
        // Window size
        jf.setSize(1280, 720);
        // Close button action "exit"
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Window localisation center
        jf.setLocationRelativeTo(null);
        // Window unslideable
        jf.setResizable(false);

        d = new Draw();
        d.setBounds(0, 0, 1280, 720);
        d.setVisible(true);
        jf.add(d);

        jf.setVisible(true);

    }
}

