package ir.fum.logic.Statements;

public class Up extends Statements {
    private int upTime = ProcessingTime.UPTIME.getProcessingTime(ProcessingTime.UPTIME);

    public Up(String lineStatement, int lineNumber, int statementIndex) {
        setLineNumber(lineNumber);
        setLineText(lineStatement);
        setStatementIndex(statementIndex);

    }

    public int getUpTime() {
        return upTime;
    }

}
