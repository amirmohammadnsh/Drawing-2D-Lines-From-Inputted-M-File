package ir.fum.logic.Statements;

import ir.fum.logic.Exceptions.*;

public class PenColor extends Statements implements ArgumentsOfStatements {

    private int penColorTime = ProcessingTime.PENCOLORTIME.getProcessingTime(ProcessingTime.PENCOLORTIME);
    //    private static final int penColorArguements = 3;
    private int penColorArguements = Argument.PENCOLOR.getArgumentCount(Argument.PENCOLOR);
    private String rawR;
    private String rawG;
    private String rawB;
    private int r;
    private int g;
    private int b;
    public PenColor(String[] arguments, int lineNumber, boolean closedParenthese, String lineText, int statementIndex) {

        setLineNumber(lineNumber);
        setArgumentsOfStatements(arguments, closedParenthese);
        setLineText(lineText);
        setClosedParanthese(closedParenthese);
        setStatementIndex(statementIndex);

    }

    public int getPenColorTime() {
        return penColorTime;
    }

    public void parseRawR() throws OutOfBoundsFirstArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawR);
            setR(temp);
        } catch (NumberFormatException ex) {
            throw new NumberFormatFirstArgumentException(getLineNumber(), getLineText());
        }
    }

    public void parseRawG() throws OutOfBoundsSecondArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawG);
            setG(temp);
        } catch (NumberFormatException ex) {
            throw new NumberFormatSecondArgumentException(getLineNumber(), getLineText());
        }


    }

    public void parseRawB() throws OutOfBoundsThirdArgumrntException {
        try {
            int temp = Integer.parseInt(this.rawB);
            setB(temp);
        } catch (NumberFormatException ex) {
            throw new NumberFormatThirdArgumentException(getLineNumber(), getLineText());
        }
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

    public void setR(int r) throws OutOfBoundsFirstArgumrntException {
        if (r > 255 || r < 0) {
            throw new OutOfBoundsFirstArgumrntException(getLineNumber(), getLineText());
        } else {
            this.r = r;
        }
    }


    public int getG() {
        return g;
    }

    public void setG(int g) throws OutOfBoundsSecondArgumrntException {
        if (g > 255 || g < 0) {
            throw new OutOfBoundsSecondArgumrntException(getLineNumber(), getLineText());
        } else {
            this.g = g;
        }
    }

    public int getB() {
        return b;
    }

    public void setB(int b) throws OutOfBoundsThirdArgumrntException {
        if (b > 255 || b < 0) {
            throw new OutOfBoundsThirdArgumrntException(getLineNumber(), getLineText());
        } else {
            this.b = b;
        }
    }

    @Override
    public void setArgumentsOfStatements(String[] argumentsOfStatements, boolean closedParenthese) {

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
