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
    private WestPanel westPanel;

    public CompileButton(JTextArea consoleTextArea, WestPanel westPanel) {
        setConsoleTextArea(consoleTextArea);
        setWestPanel(westPanel);
//        setTextPanel(textPanel);
//        setLoadFilePanel(loadFilePanel);
        setLayout(null);
        setBounds(-100, 390, 30, 80);
        setText("Compiler"); // should be changed to Compile Button
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(getTextPanel().getTextContent().getText());
                getConsoleTextArea().setText(null);
                parser = new Parser(getLoadFilePanel().getLoadFileButton().getFileChooser().getChosenFile(), getConsoleTextArea(),getWestPanel());
            }
        });

    }

    public WestPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(WestPanel westPanel) {
        this.westPanel = westPanel;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
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
