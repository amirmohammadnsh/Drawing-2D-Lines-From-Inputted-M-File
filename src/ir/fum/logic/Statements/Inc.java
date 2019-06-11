package ir.fum.logic.Statements;

import ir.fum.logic.Exceptions.AlphebaticInputException;
import ir.fum.logic.Exceptions.FloatInputException;
import ir.fum.logic.Exceptions.UnProperBeginningCharacterException;

public class Inc extends Statements implements ArgumentsOfStatements {

    //    private static final int incArguments = 2;
    private int incArguments = Argument.INC.getArgumentCount(Argument.INC);
    private String rawNameOfVariable;
    private String rawValue;
    private String nameOfVariable;
    private int value;

    public Inc(String[] arguments, int lineNumber, boolean closedParenthese, String lineText,int statementIndex) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
        setStatementIndex(statementIndex);
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

    public void parseRawNameOfVariable() throws UnProperBeginningCharacterException {

//        int temp = Integer.parseInt(this.rawNumberOfNextStatements);
////        setNumberOfNextStatements(temp);
        if (!Character.isDigit(getRawNameOfVariable().trim().charAt(0))) {
            setNameOfVariable(getRawNameOfVariable().trim());

        } else {

            throw new UnProperBeginningCharacterException(getLineNumber(), getLineText());

        }


    }

    public void parseRawValue() throws FloatInputException, AlphebaticInputException {
        try {
            int temp = Integer.parseInt(this.rawValue);
            setValue(temp);

        } catch (NumberFormatException ex) {
            try {
                float temp = Float.parseFloat(this.rawValue);
                throw new FloatInputException(getLineNumber(), getLineText());
            } catch (NumberFormatException e) {
                throw new AlphebaticInputException(getLineNumber(), getLineText());
            }
        }

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
