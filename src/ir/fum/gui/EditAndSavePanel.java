package ir.fum.gui;

import ir.fum.logic.ChosenFile;

import javax.swing.*;
import java.awt.*;

public class EditAndSavePanel extends JPanel {

    private EditButton editButton;
    private SaveButton saveButton;
    private TextPanel textPanel;
    private LoadFilePanel loadFilePanel;
    private ChosenFile chosenFile;

    public EditAndSavePanel(TextPanel textPanel) {
        //at anytime, one of the buttons is enabled;
        // first Edit. By clicking on that,Save will be enabled and Edit is disabled;
        // By clicking Save, Save will be disabled and Edit is enabled
        setTextPanel(textPanel);

        editButton = new EditButton(this, getTextPanel());
        saveButton = new SaveButton(this, getTextPanel());

        setLayout(new FlowLayout());
//        setLayout(new GridBagLayout());
//        GridBagConstraints gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.gridx= 0 ;

//        gridBagConstraints.anchor = GridBagConstraints.CENTER;
//        add(editButton,gridBagConstraints);

//        gridBagConstraints.gridx = 1 ;
//        gridBagConstraints.weightx = 0.1;
//        gridBagConstraints.anchor = GridBagConstraints.EAST;
//        add(saveButton,gridBagConstraints);


        setSize(450, 35);
        setLocation(10, 350);
//        setBackground(PenColor.PINK);
        add(editButton);
        add(saveButton);

        setVisible(true);
    }

    public ChosenFile getChosenFile() {
        return chosenFile;
    }

    public void setChosenFile(ChosenFile chosenFile) {
        this.chosenFile = chosenFile;
    }

    public LoadFilePanel getLoadFilePanel() {
        return loadFilePanel;
    }

    public void setLoadFilePanel(LoadFilePanel loadFilePanel) {
        this.loadFilePanel = loadFilePanel;
    }

    public EditButton getEditButton() {
        return editButton;
    }

    public void setEditButton(EditButton editButton) {
        this.editButton = editButton;
    }

    public SaveButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(SaveButton saveButton) {
        this.saveButton = saveButton;
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }


}
