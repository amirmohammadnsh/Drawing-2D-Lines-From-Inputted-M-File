package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile extends JButton implements ActionListener {

    private FileChooser fileChooser;
    private TextPanel textPanel;
    private JTextField fileName;

    public LoadFile(TextPanel textPanel, JTextField fileName) {
        setText("Load Your File");
        setTextPanel(textPanel);
        setFileName(fileName);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser = new FileChooser(getTextPanel(), getFileName());


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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
