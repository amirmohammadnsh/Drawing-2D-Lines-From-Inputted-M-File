package ir.fum.logic.Statements;

public enum ProcessingTime {

    INCTIME(10),DOWNTIME(200),UPTIME(200),
    PENCOLORTIME(500), SETTIME(10),
    SIZETIME(200), STYLETIME(500);

    private int processingTime;

    ProcessingTime(int processingTime) {

        this.processingTime = processingTime;
    }

    public int getProcessingTime(ProcessingTime processingTime) {

        return this.processingTime;
    }

}
