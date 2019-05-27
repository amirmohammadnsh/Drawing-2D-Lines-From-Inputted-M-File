package ir.fum.logic;

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





    }


    private void printError(String errorMessage , JTextArea consoleTextArea){



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
