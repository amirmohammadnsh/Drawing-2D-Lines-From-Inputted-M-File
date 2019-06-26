package ir.fum.logic;

import ir.fum.gui.PaintPanel;
import ir.fum.logic.Statements.Statements;

import java.awt.*;

public class Run {
    private RunType runType;
    private Statements[] statements;
    private PaintPanel paintPanel;

    public Run(RunType runType, Statements[] statements, PaintPanel paintPanel) {
        setRunType(runType);
        setStatements(statements);
        setPaintPanel(paintPanel);

        if (runType.ordinal() == 0) {  //normal run

            Graphics g = getPaintPanel().getGraphics();
            g.setColor(new Color(250, 250, 250));
            g.drawLine(10, 10, 20, 30);
            g.drawString("Hello", 30, 60);

            g.setColor(new Color(100, 250, 0));
            g.drawLine(100, 100, 120, 100);

        } else {   //profile run

        }

    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public Statements[] getStatements() {
        return statements;
    }

    public void setStatements(Statements[] statements) {
        this.statements = statements;
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    public void setPaintPanel(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

}
