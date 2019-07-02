package ir.fum.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CompilePanel extends JPanel {

    private JTextArea consoleTextArea;
    private CompileButton compileButton;
    private String command;
    private LoadFilePanel loadFilePanel;
    private WestPanel westPanel;

    public CompilePanel(WestPanel westPanel) {
        setWestPanel(westPanel);

        setSize(450, 200);
        setLocation(10, 390);
//        setLayout(new GridBagLayout());
//        GridBagConstraints gridBagConstraints = new GridBagConstraints();
//       // setBorder(new LineBorder(PenColor.GRAY, 3));
//        //compileButton = new CompileButton(consoleTextArea);
//        //compileButton.setEnabled(false);
//          setLayout(null);
//        //correctMistakesButton = new JButton("Correct");
//        //compileButton.setBorder(new LineBorder(PenColor.GRAY,1));
        consoleTextArea = new JTextArea(10, 43);
        consoleTextArea.setBorder(new LineBorder(Color.GRAY, 2));
//        consoleTextArea.setPreferredSize(new Dimension(450, 180));

        JScrollPane jScrollPane = new JScrollPane(consoleTextArea);
        jScrollPane.setPreferredSize(new Dimension(450, 150));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        jScrollPane.setHorizontalScrollBar(jScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        jScrollPane.setVerticalScrollBar(null);

//        setLayout(new SpringLayout());

        consoleTextArea.setEnabled(false);
        compileButton = new CompileButton(consoleTextArea,getWestPanel());
        compileButton.setEnabled(false);
        compileButton.setBackground(new Color(255,184,113));
//        compileButton.setBackground(Color.PINK);
//        compileButton.setBounds(10,10,100,100);
//        gridBagConstraints.gridy = 0;
//        gridBagConstraints.anchor = GridBagConstraints.WEST;
//        add(compileButton, gridBagConstraints);
        add(compileButton);
        add(jScrollPane);
//        JScrollPane jScrollPane = new JScrollPane(consoleTextArea);
//        jScrollPane.setPreferredSize(new Dimension(300, 190));
//        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        add(jScrollPane);

//        //setBackground(PenColor.PINK);
//        gridBagConstraints.gridy = 0;
//        gridBagConstraints.anchor = GridBagConstraints.WEST;
//        //add(compileButton, gridBagConstraints);

//        //gridBagConstraints.gridy = 0 ;
//        //gridBagConstraints.gridx =1 ;
//        //gridBagConstraints.weighty = 0.1;
//        //add(correctMistakesButton,gridBagConstraints);
//        gridBagConstraints.gridy = 1;
//        //gridBagConstraints.anchor = GridBagConstraints.WEST;
//        add(consoleTextArea, gridBagConstraints);
        setVisible(true);
    }

    public WestPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(WestPanel westPanel) {
        this.westPanel = westPanel;
    }

    public LoadFilePanel getLoadFilePanel() {
        return loadFilePanel;
    }

    public void setLoadFilePanel(LoadFilePanel loadFilePanel) {
        this.loadFilePanel = loadFilePanel;
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

//    public TextPanel getTextPanel() {
//        return textPanel;
//    }
//
//    public void setTextPanel(TextPanel textPanel) {
//        this.textPanel = textPanel;
//    }
}
