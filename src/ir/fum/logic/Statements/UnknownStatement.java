package ir.fum.logic.Statements;

public class UnknownStatement extends Statements {


    public UnknownStatement(String lineText, int lineNumber,int statementIndex) {
        setLineNumber(lineNumber);
        setLineText(lineText);
        setStatementIndex(statementIndex);
    }




}
