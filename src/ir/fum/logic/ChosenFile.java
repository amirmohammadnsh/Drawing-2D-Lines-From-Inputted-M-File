package ir.fum.logic;

import ir.fum.gui.FileChooser;
import ir.fum.logic.Exceptions.FileTypeException;

import java.io.*;

public class ChosenFile {
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;
    private FileChooser fileChooser;
    private String error;

    public ChosenFile(String pathName, FileChooser fileChooser) {
        String lineText = "";
        String fileText = "";
        setFileChooser(fileChooser);
        getFileChooser().getEditAndSavePanel().setChosenFile(this);

        try {
            setMFile(pathName);
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((lineText = bufferedReader.readLine()) != null) {


//                fileText += lineText + "\n";

                stringBuffer.append(lineText +"\n");
            }
            getFileChooser().getTextPanel().getTextContent().setText(stringBuffer.toString());
//            System.out.println(getFileChooser().getTextPanel().getTextContent().getText());
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


    public void saveFile(){
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())));
            System.out.println(getFileChooser().getTextPanel().getTextContent().getText());
            printWriter.println(getFileChooser().getTextPanel().getTextContent().getText());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(printWriter != null){
                printWriter.close();
            }
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
