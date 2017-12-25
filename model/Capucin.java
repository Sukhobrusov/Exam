package model;

import java.awt.*;

public class Capucin extends GameObject{

    public Capucin(Polygon polygon) {
        super(polygon);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(new Color(0xAD0CFF));
        graphics2D.fillPolygon(polygon);
    }
}
