package ir.fum.logic.Exceptions;

public class OutOfBoundsSecondArgumrntException extends Exception {
    private int lineNumber;
    private String wrongStatement;

    public OutOfBoundsSecondArgumrntException(int lineNumber, String wrongStatement){
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
        return "Second argument is out of bounds in statement: "+ wrongStatement + " at line: " + lineNumber ;
    }

}
