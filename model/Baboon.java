package model;

import java.awt.*;

public class Baboon extends GameObject{

    public Baboon(Polygon polygon) {
        super(polygon);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawPolygon(polygon);
        graphics2D.setColor(new Color(0x382805));
        graphics2D.fillPolygon(polygon);
    }
}
