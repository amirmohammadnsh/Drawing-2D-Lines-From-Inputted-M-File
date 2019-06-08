package ir.fum.logic;

import ir.fum.logic.Exceptions.*;
import ir.fum.logic.Statements.*;

import javax.swing.*;

public class Compiler {
    private Statements[] statements;
    private JTextArea consoleTextArea;

    public Compiler(Statements[] statements, JTextArea consoleTextArea) {
        setStatements(statements);
        setConsoleTextArea(consoleTextArea);
        compileStatements(getStatements(), getConsoleTextArea());


    }

    private void compileStatements(Statements[] statements, JTextArea consoleTextArea) {

        for (Statements statement : statements) {
            correct(statement, consoleTextArea);

        }


    }

    private void correct(Statements statement, JTextArea consoleTextArea) {

        try {


            switch (statement.getClass().getSimpleName()) {

                case "Move":


                    break;
                case "Set":

                    break;
                case "Inc":
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

//                } else {
////                ((Move)statement).getRawX().
//                    try {
//                        ((PenColor) statement).parseRawX();
//                        ((PenColor) statement).parseRawY();
//                    } catch (NumberFormatFirstArgumentException ex) {
//                    ((Move)statement).getRawX().trim().is


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

                case "Up":
                    break;
                case "Down":
                    break;
                case "UnknownStatement":
                    break;
            }
//        if (statement instanceof Move) {
//            if (((Move) statement).getRawX().equals(null) || ((Move) statement).getRawY().equals(null)) {
//            consoleTextArea.append("Not Proper Arguments\n");
//
//            }else{
////                ((Move)statement).getRawX().
//                try{
//                    ((Move)statement).parseRawX();
//                    ((Move)statement).parseRawY();
//                }catch (NumberFormatFirstArgumentException ex){
////                    ((Move)statement).getRawX().trim().is
//
//
//
//                }catch (NumberFormatSecondArgumentException ex){
//
//
//
//
//                }
//
//
//            }
//        }
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
        }


    }


    private void printError(String errorMessage, JTextArea consoleTextArea) {


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
