package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompileButton extends JButton implements ActionListener {


    private TextPanel textPanel;

    public CompileButton(TextPanel textPanel) {
        setTextPanel(textPanel);
        setText("Compile");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(getTextPanel().getTextContent().getText());
            }
        });

    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
