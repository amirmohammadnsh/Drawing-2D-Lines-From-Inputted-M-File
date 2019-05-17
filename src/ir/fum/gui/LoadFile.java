package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile extends JButton implements ActionListener {

    private FileChooser fileChooser;
    private TextPanel textPanel;
    private JTextField fileName;
    private CompilePanel compilePanel;

    public LoadFile(TextPanel textPanel, JTextField fileName,CompilePanel compilePanel) {
        setText("Load Your File");
        setTextPanel(textPanel);
        setFileName(fileName);
        setCompilePanel(compilePanel);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser = new FileChooser(getTextPanel(), getFileName(),getCompilePanel());


            }
        });


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
