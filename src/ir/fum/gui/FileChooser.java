package ir.fum.gui;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;


public class FileChooser extends JFileChooser {

    private TextPanel textPanel;
    private JTextField fileName;

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public JTextField getFileName() {
        return fileName;
    }

    public void setFileName(JTextField fileName) {
        this.fileName = fileName;
    }

    public FileChooser(TextPanel textPanel, JTextField fileName) {
        setTextPanel(textPanel);
        setFileName(fileName);
        String lineText = "";
        String fileText = "";
        FileSystemView.getFileSystemView().getHomeDirectory();
        int selectedMode = showOpenDialog(this);

        if (selectedMode == this.APPROVE_OPTION) {
            try {
                File selectedFile = this.getSelectedFile();
                String selectedFilePath = selectedFile.getPath();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFilePath));
                    while ((lineText = bufferedReader.readLine()) != null) {
//                    fileText.concat(lineText.concat("\n"));

                        fileText += lineText + "\n";
                    }
                    getTextPanel().getTextContent().setText(fileText);
                    getFileName().setText(selectedFilePath);
                    bufferedReader.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch (Exception m){

            }

        }


    }


}
