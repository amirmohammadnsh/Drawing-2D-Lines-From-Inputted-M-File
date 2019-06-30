package ir.fum.logic;

import ir.fum.gui.PaintPanel;
import ir.fum.logic.Statements.StyleType;

import java.awt.*;

public class Pen {

    private static Pen instance;
    private int startPointX;
    private int startPointY;
    private int stopPointX;
    private int stopPointY;
    private int penSize;
    private int colorR;
    private int colorG;
    private int colorB;
    private RunType runType = RunType.NORMAL;
    private PaintPanel paintPanel;
    private StyleType styleType = StyleType.SOLID;
    private Graphics paintPanelGraphics;
    private PenState penState = PenState.ONPAPER;

    private Pen() {

    }

    public static synchronized Pen getInstance() {
        if (instance == null) {
            instance = new Pen();
        }
        return instance;

    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    public void setPaintPanel(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    public PenState getPenState() {
        return penState;
    }

    public void setPenState(PenState penState) {
        this.penState = penState;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public void doDrawing(Graphics g, StyleType styleType, int penSize,
                          int startPointX, int startPointY, int stopPointX, int stopPointY,
                          int colorR, int colorG, int colorB, PaintPanel paintPanel, RunType runType) {

        setPaintPanel(paintPanel);
        setRunType(runType);
        Graphics2D g2d = (Graphics2D) g.create();
        float[] dash = new float[3];
        g2d.setColor(new Color(colorR, colorG, colorB));

        if (styleType.ordinal() == 0) { //solid
            BasicStroke bs1 = new BasicStroke(penSize);
            g2d.setStroke(bs1);
        }

        if (styleType.ordinal() == 1) { //dashed
            dash[0] = 2f * penSize;
            dash[1] = 0f;
            dash[2] = 2f * penSize;
            BasicStroke bs1 = new BasicStroke(penSize, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);

            g2d.setStroke(bs1);
        } else if (styleType.ordinal() == 2) { //dotted
            dash[0] = 1f * penSize;
            dash[1] = 1f * penSize;
            dash[2] = 1f * penSize;
            BasicStroke bs1 = new BasicStroke(penSize, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);

            g2d.setStroke(bs1);
        }

        if (getRunType().ordinal() == 0) {


            getPaintPanel().getLines().add(new Lines(startPointX, startPointY, stopPointX, stopPointY, g2d));
        } else {
            g2d.drawLine(startPointX, startPointY, stopPointX, stopPointY);
        }
//        getPaintPanel().repaint();
//        g2d.dispose();

//        getPaintPanel().setStartPointX(startPointX);
//        getPaintPanel().setStartPointY(startPointY);
//        getPaintPanel().setStopPointX(stopPointX);
//        getPaintPanel().setStopPointY(stopPointY);
//        getPaintPanel().setGraphics2D(g2d);
//        getPaintPanel().setPermisionToDraw(true);
//        getPaintPanel().repaint();

//        getPaintPanel().update(g2d);
//        getPaintPanel().setGraphics2D(g2d);
//        getPaintPanel().updateUI();

//        getPaintPanel().setGraphics2D(getPaintPanel().getGraphics());
//        getPaintPanel().paint(g2d);
//        getPaintPanel().revalidate();
//        getPaintPanel().repaint();
//        g2d.dispose();
//        g2d.drawLine(startPointX, startPointY, stopPointX, stopPointY);
//        getPaintPanel().paint(g2d);
//        g2d.dispose();
    }


    public int getColorR() {
        return colorR;
    }

    public void setColorR(int colorR) {
        this.colorR = colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public void setColorG(int colorG) {
        this.colorG = colorG;
    }

    public int getColorB() {
        return colorB;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
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

    public int getPenSize() {
        return penSize;
    }

    public void setPenSize(int penSize) {
        this.penSize = penSize;
    }

    public StyleType getStyleType() {
        return styleType;
    }

    public void setStyleType(StyleType styleType) {
        this.styleType = styleType;
    }

    public Graphics getPaintPanelGraphics() {
        return paintPanelGraphics;
    }

    public void setPaintPanelGraphics(Graphics paintPanelGraphics) {
        this.paintPanelGraphics = paintPanelGraphics;
    }
}
