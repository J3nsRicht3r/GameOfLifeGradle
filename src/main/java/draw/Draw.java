package draw;

import game.GM;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd2 = (Graphics2D) g;

        gd2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        g.setColor(Color.RED);
        g.drawRect(9, 9, Gui.WIDTH + 2, Gui.HIGHT + 2);

        for (int x = 0; x < GM.CellCountW; x++) {
            for (int y = 0; y < GM.CellCountH; y++) {
                if (GM.cells[x][y]) {
                    g.setColor(Color.BLACK);
                    g.drawRect(x + Gui.XOFF, y + Gui.YOFF, 1, 1);
                } else {
                    g.setColor(Color.WHITE);
                    g.drawRect(x + Gui.XOFF, y + Gui.YOFF, 1, 1);
                }
            }
        }
        repaint();
    }

}
