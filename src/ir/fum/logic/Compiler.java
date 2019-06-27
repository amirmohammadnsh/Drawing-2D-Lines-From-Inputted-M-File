package ir.fum.logic;

import ir.fum.gui.RunPanel;
import ir.fum.gui.WestPanel;
import ir.fum.logic.Exceptions.*;
import ir.fum.logic.Statements.*;

import javax.swing.*;
import java.awt.*;

public class Compiler {
    private Statements[] statements;
    private JTextArea consoleTextArea;
    private int foundVariable;
    private WestPanel westPanel;
    private RunPanel runPanel;

    public Compiler(Statements[] statements, JTextArea consoleTextArea, WestPanel westPanel) {
        setStatements(statements);
        setConsoleTextArea(consoleTextArea);
//        System.out.println(getConsoleTextArea().getText());
        setWestPanel(westPanel);
        compileStatements(getStatements(), getConsoleTextArea());


    }

    public WestPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(WestPanel westPanel) {
        this.westPanel = westPanel;
    }


    public RunPanel getRunPanel() {
        return runPanel;
    }

    public void setRunPanel(RunPanel runPanel) {
        this.runPanel = runPanel;
    }

    private void compileStatements(Statements[] statements, JTextArea consoleTextArea) {

        for (Statements statement : statements) {

            correct(statement, consoleTextArea);

        }
//        System.out.println(consoleTextArea.getText().isEmpty());
        if (consoleTextArea.getText().isEmpty()) {
            consoleTextArea.setText(" SUCCEEDED !");
            if (!getWestPanel().getRunPanelAdded()) {
                runPanel = new RunPanel(getWestPanel().getMainFrame(), getStatements());

                getWestPanel().setRunPanelAdded(true);
//            runPanel.setVisible(true);
//            runPanel.repaint();

                getWestPanel().add(runPanel);

                getWestPanel().revalidate();// If you add components to the frame after it is visible then you need to revalidate() the JPanel that you add the components to.
                runPanel.repaint(); // this Keeps the RunPanel Area As We Set in The Code
            } else {
//               if (getWestPanel().getComponentAt(10,600) instanceof RunPanel)
//              getWestPanel().remove(getWestPanel().getComponentAt(10,60));
//              getWestPanel().revalidate();
                for(Component component:getWestPanel().getComponents()){
                    if (component instanceof RunPanel){
                        getWestPanel().remove(component);
                        getWestPanel().revalidate();
                        getWestPanel().repaint();
                        runPanel = new RunPanel(getWestPanel().getMainFrame(), getStatements());
                        getWestPanel().setRunPanelAdded(true);
                        getWestPanel().add(runPanel);
                        getWestPanel().revalidate();
                        runPanel.repaint();
                    }
                }




            }

        }


    }

    private boolean isFoundVariable(Statements[] statements, String nameOfVariable, int statementIndex) {

        for (int i = statementIndex; i >= 0; i--) {
            if (statements[i] instanceof Set) {
                Set setStatement = (Set) statements[i];
                if (setStatement.getNameOfVariable() != null && setStatement.getNameOfVariable().equals(nameOfVariable)) {
                    foundVariable = setStatement.getValue();
                    return true;
                }
            }
        }
        return false;
    }

    private void correct(Statements statement, JTextArea consoleTextArea) {

        try {


            switch (statement.getClass().getSimpleName()) {


                case "Set":
                    Set setStatement = (Set) statement;
                    if (setStatement.getRawNameOfVariable() == null ||
                            setStatement.getRawValue() == null) {

                        if (!setStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(setStatement.getLineNumber(), setStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(setStatement.getLineNumber(), setStatement.getLineText());
                        }
                    } else {
                        setStatement.parseRawNameOfVariable();
                        setStatement.parseRawValue();
                    }
                    break;

                case "Move":

                    Move moveStatement = (Move) statement;
                    if (moveStatement.getRawX() == null ||
                            moveStatement.getRawY() == null) {

                        if (!moveStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(moveStatement.getLineNumber(), moveStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(moveStatement.getLineNumber(), moveStatement.getLineText());
                        }


                    } else {
                        try {
                            moveStatement.parseRawX();
                            moveStatement.parseRawY();
                        } catch (VariableException ex) {
                            switch (ex.getArgumentNumber()) {

                                case 1:
                                    if (isFoundVariable(statements, moveStatement.getRawX(), moveStatement.getStatementIndex())) {
                                        moveStatement.setX(foundVariable);
                                        try {
                                            moveStatement.parseRawY();
                                        } catch (VariableException e) {
                                            if (isFoundVariable(statements, moveStatement.getRawY(), moveStatement.getStatementIndex())) {
                                                moveStatement.setY(foundVariable);
                                            }
                                        }
                                    } else
                                        throw new UnidentifiedArgumentException(moveStatement.getLineNumber(), moveStatement.getLineText(), 1);

                                    break;
                                case 2:
                                    if (isFoundVariable(statements, moveStatement.getRawY(), moveStatement.getStatementIndex())) {
                                        moveStatement.setY(foundVariable);
                                    } else
                                        throw new UnidentifiedArgumentException(moveStatement.getLineNumber(), moveStatement.getLineText(), 2);
                                    break;
                            }
                        }

                    }


                    break;

                case "Inc":
                    Inc incStatement = (Inc) statement;
                    if (incStatement.getRawNameOfVariable() == null ||
                            incStatement.getRawValue() == null) {

                        if (!incStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(incStatement.getLineNumber(), incStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(incStatement.getLineNumber(), incStatement.getLineText());
                        }


                    } else {

                        incStatement.parseRawNameOfVariable();
                        incStatement.parseRawValue();

                        if (isFoundVariable(statements, incStatement.getNameOfVariable(), incStatement.getStatementIndex())) {

                            incStatement.setValue(foundVariable + incStatement.getValue());

                        } else
                            throw new UnidentifiedArgumentException(incStatement.getLineNumber(), incStatement.getLineText(), 1);


                    }

                    break;


                case "Style":
                    Style styleStatement = (Style) statement;
                    if (styleStatement.getRawStyleType() == null) {

                        if (!styleStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(styleStatement.getLineNumber(), styleStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(styleStatement.getLineNumber(), styleStatement.getLineText());
                        }


                    } else {
                        styleStatement.parseRawStyleType();
                    }

                    break;

                case "Size":
                    Size sizeStatement = (Size) statement;
                    if (sizeStatement.getRawPenSize() == null) {
                        if (!sizeStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(sizeStatement.getLineNumber(), sizeStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(sizeStatement.getLineNumber(), sizeStatement.getLineText());
                        }

                    } else {
                        sizeStatement.parseRawPenSize();
                    }
                    break;


                case "PenColor":
                    PenColor penColorStatement = (PenColor) statement;
                    if (penColorStatement.getRawR() == null ||
                            penColorStatement.getRawG() == null ||
                            penColorStatement.getRawB() == null) {
                        if (!penColorStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(penColorStatement.getLineNumber(), penColorStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(penColorStatement.getLineNumber(), penColorStatement.getLineText());
                        }


                    } else {
                        penColorStatement.parseRawR();
                        penColorStatement.parseRawG();
                        penColorStatement.parseRawB();
                    }
                    break;

                case "For":
                    For forStatement = (For) statement;
                    if (forStatement.getRawNumberOfNextStatements() == null ||
                            forStatement.getRawNumberOfRepetition() == null) {
                        if (!forStatement.isClosedParanthese()) {
                            throw new UnFinishedStatementException(forStatement.getLineNumber(), forStatement.getLineText());
                        } else {
                            throw new UnProperArguementsException(forStatement.getLineNumber(), forStatement.getLineText());
                        }
                    } else {
                        forStatement.parseRawNumberOfNextStatements();
                        forStatement.pareseRawNumberOfRepetition();
                    }

                    break;
//
//                case "Up":
//
//                    break;
//                case "Down":
//
//                    break;
                case "UnknownStatement":
                    UnknownStatement unknownStatement = (UnknownStatement) statement;
                    throw new UnidentifiedStatementException(unknownStatement.getLineNumber(), unknownStatement.getLineText());

            }
        } catch (UnidentifiedStatementException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (UnFinishedStatementException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (UnProperArguementsException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (NumberFormatFirstArgumentException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (NumberFormatSecondArgumentException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (NumberFormatThirdArgumentException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (OutOfBoundsFirstArgumrntException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (OutOfBoundsSecondArgumrntException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (OutOfBoundsThirdArgumrntException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (NotSupportedStyleTypeException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (UnProperBeginningCharacterException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (AlphebaticInputException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (FloatInputException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
        } catch (UnidentifiedArgumentException ex) {
            getConsoleTextArea().append(ex.toString() + "\n");
            if (statement instanceof Move) {
                Move moveStatement = (Move) statement;
                if (ex.getArgumentNumber() == 1) {
                    try {
                        moveStatement.parseRawY();
                    } catch (VariableException e) {
                        try {
                            if (isFoundVariable(statements, moveStatement.getRawY(), moveStatement.getStatementIndex())) {
                                moveStatement.setY(foundVariable);
                            } else
                                throw new UnidentifiedArgumentException(moveStatement.getLineNumber(), moveStatement.getLineText(), 2);
                        } catch (UnidentifiedArgumentException e1) {
//                        e1.setArgumentNumber(2);
                            getConsoleTextArea().append(e1.toString() + "\n");
                        }
                    }
                }
            }
        }


    }


    public JTextArea getConsoleTextArea() {
        return consoleTextArea;
    }

    public void setConsoleTextArea(JTextArea consoleTextArea) {
        this.consoleTextArea = consoleTextArea;
    }

    public Statements[] getStatements() {
        return statements;
    }

    public void setStatements(Statements[] statements) {
        this.statements = statements;
    }


}
