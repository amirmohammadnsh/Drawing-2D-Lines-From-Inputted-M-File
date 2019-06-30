package ir.fum.logic;

import java.awt.*;

public class Lines {

    private int startPointX;
    private int startPointY;
    private int stopPointX;
    private int stopPointY;
    private Graphics2D graphics2D;

    public Lines(int startPointX,
                 int startPointY,
                 int stopPointX,
                 int stopPointY,
                 Graphics2D graphics2D) {

        setStartPointX(startPointX);
        setStartPointY(startPointY);
        setStopPointX(stopPointX);
        setStopPointY(stopPointY);
        setGraphics2D(graphics2D);


    }

    public int getStartPointX() {
        return startPointX;
    }

    public void setStartPointX(int startPointX) {
        this.startPointX = startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }

    public void setStartPointY(int startPointY) {
        this.startPointY = startPointY;
    }

    public int getStopPointX() {
        return stopPointX;
    }

    public void setStopPointX(int stopPointX) {
        this.stopPointX = stopPointX;
    }

    public int getStopPointY() {
        return stopPointY;
    }

    public void setStopPointY(int stopPointY) {
        this.stopPointY = stopPointY;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }
}
