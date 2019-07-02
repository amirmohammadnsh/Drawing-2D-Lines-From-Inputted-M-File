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
    private CompilePanel compilePanel;
    private String error;
    private EditAndSavePanel editAndSavePanel;

    public FileChooser(TextPanel textPanel, JTextField fileName, CompilePanel compilePanel, EditAndSavePanel editAndSavePanel) {
        setTextPanel(textPanel);
        setFileName(fileName);
        setCompilePanel(compilePanel);
        setEditAndSavePanel(editAndSavePanel);

        FileSystemView.getFileSystemView().getHomeDirectory();      //where to be shown when FileChooser is open
        showOpenDialog(this);

    }

    public ChosenFile getChosenFile() {
        return chosenFile;
    }

    public void setChosenFile(ChosenFile chosenFile) {
        this.chosenFile = chosenFile;
    }

    public EditAndSavePanel getEditAndSavePanel() {
        return editAndSavePanel;
    }

    public void setEditAndSavePanel(EditAndSavePanel editAndSavePanel) {
        this.editAndSavePanel = editAndSavePanel;
    }

    public CompilePanel getCompilePanel() {
        return compilePanel;
    }

    public void setCompilePanel(CompilePanel compilePanel) {
        this.compilePanel = compilePanel;
    }

    @Override
    public void approveSelection() {
        File selectedFile = this.getSelectedFile();
        String selectedFilePath = selectedFile.getPath();
        chosenFile = new ChosenFile(selectedFilePath, this);

        if (approvedSwitch) {                                           //if the chosen file is a "m" file
            super.approveSelection();
            getCompilePanel().getCompileButton().setEnabled(true);      //CompileButton will be enabled
            getEditAndSavePanel().getEditButton().setEnabled(true);     //EditButton will be enabled
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



