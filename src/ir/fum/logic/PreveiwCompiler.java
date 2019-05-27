package ir.fum.logic;

import ir.fum.logic.Exceptions.NotEnoughArguementsException;
import ir.fum.logic.Exceptions.UnFinishedStatementException;
import ir.fum.logic.Exceptions.UnidentifiedStatementException;
import ir.fum.logic.Statements.Down;
import ir.fum.logic.Statements.Statements;
import ir.fum.logic.Statements.Up;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PreveiwCompiler {
    private ChosenFile chosenFile;
    private Statements[] statements;
    private final int moveArguements = 2 ;
    private final int colorArguements = 3 ;
    private final int sizeArguements = 1 ;
    private final int styleArguements = 1 ;
    private final int forArguements = 2 ;
    private final int setArguements = 2 ;
    private final int incArguements = 2 ;





    public PreveiwCompiler(ChosenFile chosenFile) {
        setChosenFile(chosenFile);
        statements = new Statements[getChosenFile().getNumberOfLines()];

        String lineText = "";
        int lineNumber = 1;
        int emptyLineNumber = 0;
        System.out.println(getChosenFile().getFilePath());
        try {

//            StringBuffer stringBuffer = new StringBuffer();
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

        int firstPlaceOfParenthese = lineStatement.indexOf("(");

        try {
            if (firstPlaceOfParenthese == -1) {     //no parentheses exist


                if (lineStatement.equals("UP")) {
//                    statements[lineNumber - emptyLineNumber - 1] = new Up(lineNumber);

                } else if (lineStatement.equals("DOWN")) {
//                    statements[lineNumber - emptyLineNumber - 1] = new Down(lineNumber);

                } else {
                    throw new UnidentifiedStatementException(lineNumber, lineStatement);
                }

            } else {
                String statement = lineStatement.substring(0, firstPlaceOfParenthese);

                int secondPlaceOfParanthese = lineStatement.indexOf(")");
                if (secondPlaceOfParanthese == -1) {
                    throw new UnFinishedStatementException(lineNumber, statement);
                }

                String values[] = lineStatement.substring(firstPlaceOfParenthese + 1, secondPlaceOfParanthese).split(",");

                switch (statement) {
                    case "MOVE":
                        if(values.length!=moveArguements){
                            throw new NotEnoughArguementsException();
                        }

                        break;
                    case "COLOR":

                        break;
                    case "SIZE":
                        break;
                    case "STYLE":
                        break;
                    case "FOR":
                        break;
                    case "SET":

                        break;
                    case "INC":
                        break;
                    default:
                        throw new UnidentifiedStatementException(lineNumber, statement);

                }
            }
        }catch (NotEnoughArguementsException ex){
            // should be passed to the console of CompilePanel
//            System.out.println(ex.getWrongStatement() + " at line " + ex.getLineNumber() + " arguements is not enough !");
        }

        catch ( UnFinishedStatementException ex) {
            // should be passed to the console of CompilePanel
            System.out.println(ex.getWrongStatement() + " at line " + ex.getLineNumber() + " is unfinished !");

        } catch (UnidentifiedStatementException ex) {
            // should be passed to the console of CompilePanel
            System.out.println(ex.getWrongStatement() + " at line " + ex.getLineNumber() + " is invalid !");
        }


    }



}
