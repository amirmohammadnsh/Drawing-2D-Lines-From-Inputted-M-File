package ir.fum.logic.Statements;

public class Up extends Statements {

    public Up(String lineStatement , int lineNumber,int statementIndex) {
        setLineNumber(lineNumber);
        setLineText(lineStatement);
        setStatementIndex(statementIndex);

    }

}
