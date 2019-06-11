package ir.fum.logic.Exceptions;

public class UnidentifiedArgumentException extends Exception {

    private int lineNumber;
    private String wrongStatement;
    private int argumentNumber;

    public UnidentifiedArgumentException(int lineNumber, String wrongStatement, int argumentNumber) {
        setLineNumber(lineNumber);
        setWrongStatement(wrongStatement);
        setArgumentNumber(argumentNumber);
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


    public int getArgumentNumber() {
        return argumentNumber;
    }

    public void setArgumentNumber(int argumentNumber) {
        this.argumentNumber = argumentNumber;
    }


    @Override
    public String toString() {
//        return "Statement at line "+this.getLineNumber()+" "+ this.getWrongStatement();
        switch (getArgumentNumber()) {
            case 1:
                return "First argument is not declared in statement: "+ wrongStatement + " at line: " + lineNumber ;

            case 2:
                return "Second argument is not declared in statement: "+ wrongStatement + " at line: " + lineNumber ;

                default: return "It's not possible :/";

        }

    }
}
