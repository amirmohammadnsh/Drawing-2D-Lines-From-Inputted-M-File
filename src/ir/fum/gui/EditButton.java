package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditButton extends JButton implements ActionListener {

    private TextPanel textPanel;
    private EditAndSavePanel editAndSavePanel;

    public EditButton(EditAndSavePanel editAndSavePanel, TextPanel textPanel) {
        setTextPanel(textPanel);
        setEnabled(false);
        setEditAndSavePanel(editAndSavePanel);
        setText("Edit");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTextPanel().getTextContent().setEnabled(true);
                setEnabled(false);
                getEditAndSavePanel().getSaveButton().setEnabled(true);
            }
        });

    }

    public EditAndSavePanel getEditAndSavePanel() {
        return editAndSavePanel;
    }

    public void setEditAndSavePanel(EditAndSavePanel editAndSavePanel) {
        this.editAndSavePanel = editAndSavePanel;
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
