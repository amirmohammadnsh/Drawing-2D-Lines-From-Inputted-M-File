package ir.fum.gui;

import ir.fum.logic.Run;
import ir.fum.logic.RunType;
import ir.fum.logic.Statements.Statements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NormalRunnerButton extends JButton {
    private Statements[] statements;
    private PaintPanel paintPanel;

    public NormalRunnerButton(Statements[] statements,PaintPanel paintPanel) {
        setStatements(statements);
        setPaintPanel(paintPanel);
        setText("Normal Runner");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Run(RunType.NORMAL, getStatements(),getPaintPanel());
            }
        });


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

}
