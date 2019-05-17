package ir.fum.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CompilePanel extends JPanel {

    private JTextArea consoleTextArea;
    private CompileButton compileButton;
    private String command;
    private TextPanel textPanel;

    public CompilePanel(TextPanel textPanel) {
        setTextPanel(textPanel);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setSize(450, 200);
        setLocation(10, 450);
//        setBorder(new LineBorder(Color.GRAY, 3));
        compileButton = new CompileButton(getTextPanel());
        compileButton.setEnabled(false);

//        correctMistakesButton = new JButton("Correct");
//        compileButton.setBorder(new LineBorder(Color.GRAY,1));
        consoleTextArea = new JTextArea(10, 43);
        consoleTextArea.setBorder(new LineBorder(Color.GRAY, 2));
        consoleTextArea.setEnabled(false);
//        JScrollPane jScrollPane = new JScrollPane(consoleTextArea);
//        jScrollPane.setPreferredSize(new Dimension(300, 190));
//        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        add(jScrollPane);
//        setBackground(Color.PINK);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(compileButton, gridBagConstraints);
//        gridBagConstraints.gridy = 0 ;
//        gridBagConstraints.gridx =1 ;
//        gridBagConstraints.weighty = 0.1;
//        add(correctMistakesButton,gridBagConstraints);
        gridBagConstraints.gridy = 1;
//        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(consoleTextArea, gridBagConstraints);
        setVisible(true);


    }

    public CompileButton getCompileButton() {
        return compileButton;
    }
//    private JButton correctMistakesButton;

    public void setCompileButton(CompileButton compileButton) {
        this.compileButton = compileButton;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }
}
