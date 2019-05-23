package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFileButton extends JButton implements ActionListener {

    private FileChooser fileChooser;
    private TextPanel textPanel;
    private JTextField fileName;
    private CompilePanel compilePanel;
    private EditAndSavePanel editAndSavePanel;
//    private boolean approvedSwitch;

    public LoadFileButton(TextPanel textPanel, JTextField fileName, CompilePanel compilePanel, EditAndSavePanel editAndSavePanel) {
//        setApprovedSwitch(approvedSwitch);
        setText("Load Your File");
        setTextPanel(textPanel);
        setFileName(fileName);
        setCompilePanel(compilePanel);
        setEditAndSavePanel(editAndSavePanel);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser = new FileChooser(getTextPanel(), getFileName(), getCompilePanel(), getEditAndSavePanel());


            }
        });


    }

//    public boolean isApprovedSwitch() {
//        return approvedSwitch;
//    }
//
//    public void setApprovedSwitch(boolean approvedSwitch) {
//        this.approvedSwitch = approvedSwitch;
//    }

    public EditAndSavePanel getEditAndSavePanel() {
        return editAndSavePanel;
    }

    public void setEditAndSavePanel(EditAndSavePanel editAndSavePanel) {
        this.editAndSavePanel = editAndSavePanel;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFileChooser(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
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

    public CompilePanel getCompilePanel() {
        return compilePanel;
    }

    public void setCompilePanel(CompilePanel compilePanel) {
        this.compilePanel = compilePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
