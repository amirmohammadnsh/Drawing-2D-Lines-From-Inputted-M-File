package ir.fum.logic.Statements;

public abstract class Statements {
    private int lineNumber;
    private String lineText;
    private boolean closedParanthese;

    public boolean isClosedParanthese() {
        return closedParanthese;
    }

    public void setClosedParanthese(boolean closedParanthese) {
        this.closedParanthese = closedParanthese;
    }

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;

    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void identifyNumberOfParentheses() {

    }
}
