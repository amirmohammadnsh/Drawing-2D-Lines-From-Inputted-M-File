package ir.fum.logic.Statements;

public class Move extends Statements implements ArgumentsOfStatements {
    private final int moveArguments = 2;
    private String rawX;
    private String rawY;
    private int x;
    private int y;

//    public Move(int x, int y) {
//        setX(x);
//        setY(y);
//
//    }

    public Move(String[] arguments, int lineNumber ,boolean closedParenthese,String lineText) {
        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments,closedParenthese);
        setLineText(lineText);


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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements,boolean closedParenthese) {

        if (argumentsOfStatements.length == moveArguments && closedParenthese) {
            setRawX(argumentsOfStatements[0]);
            setRawY(argumentsOfStatements[1]);
        } else {

            setRawX(null);
            setRawY(null);


        }


    }

}
