package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile extends JButton implements ActionListener {

    private FileChooser fileChooser;
    private TextPanel textPanel;
    private JTextField fileName;

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

    public LoadFile(TextPanel textPanel, JTextField fileName) {
        setText("Load Your File");
        setTextPanel(textPanel);
        setFileName(fileName);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
////                fileChooser.setDialogTitle();
//                fileChooser.showOpenDialog(null);
                fileChooser = new FileChooser(getTextPanel(),getFileName());


//                System.out.println("Clicked");
//                textPanel.getTextContent().setText("Hello There");
//                fileName.setText("It is ");
            }
        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
