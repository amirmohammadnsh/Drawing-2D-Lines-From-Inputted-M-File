package ir.fum.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoadFilePanel extends JPanel {

    private TextPanel textPanel;
    private JTextField filePath;
    private CompilePanel compilePanel;
    private EditAndSavePanel editAndSavePanel;
    private LoadFileButton loadFileButton;

    public LoadFilePanel(TextPanel textPanel, CompilePanel compilePanel, EditAndSavePanel editAndSavePanel) {
        setCompilePanel(compilePanel);
        setTextPanel(textPanel);
        setEditAndSavePanel(editAndSavePanel);
        filePath = new JTextField(30);
        setFilePath(filePath);
        loadFileButton = new LoadFileButton(getTextPanel(), filePath, getCompilePanel(), getEditAndSavePanel());

        loadFileButton.setBorder(new LineBorder(Color.BLUE, 2));


        setSize(450, 30);
        setLocation(10, 10);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        add(loadFileButton, gridBagConstraints);


        filePath.setBorder(new LineBorder(Color.BLUE, 2));

        gridBagConstraints.weightx = 0.5;
        add(filePath, gridBagConstraints);
        setVisible(true);

    }

    public LoadFileButton getLoadFileButton() {
        return loadFileButton;
    }

    public void setLoadFileButton(LoadFileButton loadFileButton) {
        this.loadFileButton = loadFileButton;
    }

    public EditAndSavePanel getEditAndSavePanel() {
        return editAndSavePanel;
    }

    public void setEditAndSavePanel(EditAndSavePanel editAndSavePanel) {
        this.editAndSavePanel = editAndSavePanel;
    }

    public CompilePanel getCompilePanel() {
        return compilePanel;
    }

    public void setCompilePanel(CompilePanel compilePanel) {
        this.compilePanel = compilePanel;
    }

    public JTextField getFilePath() {
        return filePath;
    }

    public void setFilePath(JTextField fileName) {
        this.filePath = fileName;
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }


}
