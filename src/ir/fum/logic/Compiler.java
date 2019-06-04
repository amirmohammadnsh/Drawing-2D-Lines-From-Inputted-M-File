package ir.fum.logic;

import ir.fum.logic.Exceptions.*;
import ir.fum.logic.Statements.PenColor;
import ir.fum.logic.Statements.Statements;

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
                    break;
                case "Size":
                    break;
                case "PenColor":
                    PenColor penColor = ((PenColor) statement);
                    if (penColor.getRawR() == null ||
                            penColor.getRawG() == null ||
                            penColor.getRawB() == null) {
                        if (!penColor.isClosedParanthese()) {
                            throw new UnFinishedStatementException(penColor.getLineNumber(), penColor.getLineText());
                        } else {
                            throw new UnProperArguementsException(penColor.getLineNumber(), penColor.getLineText());
                        }


                    } else {
                        penColor.parseRawR();
                        penColor.parseRawG();
                        penColor.parseRawB();


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
