package ir.fum.logic.Statements;

import ir.fum.logic.Exceptions.NotSupportedStyleTypeException;

public class Style extends Statements implements ArgumentsOfStatements {
    //    private static final int styleArguments = 1;
    private int styleArguments = Argument.STYLE.getArgumentCount(Argument.STYLE);
    private String rawStyleType;
    private StyleType styleType = StyleType.DOTTED;

    public Style(String[] arguments, int lineNumber, boolean closedParenthese, String lineText) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
    }

    public void parseRawStyleType() throws NotSupportedStyleTypeException {

        switch (getRawStyleType()) {

            case "SOLID":
                setStyleType(StyleType.SOLID);

                break;
            case "DASHED":
                setStyleType(StyleType.DASHED);
                break;
            case "DOTTED":
                setStyleType(StyleType.DOTTED);
                break;

            default:
                throw new NotSupportedStyleTypeException(getLineNumber(), getLineText());

        }


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
