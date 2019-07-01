package ir.fum.logic.Statements;

import ir.fum.logic.Exceptions.NumberFormatFirstArgumentException;
import ir.fum.logic.Exceptions.NumberFormatSecondArgumentException;
import ir.fum.logic.Exceptions.OutOfBoundsFirstArgumrntException;
import ir.fum.logic.Exceptions.OutOfBoundsSecondArgumrntException;

public class For extends Statements implements ArgumentsOfStatements {

    //    private static final int forArguments = 2;
    private int forArguments = Argument.FOR.getArgumentCount(Argument.FOR);
    private String rawNumberOfNextStatements;
    private String rawNumberOfRepetition;
    private int numberOfNextStatements;
    private int numberOfRepetition;
    private double forTime = 0;

    public For(String[] arguments, int lineNumber, boolean closedParenthese, String lineText, int statementIndex) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
        setStatementIndex(statementIndex);
    }

    public double getForTime() {
        return forTime;
    }

    public void setForTime(double forTime) {
        this.forTime = forTime;
    }

    public void parseRawNumberOfNextStatements() throws OutOfBoundsFirstArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawNumberOfNextStatements);
            setNumberOfNextStatements(temp);
        } catch (NumberFormatException ex) {
            throw new NumberFormatFirstArgumentException(getLineNumber(), getLineText());
        }
    }

    public void pareseRawNumberOfRepetition() throws OutOfBoundsSecondArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawNumberOfRepetition);
            setNumberOfRepetition(temp);
        } catch (NumberFormatException ex) {
            throw new NumberFormatSecondArgumentException(getLineNumber(), getLineText());
        }
    }

    public String getRawNumberOfNextStatements() {
        return rawNumberOfNextStatements;
    }

    public void setRawNumberOfNextStatements(String rawNumberOfNextStatements) {
        this.rawNumberOfNextStatements = rawNumberOfNextStatements;
    }

    public String getRawNumberOfRepetition() {
        return rawNumberOfRepetition;
    }

    public void setRawNumberOfRepetition(String rawNumberOfRepetition) {
        this.rawNumberOfRepetition = rawNumberOfRepetition;
    }

    public int getNumberOfNextStatements() {
        return numberOfNextStatements;
    }

    public void setNumberOfNextStatements(int numberOfNextStatements) throws OutOfBoundsFirstArgumrntException {
        if (numberOfNextStatements <= 0) {
            throw new OutOfBoundsFirstArgumrntException(getLineNumber(), getLineText());
        } else {
            this.numberOfNextStatements = numberOfNextStatements;
        }
    }

    public int getNumberOfRepetition() {
        return numberOfRepetition;
    }

    public void setNumberOfRepetition(int numberOfRepetition) throws OutOfBoundsSecondArgumrntException {
        if (numberOfRepetition <= 0) {
            throw new OutOfBoundsSecondArgumrntException(getLineNumber(), getLineText());
        } else {
            this.numberOfRepetition = numberOfRepetition;
        }
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements, boolean closedParenthese) {
        if (argumentsOfStatements.length == forArguments && closedParenthese) {
            setRawNumberOfNextStatements(argumentsOfStatements[0]);
            setRawNumberOfRepetition(argumentsOfStatements[1]);
        } else {

            setRawNumberOfNextStatements(null);
            setRawNumberOfRepetition(null);

        }
    }
}
