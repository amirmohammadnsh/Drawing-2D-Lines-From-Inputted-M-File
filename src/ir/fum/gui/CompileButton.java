package ir.fum.gui;

import ir.fum.logic.Parser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompileButton extends JButton implements ActionListener {


    //    private TextPanel textPanel;
    private Parser parser;
    private LoadFilePanel loadFilePanel;

    public CompileButton() {
//        setTextPanel(textPanel);
//        setLoadFilePanel(loadFilePanel);
        setText("Parser"); // should be changed to Compile Button
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(getTextPanel().getTextContent().getText());
                parser = new Parser(getLoadFilePanel().getLoadFileButton().getFileChooser().getChosenFile());
            }
        });

    }

    public LoadFilePanel getLoadFilePanel() {
        return loadFilePanel;
    }

    public void setLoadFilePanel(LoadFilePanel loadFilePanel) {
        this.loadFilePanel = loadFilePanel;
    }

//    public TextPanel getTextPanel() {
//        return textPanel;
//    }
//
//    public void setTextPanel(TextPanel textPanel) {
//        this.textPanel = textPanel;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
