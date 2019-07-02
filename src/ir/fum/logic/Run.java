package ir.fum.logic;

import ir.fum.gui.PaintPanel;
import ir.fum.gui.TimeFrame;
import ir.fum.logic.Exceptions.OutOfBoundsFirstArgumrntException;
import ir.fum.logic.Exceptions.OutOfBoundsSecondArgumrntException;
import ir.fum.logic.Exceptions.RunTimeMoveException;
import ir.fum.logic.Statements.*;

public class Run {
    private RunType runType;
    private Statements[] statements;
    private PaintPanel paintPanel;
    private Pen pen;
    private TimeFrame timeFrame;
    private boolean showTime = true;
    private double totalTime = 0;
    private int forIndex;


    public Run(RunType runType, Statements[] statements, PaintPanel paintPanel, Pen pen, TimeFrame timeFrame) {
        setRunType(runType);
        setTimeFrame(timeFrame);
        setStatements(statements);
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
            try {
                profilerPainting(statements, pen);
                getTimeFrame().setVisible(true);
            } catch (RunTimeMoveException e) {
                e.showMessage();
            }


        }

    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
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
//                    incStatement.setValue(incStatement.getValue()+ incStatement.getValue());
//                    for(Statements statementInc:statements){


//                    }

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
                    forIndex = forStatement.getStatementIndex();
                    Statements[] statementsOfFor = new Statements[forStatement.getNumberOfNextStatements()];
                    int index = forStatement.getStatementIndex();
                    for (int j = 0; j < statementsOfFor.length; j++) {
                        statementsOfFor[j] = statements[++index];
                    }
                    for (int i = 0; i < forStatement.getNumberOfRepetition(); i++) {

                        updateVariable(statementsOfFor, index);
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
                default:
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

    public void profilerPainting(Statements[] statements, Pen pen) throws RunTimeMoveException {

        for (Statements statement : statements) {

            switch (statement.getClass().getSimpleName()) {


                case "Set":
                    Set setStatement = (Set) statement;


//                        Thread.sleep(setStatement.getSetTime());
                    delay(setStatement.getSetTime());
//                        System.out.println(Thread.currentThread().getName());


                    if (!showTime) {
                        totalTime += setStatement.getSetTime();
                    } else {
                        getTimeFrame().getTimeTextArea().append(" SET \t\t" + setStatement.getSetTime() + "\n");
                    }

                    break;

                case "Move":
                    Move moveStatement = (Move) statement;
//                    pen.setStopPointX(moveStatement.getX());
//                    pen.setStopPointY(moveStatement.getY());
                    double moveX = (double) moveStatement.getX();
                    double moveY = (double) moveStatement.getY();
                    double startX = (double) pen.getStartPointX();
                    double startY = (double) pen.getStartPointY();
                    double xDistance = moveX - startX;
                    double yDistance = moveY - startY;
                    double length = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
                    moveStatement.setMoveTime(5 * length);
                    double xStep = xDistance / length;
                    double yStep = yDistance / length;
                    double stopX = 0;
                    double stopY = 0;
//                    System.out.println(length);

                    for (int i = 1; i <= length; i++) {
                        if ((stopX > 1000 || stopX < 0) || (stopY > 1000 || stopY < 0)) {
//                            System.out.println("hello");
                            throw new RunTimeMoveException((getPaintPanel().getMainFrame()));

                        } else {
                            stopX = startX + (xDistance / length);
                            stopY = startY + (yDistance / length);
                        }


                        if (pen.getPenState().ordinal() == 1) {

                            pen.doDrawingDouble(paintPanel.getGraphics(), pen.getStyleType(), pen.getPenSize(),
                                    startX, startY, stopX, stopY,
                                    pen.getColorR(), pen.getColorG(), pen.getColorB(), getPaintPanel(), getRunType());
                        }

                        startX = stopX;
                        startY = stopY;
//                            System.out.println("startX : " + startX + "startY : " + startY );

                        delay(5);

                    }
                    pen.setStartPointX(moveStatement.getX());
                    pen.setStartPointY(moveStatement.getY());
//                    System.out.println(" X : " + pen.getStartPointX() + "Y : " + pen.getStartPointY());
//                    TimeUnit.MILLISECONDS.sleep(100);
                    if (!showTime) {
                        totalTime += moveStatement.getMoveTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" MOVE \t\t" + moveStatement.getMoveTime() + "\n");
                    }

                    break;

                case "Inc":
                    Inc incStatement = (Inc) statement;
                    delay(incStatement.getIncTime());

                    if (!showTime) {
                        totalTime += incStatement.getIncTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" INC \t\t" + incStatement.getIncTime() + "\n");
                    }

                    break;


                case "Style":
                    Style styleStatement = (Style) statement;
                    pen.setStyleType(styleStatement.getStyleType());
                    delay(styleStatement.getStyleTime());
//                    try {
//                        Thread.sleep(styleStatement.getStyleTime());
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    if (!showTime) {
                        totalTime += styleStatement.getStyleTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" STYLE \t\t" + styleStatement.getStyleTime() + "\n");
                    }

                    break;

                case "Size":
                    Size sizeStatement = (Size) statement;
                    pen.setPenSize(sizeStatement.getPenSize());
                    delay(sizeStatement.getSizeTime());
//                    try {
//                        Thread.sleep(sizeStatement.getSizeTime());
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    if (!showTime) {
                        totalTime += sizeStatement.getSizeTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" SIZE \t\t" + sizeStatement.getSizeTime() + "\n");
                    }

                    break;


                case "PenColor":
                    PenColor penColorStatement = (PenColor) statement;
                    pen.setColorR(penColorStatement.getR());
                    pen.setColorG(penColorStatement.getG());
                    pen.setColorB(penColorStatement.getB());
                    delay(penColorStatement.getPenColorTime());
//                    try {
//                        Thread.sleep(penColorStatement.getPenColorTime());
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    if (!showTime) {
                        totalTime += penColorStatement.getPenColorTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" COLOR \t\t" + penColorStatement.getPenColorTime() + "\n");
                    }

                    break;

                case "For":
                    For forStatement = (For) statement;
                    showTime = false;

                    int index = forStatement.getStatementIndex();

                    Statements[] statementsOfFor = new Statements[forStatement.getNumberOfNextStatements()];
                    for (int j = 0; j < statementsOfFor.length; j++) {
                        statementsOfFor[j] = statements[++index];
                    }

                    for (int i = 0; i < forStatement.getNumberOfRepetition(); i++) {

                        updateVariable(statementsOfFor, index);
//                        for(int k=0; k<statementsOfFor.length;k++){
//                            System.out.println(statementsOfFor[k].getLineText());
//                        }
                        profilerPainting(statementsOfFor, pen);
                    }
                    showTime = true;
                    forStatement.setForTime(totalTime);

                    getTimeFrame().getTimeTextArea().append(" FOR \t\t" + forStatement.getForTime() + "\n");
//                    System.out.println(totalTime);
                    totalTime = 0;

                    break;
//
                case "Up":
                    Up upStatement = (Up) statement;
                    pen.setPenState(PenState.OFFPAPER);
                    delay(upStatement.getUpTime());

//                    try {
//                        Thread.sleep(upStatement.getUpTime());
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    if (!showTime) {
                        totalTime += upStatement.getUpTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" UP \t\t" + upStatement.getUpTime() + "\n");
                    }

                    break;
                case "Down":
                    Down downStatement = (Down) statement;
                    pen.setPenState(PenState.ONPAPER);
                    delay(downStatement.getDownTime());
//                    try {
//                        Thread.sleep(downStatement.getDownTime());
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    if (!showTime) {
                        totalTime += downStatement.getDownTime();
                    } else {

                        getTimeFrame().getTimeTextArea().append(" DOWN \t\t" + downStatement.getDownTime() + "\n");
                    }

                    break;
                default:
                    break;
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

    public void delay(double delayTime) {
        long startTime = System.currentTimeMillis();

        for (int count = 0; ; count++) {
            long now = System.currentTimeMillis();
            if (now - startTime >= delayTime)
                break;
// Do nothing
        }


    }


    private void updateVariable(Statements[] afterForStatements, int forIndex) {
        for (Statements item : afterForStatements) {
            if (item instanceof Inc) {
                Inc incstatement = (Inc) item;
                for (int i = forIndex - 1; i >= 0; i--) {                 //check previous statements to find a setted variable
                    if (statements[i] instanceof Set) {
                        Set setStatement = (Set) statements[i];
                        if (setStatement.getNameOfVariable().equals(incstatement.getNameOfVariable())) {

                            setStatement.setValue(setStatement.getValue() + incstatement.getValue());


//                    return true;
                        }
                    }
                }
//        return false;
            } else if (item instanceof Move) {
                Move movestatement = (Move) item;
                for (int i = forIndex - 1; i >= 0; i--) {                 //check previous statements to find a setted variable
                    if (statements[i] instanceof Set) {
                        Set setStatement = (Set) statements[i];
                        if (setStatement.getNameOfVariable().equals(movestatement.getRawX())) {
                            try {
                                movestatement.setX(setStatement.getValue());
                            } catch (OutOfBoundsFirstArgumrntException ex) {
                                RunTimeMoveException runTimeMoveException = new RunTimeMoveException(getPaintPanel().getMainFrame());
                                runTimeMoveException.showMessage();
                            }
                        }
                        if (setStatement.getNameOfVariable().equals(movestatement.getRawY())) {
                            try {
                                movestatement.setY(setStatement.getValue());
                            } catch (OutOfBoundsSecondArgumrntException ex) {
                                RunTimeMoveException runTimeMoveException = new RunTimeMoveException(getPaintPanel().getMainFrame());
                                runTimeMoveException.showMessage();
                            }
                        }


//                    return true;
                    }
                }
            }
//        return false;
        }
    }


}
