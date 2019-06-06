package ir.fum.logic;

import ir.fum.gui.FileChooser;
import ir.fum.logic.Exceptions.FileTypeException;

import java.io.*;

public class ChosenFile {
    private String filePath;
    private FileChooser fileChooser;
    private String error;
    private int numberOfLines;
    private int numberOfEmptyLines;
    private BufferedReader bufferedReader;

    public ChosenFile(String pathName, FileChooser fileChooser) {
        String lineText = "";
        String fileText = "";
//        BufferedReader bufferedReader;
        setFileChooser(fileChooser);
        getFileChooser().getEditAndSavePanel().setChosenFile(this);
        try {
            try {
                setMFile(pathName);
                StringBuffer stringBuffer = new StringBuffer();
                bufferedReader = new BufferedReader(new FileReader(filePath));

                while ((lineText = bufferedReader.readLine()) != null) {
                    if (!lineText.trim().isEmpty()) {
//                fileText += lineText + "\n";
                        stringBuffer.append(lineText + "\n");
                        numberOfLines++;
                    }
                }
                getFileChooser().getTextPanel().getTextContent().setText(stringBuffer.toString());
//            System.out.println(getFileChooser().getTextPanel().getTextContent().getText());
                getFileChooser().getFileName().setText(filePath);


                getFileChooser().setApprovedSwitch(true);
                bufferedReader.close();

            } catch (FileTypeException e) {
                error = e.getError();
                getFileChooser().setApprovedSwitch(false);
                getFileChooser().setError(error);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                //TODO
                //print it in another terminal

            }
//            finally {
//                bufferedReader.close();
//            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO
            //print it in another terminal

        }

    }

    public int getNumberOfEmptyLines() {
        return numberOfEmptyLines;
    }

    public void setNumberOfEmptyLines(int numberOfEmptyLines) {
        this.numberOfEmptyLines = numberOfEmptyLines;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void saveFile() {
        PrintWriter printWriter = null;
        String lineText = "";
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())));
//            System.out.println(getFileChooser().getTextPanel().getTextContent().getText());
            printWriter.println(getFileChooser().getTextPanel().getTextContent().getText());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        setNumberOfLines(0);
        try {


            try {

//            StringBuffer stringBuffer = new StringBuffer();
                bufferedReader = new BufferedReader(new FileReader(this.getFilePath()));
                while ((lineText = bufferedReader.readLine()) != null) {
                    if (!lineText.trim().isEmpty()) {
                        numberOfLines++;
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                bufferedReader.close();
            }
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
