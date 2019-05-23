package ir.fum.logic.Statements;

public abstract class Statements {
    private int lineNumber;

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    private String lineText ;

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
    public void identifyNumberOfParentheses(){

    }
}
