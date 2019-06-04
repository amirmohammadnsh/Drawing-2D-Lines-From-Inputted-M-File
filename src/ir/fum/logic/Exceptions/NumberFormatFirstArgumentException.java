package ir.fum.logic.Exceptions;

public class NumberFormatFirstArgumentException extends NumberFormatException {

    private int lineNumber;
    private String wrongStatement;

    public NumberFormatFirstArgumentException(int lineNumber, String wrongStatement) {
        setLineNumber(lineNumber);
        setWrongStatement(wrongStatement);
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getWrongStatement() {
        return wrongStatement;
    }

    public void setWrongStatement(String wrongStatement) {
        this.wrongStatement = wrongStatement;
    }

    @Override
    public String toString() {
//        return "Statement at line "+this.getLineNumber()+" "+ this.getWrongStatement();
        return "First argument is not a suitable input in statement: " + wrongStatement + " at line: " + lineNumber ;
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }
}
