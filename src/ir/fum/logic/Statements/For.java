package ir.fum.logic.Statements;

public class For extends Statements implements ArgumentsOfStatements {

    private static final int forArguments = 2;
    private String rawNumberOfNextStatements;
    private String rawNumberOfRepetition;
    private int numberOfNextStatements;
    private int numberOfRepetition;

    public For(String[] arguments, int lineNumber, boolean closedParenthese, String lineText) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
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

    public void setNumberOfNextStatements(int numberOfNextStatements) {
        this.numberOfNextStatements = numberOfNextStatements;
    }

    public int getNumberOfRepetition() {
        return numberOfRepetition;
    }

    public void setNumberOfRepetition(int numberOfRepetition) {
        this.numberOfRepetition = numberOfRepetition;
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
