package ir.fum.logic;

import ir.fum.logic.Statements.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    //check where to call this class , Should contain ChosenFile class .Done !
    private ChosenFile chosenFile;
    private Statements[] statements;
    private boolean closedParenthese = true;
    private JTextArea consoleTextArea;
    private BufferedReader bufferedReader;

    public Parser(ChosenFile chosenFile, JTextArea consoleTextArea) {
        setChosenFile(chosenFile);
        setConsoleTextArea(consoleTextArea);
        statements = new Statements[getChosenFile().getNumberOfLines()];

        String lineText = "";
        int lineNumber = 1;
        int emptyLineNumber = 0;
//        System.out.println(getChosenFile().getFilePath());
        try {


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
                bufferedReader.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
//        Compiler compiler = new Compiler(getStatements(), getConsoleTextArea());
        new Compiler(getStatements(), getConsoleTextArea());


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

//        try {
        if (firstPlaceOfParenthese == -1) {     //no parentheses exist


            if (lineStatement.equals("UP")) {
                statements[lineNumber - emptyLineNumber - 1] = new Up(lineStatement, lineNumber);

            } else if (lineStatement.equals("DOWN")) {
                statements[lineNumber - emptyLineNumber - 1] = new Down(lineStatement, lineNumber);

            } else {
//                    throw new UnidentifiedStatementException(lineNumber, lineStatement);
                statements[lineNumber - emptyLineNumber - 1] = new UnknownStatement(lineStatement, lineNumber);
            }

        } else {
            String statement = lineStatement.substring(0, firstPlaceOfParenthese);

            int secondPlaceOfParanthese = lineStatement.lastIndexOf(")");
            if (secondPlaceOfParanthese == -1) {
//                    throw new UnFinishedStatementException(lineNumber, statement);
//                statements[lineNumber - emptyLineNumber - 1] = new UnknownStatement(lineNumber);
                closedParenthese = false;
                arguments = lineStatement.substring(firstPlaceOfParenthese + 1).split(",");

            } else {

                arguments = lineStatement.substring(firstPlaceOfParenthese + 1, secondPlaceOfParanthese).split(",");
            }
            switch (statement) {
                case "MOVE":


                    statements[lineNumber - emptyLineNumber - 1] = new Move(arguments, lineNumber, closedParenthese, lineStatement);
//                        if(arguments.length!=moveArguements){
//                            throw new NotEnoughArguementsException();
//                        }

                    break;
                case "COLOR":
                    statements[lineNumber - emptyLineNumber - 1] = new PenColor(arguments, lineNumber, closedParenthese, lineStatement);

                    break;
                case "SIZE":
                    statements[lineNumber - emptyLineNumber - 1] = new Size(arguments, lineNumber, closedParenthese, lineStatement);

                    break;
                case "STYLE":
                    statements[lineNumber - emptyLineNumber - 1] = new Style(arguments, lineNumber, closedParenthese, lineStatement);

                    break;
                case "FOR":
                    statements[lineNumber - emptyLineNumber - 1] = new For(arguments, lineNumber, closedParenthese, lineStatement);

                    break;
                case "SET":
                    statements[lineNumber - emptyLineNumber - 1] = new Set(arguments, lineNumber, closedParenthese, lineStatement);

                    break;
                case "INC":
                    statements[lineNumber - emptyLineNumber - 1] = new Inc(arguments, lineNumber, closedParenthese, lineStatement);

                    break;
                default:
//                        throw new UnidentifiedStatementException(lineNumber, statement);
                    statements[lineNumber - emptyLineNumber - 1] = new UnknownStatement(lineStatement, lineNumber);

            }
        }

    }

}


