package ir.fum.logic;

import ir.fum.gui.PaintPanel;
import ir.fum.logic.Statements.*;

import java.util.LinkedList;

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
            getPaintPanel().setPermisionToDraw(true);
//            getPaintPanel().repaint();
            getPaintPanel().paintAll(getPaintPanel().getGraphics());
//            getPaintPanel().repaint();
//            getPaintPanel().setVisible(true);
//            EventQueue.invokeLater();
//            getPaintPanel().drawing();

//            getPaintPanel().repaint();
//            getPaintPanel().getMainFrame().repaint();
//            getPaintPanel().repaint();
//            getPaintPanel().getMainFrame().revalidate();
//            getPaintPanel().updateUI();

//            getPaintPanel().repaint();
//        getPaintPanel().doDrawing(getPaintPanel().getGraphics(), StyleType.SOLID,6,20,20,100,100);
//            Graphics g = getPaintPanel().getGraphics();
//            g.setColor(new Color(250, 250, 250));
//            g.drawLine(10, 10, 20, 30);
//            g.drawString("Hello", 30, 60);
//
//            g.setColor(new Color(100, 250, 0));
//            g.drawLine(100, 100, 120, 100);


        } else {   //profile run
            profilerPainting(statements, pen);

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
                            pen.getStopPointY(), pen.getColorR(), pen.getColorG(), pen.getColorB(), getPaintPanel(), getRunType());
                }
                pen.setStartPointX(pen.getStopPointX());
                pen.setStartPointY(pen.getStopPointY());

            }
        }
//        getPaintPanel().setPermisionToDraw(true);
//        getPaintPanel().revalidate();
//        getPaintPanel().repaint();
//        getPaintPanel().paint(getPaintPanel().getGraphics());

//        getPaintPanel().update(getPaintPanel().getGraphics());


    }

    public void profilerPainting(Statements[] statements, Pen pen) {

        for (Statements statement : statements) {

            switch (statement.getClass().getSimpleName()) {


                case "Set":
                    Set setStatement = (Set) statement;


                    break;

                case "Move":
                    Move moveStatement = (Move) statement;
                    double xDistance = moveStatement.getX() - pen.getStartPointX();
                    double yDistance = moveStatement.getY() - pen.getStartPointY();
                    double length = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
                    double time = 5 * length;
                    double xStep  = xDistance / length;
                    double yStep  = yDistance / time;
//                    LinkedList<int[][]> points = new ;
                    
                    for (int i = 0; i < length; i++) {
                        try {

//                            pen.setStopPointX(xStep );
//                            pen.setStopPointY((int) (yDistance / time) ;
                            if (pen.getPenState().ordinal() == 1) {

                                pen.doDrawing(paintPanel.getGraphics(), pen.getStyleType(), pen.getPenSize(), pen.getStartPointX(), pen.getStartPointY(), pen.getStopPointX(),
                                        pen.getStopPointY(), pen.getColorR(), pen.getColorG(), pen.getColorB(), getPaintPanel(), getRunType());
                            }
                            pen.setStartPointX(pen.getStopPointX());
                            pen.setStartPointY(pen.getStopPointY());


                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

//                    TimeUnit.MILLISECONDS.sleep(100);
//

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

        }
//      s


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
