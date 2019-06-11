package ir.fum.logic.Exceptions;

public class VariableException extends  Exception {
    private int lineNumber;
    private int argumentNumber;

    public VariableException(int lineNumber, int argumentNumber) {
        setLineNumber(lineNumber);
        setArgumentNumber(argumentNumber);
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getArgumentNumber() {
        return argumentNumber;
    }

    public void setArgumentNumber(int argumentNumber) {
        this.argumentNumber = argumentNumber;
    }

    //    @Override
//    public String toString() {
////        return "Statement at line "+this.getLineNumber()+" "+ this.getWrongStatement();
//        return "Expecting a non-Digit Character at the beginning of statement:\n\t " + wrongStatement + " at line: " + lineNumber;
//    }


}
