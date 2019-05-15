package ir.fum.logic;

import ir.fum.gui.FileChooser;
import ir.fum.logic.Exceptions.FileTypeException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ChosenFile {
    private String filePath;
    private FileChooser fileChooser;
    private String error;

    public ChosenFile(String pathname, FileChooser fileChooser) {
        String lineText = "";
        String fileText = "";
        setFileChooser(fileChooser);


        try {
            setMFile(pathname);
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((lineText = bufferedReader.readLine()) != null) {


//                fileText += lineText + "\n";

                stringBuffer.append("  " + lineText + "\n");
            }
            getFileChooser().getTextPanel().getTextContent().setText(stringBuffer.toString());
            getFileChooser().getFileName().setText(filePath);
            bufferedReader.close();

            getFileChooser().setApprovedSwitch(true);


        } catch (FileTypeException e) {
            error = e.getError();
            getFileChooser().setApprovedSwitch(false);
            getFileChooser().setError(error);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFileChooser(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public void setMFile(String filePath) throws FileTypeException {
        if (filePath.endsWith(".m")) {
            this.filePath = filePath;

        } else {
            throw new FileTypeException(filePath);
        }

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
