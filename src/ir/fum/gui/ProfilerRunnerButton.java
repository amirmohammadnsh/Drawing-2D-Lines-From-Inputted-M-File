package ir.fum.gui;

import ir.fum.logic.Pen;
import ir.fum.logic.Run;
import ir.fum.logic.RunType;
import ir.fum.logic.Statements.Statements;
import ir.fum.logic.Statements.StyleType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilerRunnerButton extends JButton {
    private Statements[] statements;
    private PaintPanel paintPanel;
    private WestPanel westPanel;
    private TimeFrame timeFrame;


    public ProfilerRunnerButton(Statements[] statements, PaintPanel paintPanel, Pen pen, WestPanel westPanel) {
        setStatements(statements);
        setPaintPanel(paintPanel);
        setWestPanel(westPanel);
        setText("Profiler Runner");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                paintPanel.repaint();
                initPen(pen);

                timeFrame = new TimeFrame();
//                Thread threadTimePanel = new Thread(timeFrame);
//                threadTimePanel.setPriority(10);
//                threadTimePanel.start();
//                try {
//                    threadTimePanel.join();
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//
//                getWestPanel().add(timeFrame);
//                getWestPanel().revalidate();
//                timeFrame.repaint();
//               for(Component component : getWestPanel().getComponents()){
////                   System.out.println(component.toString());
//                   if(component instanceof TimeFrame){

                new Run(RunType.PROFILER, getStatements(), getPaintPanel(), pen, timeFrame);
//


            }
        });

    }

    public WestPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(WestPanel westPanel) {
        this.westPanel = westPanel;
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    public void setPaintPanel(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    public Statements[] getStatements() {
        return statements;
    }

    public void setStatements(Statements[] statements) {
        this.statements = statements;
    }

    public void initPen(Pen pen) {
        pen.setStartPointX(0);
        pen.setStartPointY(0);
        pen.setStopPointX(0);
        pen.setStopPointY(0);
        pen.setStyleType(StyleType.SOLID);
        pen.setPenSize(0);
        pen.setColorR(0);
        pen.setColorG(0);
        pen.setColorB(0);


    }

}




