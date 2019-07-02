package ir.fum.gui;

import ir.fum.logic.Pen;
import ir.fum.logic.Run;
import ir.fum.logic.RunType;
import ir.fum.logic.Statements.Statements;
import ir.fum.logic.Statements.StyleType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NormalRunnerButton extends JButton {
    private Statements[] statements;
    private PaintPanel paintPanel;
    private Run run;
    private RunPanel runPanel;



    public NormalRunnerButton(Statements[] statements, PaintPanel paintPanel, Pen pen, RunPanel runPanel) {
        setStatements(statements);
        setPaintPanel(paintPanel);
        setRunPanel(runPanel);
        setText("Normal Runner");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                initPen(pen);
                getRunPanel().getProfilerRunnerButton().setEnabled(false);
                run = new Run(RunType.NORMAL, getStatements(), getPaintPanel(), pen, null);
            }
        });

//        addActionListener(new ActionListener() {
//
//            @Override
//
//            public void actionPerformed(ActionEvent e) {
//
//                run = new Run(RunType.NORMAL,getStatements(),getPaintPanel(),pen);
//
//
//            }
//        };

//        addActionListener(new NormalButtonActionListener(getStatements(),getPaintPanel(),pen));


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

    public RunPanel getRunPanel() {
        return runPanel;
    }

    public void setRunPanel(RunPanel runPanel) {
        this.runPanel = runPanel;
    }
}
