package ir.fum.gui;

import javax.swing.*;

public class WestPanel extends JPanel {

    private TextPanel textPanel;
    private LoadFilePanel loadFilePanel;
    private CompilePanel compilePanel;
    private EditAndSavePanel editAndSavePanel;

    public WestPanel() {

        setLayout(null);

        textPanel = new TextPanel();
        compilePanel = new CompilePanel(getTextPanel());
        editAndSavePanel = new EditAndSavePanel(getTextPanel());
        loadFilePanel = new LoadFilePanel(getTextPanel(), getCompilePanel(),getEditAndSavePanel());
        editAndSavePanel.setLoadFilePanel(getLoadFilePanel());

        setSize(480, 740);
        setLocation(10, 10);

        add(loadFilePanel);
        add(textPanel);
//        add(compilePanel);
        add(editAndSavePanel);


    }

    public CompilePanel getCompilePanel() {
        return compilePanel;
    }

    public void setCompilePanel(CompilePanel compilePanel) {
        this.compilePanel = compilePanel;
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

    public LoadFilePanel getLoadFilePanel() {
        return loadFilePanel;
    }

    public void setLoadFilePanel(LoadFilePanel loadFilePanel) {
        this.loadFilePanel = loadFilePanel;
    }


}
