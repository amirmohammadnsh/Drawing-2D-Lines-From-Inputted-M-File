package ir.fum.logic;

import ir.fum.gui.PaintPanel;
import ir.fum.logic.Statements.*;

public class Run {
    private RunType runType;
    private Statements[] statements;
    private PaintPanel paintPanel;
    private Pen pen;

    public Run(RunType runType, Statements[] statements, PaintPanel paintPanel, Pen pen) {
        setRunType(runType);
        setStatements(statements);
        //TODO
//        for (Statements statement:statements){
//            System.out.println(statement.getLineText());
//        }
        setPaintPanel(paintPanel);
        setPen(pen);
        if (runType.ordinal() == 0) {  //normal run

            normalPainting(statements, pen);
//        getPaintPanel().doDrawing(getPaintPanel().getGraphics(), StyleType.SOLID,6,20,20,100,100);
//            Graphics g = getPaintPanel().getGraphics();
//            g.setColor(new Color(250, 250, 250));
//            g.drawLine(10, 10, 20, 30);
//            g.drawString("Hello", 30, 60);
//
//            g.setColor(new Color(100, 250, 0));
//            g.drawLine(100, 100, 120, 100);


        } else {   //profile run

        }

    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void normalPainting(Statements[] statements, Pen pen) {
        for (Statements statement : statements) {

            switch (statement.getClass().getSimpleName()) {


                case "Set":
                    Set setStatement = (Set) statement;


                    break;

                case "Move":
                    Move moveStatement = (Move) statement;
                    pen.setStopPointX(moveStatement.getX());
                    pen.setStopPointY(moveStatement.getY());

                    break;

                case "Inc":
                    Inc incStatement = (Inc) statement;

                    break;


                case "Style":
                    Style styleStatement = (Style) statement;
                    pen.setStyleType(styleStatement.getStyleType());
                    break;

                case "Size":
                    Size sizeStatement = (Size) statement;
                    pen.setPenSize(sizeStatement.getPenSize());
                    break;


                case "PenColor":
                    PenColor penColorStatement = (PenColor) statement;
                    pen.setColorR(penColorStatement.getR());
                    pen.setColorG(penColorStatement.getG());
                    pen.setColorB(penColorStatement.getB());
                    break;

                case "For":
                    For forStatement = (For) statement;
                    for (int i = 0; i < forStatement.getNumberOfRepetition(); i++) {
                        Statements[] statementsOfFor = new Statements[forStatement.getNumberOfNextStatements()];
                        for (int j = 0; j < statementsOfFor.length; j++) {

                            statementsOfFor[j] = statements[forStatement.getStatementIndex() + 1];

                        }
                        normalPainting(statementsOfFor, pen);
                    }

                    break;
//
                case "Up":
                    pen.setPenState(PenState.OFFPAPER);
                    break;
                case "Down":
                    pen.setPenState(PenState.ONPAPER);
                    break;
            }
            if (statement instanceof Move) {
                if (pen.getPenState().ordinal() == 1) {
                    pen.doDrawing(paintPanel.getGraphics(), pen.getStyleType(), pen.getPenSize(), pen.getStartPointX(), pen.getStartPointY(), pen.getStopPointX(),
                            pen.getStopPointY(), pen.getColorR(), pen.getColorG(), pen.getColorB());
                }
                pen.setStartPointX(pen.getStopPointX());
                pen.setStartPointY(pen.getStopPointY());

            }
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
