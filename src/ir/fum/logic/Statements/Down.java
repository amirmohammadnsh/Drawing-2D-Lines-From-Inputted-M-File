package ir.fum.logic.Statements;

public class Down extends Statements {
    private int downTime = ProcessingTime.DOWNTIME.getProcessingTime(ProcessingTime.DOWNTIME);

    public Down(String lineStatement, int lineNumber, int statementIndex) {
        setLineNumber(lineNumber);
        setLineText(lineStatement);
        setStatementIndex(statementIndex);

    }

    public int getDownTime() {
        return downTime;
    }
}


