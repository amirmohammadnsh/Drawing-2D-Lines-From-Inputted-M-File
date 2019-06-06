package ir.fum.logic.Statements;

import ir.fum.logic.Exceptions.NumberFormatFirstArgumentException;
import ir.fum.logic.Exceptions.OutOfBoundsFirstArgumrntException;

public class Size extends Statements implements ArgumentsOfStatements {

    //    private static final int penSizeArguements = 1;
    private int penSizeArguements = Argument.SIZE.getArgumentCount(Argument.SIZE);

    private String rawPenSize;
    private int penSize = 1;


    public Size(String[] arguments, int lineNumber, boolean closedParenthese, String lineText) {

        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
    }

    public void parseRawPenSize() throws OutOfBoundsFirstArgumrntException{
        try {
            int temp = Integer.parseInt(this.rawPenSize);
            setPenSize(temp);
        } catch (NumberFormatException ex) {
            throw new NumberFormatFirstArgumentException(getLineNumber(), getLineText());
        }
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

    public void setPenSize(int penSize) throws OutOfBoundsFirstArgumrntException {
        if(penSize>5 || penSize<1){
            throw new OutOfBoundsFirstArgumrntException(getLineNumber(), getLineText());
        } else {
            this.penSize = penSize;
        }

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
