package ir.fum.gui;

import ir.fum.logic.ChosenFile;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;


public class FileChooser extends JFileChooser {

    private TextPanel textPanel;
    private JTextField fileName;
    private ChosenFile chosenFile;

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

        FileSystemView.getFileSystemView().getHomeDirectory();
        int selectedMode = showOpenDialog(this);

        if (selectedMode == APPROVE_OPTION) {

                File selectedFile = this.getSelectedFile();
                String selectedFilePath = selectedFile.getPath();
                 chosenFile = new ChosenFile(selectedFilePath,this);



            }

        }


    }



