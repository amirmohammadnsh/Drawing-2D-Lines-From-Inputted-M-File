package ir.fum.gui;

import ir.fum.logic.Lines;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class PaintPanel extends JPanel {

    private boolean permisionToDraw = false;
    private LinkedList<Lines> lines = new LinkedList<>();
    private MainFrame mainFrame;

    public PaintPanel(MainFrame mainFrame) {
        setMainFrame(mainFrame);
        setLocation(515, 10);
        setSize(900, 740);
        setVisible(true);

//        setBackground(new Color(255,255,170));

//        this.setOpaque(false);
//        setBackground(Color.WHITE);

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public LinkedList<Lines> getLines() {
        return lines;
    }

    public void setLines(LinkedList<Lines> lines) {
        this.lines = lines;
    }

    public boolean isPermisionToDraw() {
        return permisionToDraw;
    }

    public void setPermisionToDraw(boolean permisionToDraw) {
        this.permisionToDraw = permisionToDraw;
    }
    public  void drawing(){
        repaint();
    }

@Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(getLines().size()>0){
            for (int i = 0 ; i<getLines().size();i++){
                getLines().get(i).getGraphics2D().drawLine(
                        getLines().get(i).getStartPointX(),
                        getLines().get(i).getStartPointY(),
                        getLines().get(i).getStopPointX(),
                        getLines().get(i).getStopPointY());

//                repaint();
            }
//            repaint();


        }

    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        if (isPermisionToDraw()) {
//            for (int i = 0; i < getLines().size(); i++) {
//                getLines().get(i).getGraphics2D().drawLine(
//                        getLines().get(i).getStartPointX(),
//                        getLines().get(i).getStartPointY(),
//                        getLines().get(i).getStopPointX(),
//                        getLines().get(i).getStopPointY());
//
//            }
//
//
//        }
//    }


    //    public void paintComponent(Graphics g) {
//        super.paint(g);
//        if (isPermisionToDraw()) {
//           this.getGraphics2D().drawLine(getStartPointX(), getStartPointY(), getStopPointX(), getStopPointY());
//
////            setPermisionToDraw(false);
//        }
//
//
//    }
}
