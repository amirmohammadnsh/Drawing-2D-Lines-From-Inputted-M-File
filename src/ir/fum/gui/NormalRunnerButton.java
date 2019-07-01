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

    public NormalRunnerButton(Statements[] statements, PaintPanel paintPanel, Pen pen) {
        setStatements(statements);
        setPaintPanel(paintPanel);
        setText("Normal Runner");
addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        initPen(pen);


        run = new Run(RunType.NORMAL,getStatements(),getPaintPanel(),pen,null);
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

}
