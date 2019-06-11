package ir.fum.logic.Exceptions;

public class UnidentifiedStatementException extends Exception {

    private int lineNumber;
    private String wrongStatement;

    public UnidentifiedStatementException(int lineNumber, String wrongStatement) {
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
        return "Unidentified statement in statement: " + wrongStatement + " at line: " + lineNumber;
    }


}
