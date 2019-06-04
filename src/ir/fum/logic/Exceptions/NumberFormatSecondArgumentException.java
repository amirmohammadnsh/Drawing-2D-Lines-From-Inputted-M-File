package ir.fum.logic.Exceptions;

public class NumberFormatSecondArgumentException extends NumberFormatException {
    private int lineNumber;
    private String wrongStatement;

    public NumberFormatSecondArgumentException(int lineNumber, String wrongStatement) {
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
        return "Second argument is not a suitable input in statement: " + wrongStatement + " at line: " + lineNumber;
    }


}
