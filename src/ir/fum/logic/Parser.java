package ir.fum.logic;

import ir.fum.gui.WestPanel;
import ir.fum.logic.Statements.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    private ChosenFile chosenFile;
    private Statements[] statements;
    private boolean closedParenthese = true;
    private JTextArea consoleTextArea;
    private BufferedReader bufferedReader;
    private WestPanel westPanel;

    public Parser(ChosenFile chosenFile, JTextArea consoleTextArea, WestPanel westPanel) {
        //creates Statements array with RawValues to pass to compile for checking the mistakes
        //no mistake checking is done here
        setChosenFile(chosenFile);
        setConsoleTextArea(consoleTextArea);
        setWestPanel(westPanel);

        statements = new Statements[getChosenFile().getNumberOfLines()];

        String lineText = "";
        int lineNumber = 1;         //lineNumber is number of whole lines including empty ones
        int emptyLineNumber = 0;
//        System.out.println(getChosenFile().getFilePath());
        try {                       //read file line by line and analyse each line
            try {

//            StringBuffer stringBuffer = new StringBuffer();
                bufferedReader = new BufferedReader(new FileReader(getChosenFile().getFilePath()));
                while ((lineText = bufferedReader.readLine()) != null) {
                    if (!lineText.trim().isEmpty()) {

                        analyzeStatements(lineText, lineNumber, emptyLineNumber);
//                fileText += lineText + "\n";

//                stringBuffer.append(lineText + "\n");
                    } else {
                        emptyLineNumber++;
                    }
                    lineNumber++;
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
//                if (bufferedReader != null)
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Compiler compiler = new Compiler(getStatements(), getConsoleTextArea());
//        for (Statements item : statements) {
//            System.out.println(item.getClass().getSimpleName());
//        }
        new Compiler(getStatements(), getConsoleTextArea(), getWestPanel());


    }

    public WestPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(WestPanel westPanel) {
        this.westPanel = westPanel;
    }

    public Statements[] getStatements() {
        return statements;
    }

    public void setStatements(Statements[] statements) {
        this.statements = statements;
    }

    public JTextArea getConsoleTextArea() {
        return consoleTextArea;
    }

    public void setConsoleTextArea(JTextArea consoleTextArea) {
        this.consoleTextArea = consoleTextArea;
    }

    public ChosenFile getChosenFile() {
        return chosenFile;
    }

    public void setChosenFile(ChosenFile chosenFile) {
        this.chosenFile = chosenFile;
    }

    public void analyzeStatements(String lineStatement, int lineNumber, int emptyLineNumber) {
        String[] arguments;
        int firstPlaceOfParenthese = lineStatement.indexOf("(");
        int satementIndex = lineNumber - emptyLineNumber - 1;

//        try {
        if (firstPlaceOfParenthese == -1) {                 //no parentheses exist so it may be UP or DOWN or wrong


            if (lineStatement.equals("UP")) {
                statements[satementIndex] = new Up(lineStatement, lineNumber, satementIndex);

            } else if (lineStatement.equals("DOWN")) {
                statements[satementIndex] = new Down(lineStatement, lineNumber, satementIndex);

            } else {
//                    throw new UnidentifiedStatementException(lineNumber, lineStatement);
                statements[satementIndex] = new UnknownStatement(lineStatement, lineNumber, satementIndex);
            }

        } else {
            String statement = lineStatement.substring(0, firstPlaceOfParenthese);

            int secondPlaceOfParanthese = lineStatement.lastIndexOf(")");       //finding the last index of )
//            if (secondPlaceOfParanthese == -1) {
//                    throw new UnFinishedStatementException(lineNumber, statement);
//
//                statements[lineNumber - emptyLineNumber - 1] = new UnknownStatement(lineNumber);
            if (!lineStatement.trim().endsWith(")")) {                  //no ) at the end exist => the ( is not closed
                closedParenthese = false;
                arguments = lineStatement.substring(firstPlaceOfParenthese + 1).split(",");

            } else {                                                    // the ( is closed
                closedParenthese = true;
                arguments = lineStatement.substring(firstPlaceOfParenthese + 1, secondPlaceOfParanthese).split(",");
            }
            switch (statement) {
                case "MOVE":
                    statements[satementIndex] = new Move(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);
//                        if(arguments.length!=moveArguements){
//                            throw new UnProperArguementsException();
//                        }
                    break;
                case "COLOR":
                    statements[satementIndex] = new PenColor(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);

                    break;
                case "SIZE":
                    statements[satementIndex] = new Size(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);

                    break;
                case "STYLE":
                    statements[satementIndex] = new Style(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);

                    break;
                case "FOR":
                    statements[satementIndex] = new For(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);

                    break;
                case "SET":
                    statements[satementIndex] = new Set(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);

                    break;
                case "INC":
                    statements[satementIndex] = new Inc(arguments, lineNumber, closedParenthese, lineStatement, satementIndex);

                    break;
                default:
//                        throw new UnidentifiedStatementException(lineNumber, statement);
                    statements[satementIndex] = new UnknownStatement(lineStatement, lineNumber, satementIndex);

            }
        }

    }

}


