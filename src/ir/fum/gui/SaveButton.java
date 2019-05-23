package ir.fum.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButton extends JButton implements ActionListener {
    private TextPanel textPanel;
    private EditAndSavePanel editAndSavePanel;

    public SaveButton(EditAndSavePanel editAndSavePanel, TextPanel textPanel) {
    setTextPanel(textPanel);
    setEditAndSavePanel(editAndSavePanel);
    setEnabled(false);
    setText("Save");
    addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false);
            getEditAndSavePanel().getEditButton().setEnabled(true);
            getTextPanel().getTextContent().setEnabled(false);
//            System.out.println(getEditAndSavePanel().getLoadFilePanel().getFilePath().getText());
            getEditAndSavePanel().getChosenFile().saveFile();
        }
    });
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public EditAndSavePanel getEditAndSavePanel() {
        return editAndSavePanel;
    }

    public void setEditAndSavePanel(EditAndSavePanel editAndSavePanel) {
        this.editAndSavePanel = editAndSavePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
