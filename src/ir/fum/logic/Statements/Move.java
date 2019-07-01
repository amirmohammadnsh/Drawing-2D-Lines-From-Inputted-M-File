package ir.fum.logic.Statements;

import ir.fum.logic.Exceptions.OutOfBoundsFirstArgumrntException;
import ir.fum.logic.Exceptions.OutOfBoundsSecondArgumrntException;
import ir.fum.logic.Exceptions.VariableException;

public class Move extends Statements implements ArgumentsOfStatements {
//    private static final int moveArguments = 2;

    private int moveArguments = Argument.MOVE.getArgumentCount(Argument.MOVE);

    private String rawX;
    private String rawY;
    private int x;
    private int y;
    private double moveTime;

    public Move(String[] arguments, int lineNumber, boolean closedParenthese, String lineText, int statementIndex) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
        setStatementIndex(statementIndex);

    }

    public double getMoveTime() {
        return moveTime;
    }
    //    public Move(int x, int y) {
//        setX(x);
//        setY(y);
//
//    }

    public void setMoveTime(double moveTime) {
        this.moveTime = moveTime;
    }

    public String getRawX() {
        return rawX;
    }

    public void setRawX(String rawX) {
        this.rawX = rawX;
    }

    public String getRawY() {
        return rawY;
    }

    public void setRawY(String rawY) {
        this.rawY = rawY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws OutOfBoundsFirstArgumrntException {
        if (x >= -5 && x < 1500) {
            this.x = x;
        } else {
            throw new OutOfBoundsFirstArgumrntException(getLineNumber(), getLineText());
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws OutOfBoundsSecondArgumrntException {
        if (y >= -5 && y < 1500) {
            this.y = y;
        } else {
            throw new OutOfBoundsSecondArgumrntException(getLineNumber(), getLineText());
        }

    }

    public void parseRawX() throws VariableException, OutOfBoundsFirstArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawX);
            setX(temp);
        } catch (NumberFormatException ex) {
            throw new VariableException(getLineNumber(), 1);
        }
    }

    public void parseRawY() throws VariableException, OutOfBoundsSecondArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawY);
            setY(temp);
        } catch (NumberFormatException ex) {
            throw new VariableException(getLineNumber(), 2);
        }
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements, boolean closedParenthese) {

        if (argumentsOfStatements.length == moveArguments && closedParenthese) {
            setRawX(argumentsOfStatements[0]);
            setRawY(argumentsOfStatements[1]);
        } else {

            setRawX(null);
            setRawY(null);


        }


    }

}
