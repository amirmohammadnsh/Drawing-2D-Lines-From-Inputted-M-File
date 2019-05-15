package ir.fum.gui;

import ir.fum.logic.ChosenFile;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;


public class FileChooser extends JFileChooser {

    private TextPanel textPanel;
    private JTextField fileName;
    private ChosenFile chosenFile;
    private boolean approvedSwitch;
    private String error;

    public FileChooser(TextPanel textPanel, JTextField fileName) {
        setTextPanel(textPanel);
        setFileName(fileName);

        FileSystemView.getFileSystemView().getHomeDirectory();
        showOpenDialog(this);

    }

    @Override
    public void approveSelection() {
        File selectedFile = this.getSelectedFile();
        String selectedFilePath = selectedFile.getPath();
        chosenFile = new ChosenFile(selectedFilePath, this);

        if (approvedSwitch) {
            super.approveSelection();
        } else {
            JOptionPane.showMessageDialog(null, error + " is not a .M file\n" + "Please Choose Another File");
        }

    }

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

    public boolean isApprovedSwitch() {
        return approvedSwitch;
    }

    public void setApprovedSwitch(boolean approvedSwitch) {
        this.approvedSwitch = approvedSwitch;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}



