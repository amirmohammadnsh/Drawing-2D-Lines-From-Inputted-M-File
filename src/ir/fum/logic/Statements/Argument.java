package ir.fum.logic.Statements;

public enum Argument {

    MOVE(2), FOR(2), INC(2),
    PENCOLOR(3), SET(2),
    SIZE(1), STYLE(1);

    private int argumentCount;

    Argument(int argumentsCount) {

        this.argumentCount = argumentsCount;
    }

    public int getArgumentCount(Argument argument) {

        return this.argumentCount;
    }

}
