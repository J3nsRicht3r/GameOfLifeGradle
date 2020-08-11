package game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class XY {
    public int x, y;
    public boolean b;

    public XY(int x, int y, boolean b) {
        this.x = x;
        this.y = y;
        this.b = b;
    }
}

public class GM {

    public static final int CellCountW = 1242;
    public static final int CellCountH = 662;
    public static boolean[][] cells = new boolean[CellCountW][CellCountH];
    private static List<XY> changes = new ArrayList<>(); // Liste mit den Änderungen für die nächste Generation
    public static int gen = 0;
    private final int startCells = 30_000;

    public static void nextGen() {
        gen++;
        //System.out.println("Generation; " + gen);

        for (int x = 0; x < CellCountW; x++) {
            for (int y = 0; y < CellCountH; y++) {
                int n = neighbours(x, y);
                // Regel 1
                if (n == 3 && !cells[x][y]) {
                    cells[x][y] = true;
                    changes.add(new XY(x, y, true));
                }
                // Regel 2
                if (n < 2) {
                    cells[x][y] = false;
                    changes.add(new XY(x, y, false));
                }
                // Regel 3
                if (n == 2 || n == 3) {
                }
                // Regel 4
                if (n > 3) {
                    cells[x][y] = false;
                    changes.add(new XY(x, y, false));
                }
            }
        }
        changes.forEach(xy -> cells[xy.x][xy.y] = xy.b);    // Anwendungen aller Änderungen
        changes.clear();                                    // Putzen der Liste.
    }

    public static int neighbours(int x, int y) {
        int count = 0;

        int[] xoff = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] yoff = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            try {
                if (cells[x + xoff[i]][y + yoff[i]]) {
                    count++;
                }
            } catch (Exception e) {
            }
        }
        return count;
    }

    public static int r(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public void setup() {
        for (int i = 0; i < startCells; i++) {
            int x = r(0, CellCountW);
            int y = r(0, CellCountH);

            cells[x][y] = true;
        }
    }
}
