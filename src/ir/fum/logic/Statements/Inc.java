package ir.fum.logic.Statements;

public class Inc extends Statements implements ArgumentsOfStatements {

    //    private static final int incArguments = 2;
    private int incArguments = Argument.INC.getArgumentCount(Argument.INC);
    private String rawNameOfVariable;


    private String rawValue;
    private String nameOfVariable;
    private int value;

    public Inc(String[] arguments, int lineNumber, boolean closedParenthese, String lineText) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
    }

    public String getRawNameOfVariable() {
        return rawNameOfVariable;
    }

    public void setRawNameOfVariable(String rawNameOfVariable) {
        this.rawNameOfVariable = rawNameOfVariable;
    }

    public String getRawValue() {
        return rawValue;
    }

    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    public String getNameOfVariable() {
        return nameOfVariable;
    }

    public void setNameOfVariable(String nameOfVariable) {
        this.nameOfVariable = nameOfVariable;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements, boolean closedParenthese) {
        if (argumentsOfStatements.length == incArguments && closedParenthese) {
            setRawNameOfVariable(argumentsOfStatements[0]);
            setRawValue(argumentsOfStatements[1]);
        } else {
            setRawNameOfVariable(null);
            setRawValue(null);
        }
    }
}
