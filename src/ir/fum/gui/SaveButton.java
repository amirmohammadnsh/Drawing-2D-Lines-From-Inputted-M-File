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
            setEnabled(false);                                          //SaveButton itself will be disabled
            getEditAndSavePanel().getEditButton().setEnabled(true);     //EditButton will be enabled
            getTextPanel().getTextContent().setEnabled(false);          //textPanel cannot be edited
//            System.out.println(getEditAndSavePanel().getLoadFilePanel().getFilePath().getText());
            getEditAndSavePanel().getChosenFile().saveFile();           //changes made will be saved to the file
//            getEditAndSavePanel().getChosenFile().setNumberOfLines();
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
