package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    JTextArea textContent;

    public JTextArea getTextContent() {
        return textContent;
    }

    public void setTextContent(JTextArea textContent) {
        this.textContent = textContent;
    }

    public TextPanel() {


        setSize(450, 400);
        setLocation(10, 50);
        textContent = new JTextArea(40, 40);
        textContent.setEnabled(false);
        textContent.setBackground(Color.YELLOW);
        JScrollPane jScrollPane = new JScrollPane(textContent);
        jScrollPane.setPreferredSize(new Dimension(450,390));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);


        setVisible(true);


    }

}
