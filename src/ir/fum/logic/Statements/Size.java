package ir.fum.logic.Statements;

public class Size extends Statements implements ArgumentsOfStatements {

    private final int penSizeArguements = 1;
    private String rawPenSize;
    private int penSize;

    public Size(String[] arguments, int lineNumber, boolean closedParenthese,String lineText) {

        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments,closedParenthese);
        setLineText(lineText);
    }

    public String getRawPenSize() {
        return rawPenSize;
    }

    public void setRawPenSize(String rawPenSize) {
        this.rawPenSize = rawPenSize;
    }

    public int getPenSize() {
        return penSize;
    }

    public void setPenSize(int penSize) {
        this.penSize = penSize;
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements, boolean closedParenthese) {
        if (argumentsOfStatements.length == penSizeArguements && closedParenthese) {
            setRawPenSize(argumentsOfStatements[0]);
        } else {

            setRawPenSize(null);


        }


    }
}
