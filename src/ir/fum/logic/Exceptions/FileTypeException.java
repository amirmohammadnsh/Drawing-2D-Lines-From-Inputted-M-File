package ir.fum.logic.Exceptions;

public class FileTypeException extends Exception {

private String error ;
    public FileTypeException(String filePath) {
        int lastBackSlash = filePath.lastIndexOf("/");
        String errorFileName = filePath.substring(lastBackSlash);
        setError(errorFileName);



    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
