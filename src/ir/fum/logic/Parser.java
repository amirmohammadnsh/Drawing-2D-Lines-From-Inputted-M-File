package ir.fum.logic;

import ir.fum.logic.Statements.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    //check where to call this class , Should contain ChosenFile class .Done !
    private ChosenFile chosenFile;
    private Statements[] statements;
    private boolean closedParenthese = true;


    public Parser(ChosenFile chosenFile) {
        setChosenFile(chosenFile);
        statements = new Statements[getChosenFile().getNumberOfLines()];

        String lineText = "";
        int lineNumber = 1;
        int emptyLineNumber = 0;
//        System.out.println(getChosenFile().getFilePath());
        try {

            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getChosenFile().getFilePath()));
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

            bufferedReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                statements[lineNumber - emptyLineNumber - 1] = new Up(lineNumber);

            } else if (lineStatement.equals("DOWN")) {
                statements[lineNumber - emptyLineNumber - 1] = new Down(lineNumber);

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


                    statements[lineNumber - emptyLineNumber - 1] = new Move(arguments, lineNumber, closedParenthese,lineStatement);
//                        if(arguments.length!=moveArguements){
//                            throw new NotEnoughArguementsException();
//                        }

                    break;
                case "COLOR":
                    statements[lineNumber - emptyLineNumber - 1] = new PenColor(arguments, lineNumber, closedParenthese,lineStatement);

                    break;
                case "SIZE":
                    statements[lineNumber - emptyLineNumber - 1] = new Size(arguments, lineNumber, closedParenthese,lineStatement);

                    break;
                case "STYLE":
                    statements[lineNumber - emptyLineNumber - 1] = new Style(arguments, lineNumber, closedParenthese,lineStatement);

                    break;
                case "FOR":
                    statements[lineNumber - emptyLineNumber - 1] = new For(arguments, lineNumber, closedParenthese,lineStatement);

                    break;
                case "SET":
                    statements[lineNumber - emptyLineNumber - 1] = new Set(arguments, lineNumber, closedParenthese,lineStatement);

                    break;
                case "INC":
                    statements[lineNumber - emptyLineNumber - 1] = new Inc(arguments, lineNumber, closedParenthese,lineStatement);

                    break;
                default:
//                        throw new UnidentifiedStatementException(lineNumber, statement);
                    statements[lineNumber - emptyLineNumber - 1] = new UnknownStatement(lineStatement, lineNumber);

            }
        }
//        System.out.println(statements[lineNumber]);
    }

}


