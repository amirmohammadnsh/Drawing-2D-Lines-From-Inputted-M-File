package ir.fum.logic.Statements;

public class Style extends Statements implements ArgumentsOfStatements {
    //    private static final int styleArguments = 1;
    private int styleArguments = Argument.STYLE.getArgumentCount(Argument.STYLE);
    private String rawStyleType;

    private StyleType styleType;

    public Style(String[] arguments, int lineNumber, boolean closedParenthese, String lineText) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
    }

    public String getRawStyleType() {
        return rawStyleType;
    }

    public void setRawStyleType(String rawStyleType) {
        this.rawStyleType = rawStyleType;
    }

    public StyleType getStyleType() {
        return styleType;
    }

    public void setStyleType(StyleType styleType) {
        this.styleType = styleType;
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements, boolean closedParenthese) {
        if (argumentsOfStatements.length == styleArguments && closedParenthese) {
            setRawStyleType(argumentsOfStatements[0]);
        } else {

            setRawStyleType(null);

        }
    }
}
