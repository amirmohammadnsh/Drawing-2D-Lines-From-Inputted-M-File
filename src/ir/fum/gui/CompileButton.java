package ir.fum.gui;

import ir.fum.logic.Parser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompileButton extends JButton implements ActionListener {


    //    private TextPanel textPanel;
    private Parser parser;
    private LoadFilePanel loadFilePanel;
    private JTextArea consoleTextArea;

    public CompileButton(JTextArea consoleTextArea) {
        setConsoleTextArea(consoleTextArea);
//        setTextPanel(textPanel);
//        setLoadFilePanel(loadFilePanel);
        setText("Compiler"); // should be changed to Compile Button
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(getTextPanel().getTextContent().getText());
                parser = new Parser(getLoadFilePanel().getLoadFileButton().getFileChooser().getChosenFile(), getConsoleTextArea());
            }
        });

    }

    public JTextArea getConsoleTextArea() {
        return consoleTextArea;
    }

    public void setConsoleTextArea(JTextArea consoleTextArea) {
        this.consoleTextArea = consoleTextArea;
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
