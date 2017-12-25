package model;

import java.awt.*;

public class PolygonHelper {
    public static Polygon getPolygon(int x, int y) {

        int j = x * 100;
        int xPoints[] = {
                45 + j,
                110 + j,
                145 + j,
                110 + j,
                45 + j,
                10 + j
        };
        int i = y * 90 + 45 * (x % 2);
        int yPoints[] = {
                20 + i,
                20 + i,
                65 + i,
                110 + i,
                110 + i,
                65 + i
        };

        int nPoints = 6;
        Polygon p = new Polygon(xPoints, yPoints, nPoints);
        return p;
    }
}
