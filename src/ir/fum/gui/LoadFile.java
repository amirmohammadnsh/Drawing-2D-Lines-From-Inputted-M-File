package ir.fum.gui;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile extends JButton implements ActionListener {


   public LoadFile(TextPanel textPanel,JTextField fileName) {
        setText("Load Your File");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                fileChooser.showOpenDialog(null);
                System.out.println("Clicked");
                textPanel.getTextContent().setText("Hello There");
                fileName.setText("It is ");
            }
        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
