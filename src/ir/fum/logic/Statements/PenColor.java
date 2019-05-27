package ir.fum.logic.Statements;

public class PenColor extends Statements implements ArgumentsOfStatements {
    private static final int penColorArguements = 3;
    private String rawR;
    private String rawG;
    private String rawB;
    private int r;
    private int g;
    private int b;

    public PenColor(String[] arguments, int lineNumber,boolean closedParenthese,String lineText) {

        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments,closedParenthese);
        setLineText(lineText);

    }

    public String getRawR() {
        return rawR;
    }

    public void setRawR(String rawR) {
        this.rawR = rawR;
    }

    public String getRawG() {
        return rawG;
    }

    public void setRawG(String rawG) {
        this.rawG = rawG;
    }

    public String getRawB() {
        return rawB;
    }


    public void setRawB(String rawB) {
        this.rawB = rawB;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements,boolean closedParenthese) {

        if (argumentsOfStatements.length == penColorArguements && closedParenthese) {
            setRawR(argumentsOfStatements[0]);
            setRawG(argumentsOfStatements[1]);
            setRawB(argumentsOfStatements[2]);
        } else {

            setRawR(null);
            setRawG(null);
            setRawB(null);


        }


    }
}
