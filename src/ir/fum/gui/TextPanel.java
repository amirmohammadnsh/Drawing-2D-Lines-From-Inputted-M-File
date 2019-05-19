package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    JTextArea textContent;

    public TextPanel() {

        Font font = new Font("Courier", Font.BOLD, 15);

        setSize(450, 300);
        setLocation(10, 50);
        textContent = new JTextArea(40, 40);
        textContent.setFont(font);
        textContent.setEnabled(false);
        textContent.setBackground(Color.GRAY);

        JScrollPane jScrollPane = new JScrollPane(textContent);
        jScrollPane.setPreferredSize(new Dimension(450, 290));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jScrollPane);


        setVisible(true);


    }

    public JTextArea getTextContent() {
        return textContent;
    }

    public void setTextContent(JTextArea textContent) {
        this.textContent = textContent;
    }

}
