package model;

import java.awt.*;

public class EmptyBoard extends GameObject {
    public EmptyBoard(Polygon polygon) {
        super(polygon);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(new Color(0));
        graphics2D.drawPolygon(polygon);
    }
}
