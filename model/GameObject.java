package model;


import java.awt.*;

public abstract class GameObject {
    protected Polygon polygon;

    public GameObject(Polygon polygon) {
        this.polygon = polygon;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public abstract void draw(Graphics graphics);



}
