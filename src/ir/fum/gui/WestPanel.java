package ir.fum.gui;

import javax.swing.*;

public class WestPanel extends JPanel {

    private TextPanel textPanel;
    private LoadFilePanel loadFilePanel;

    public WestPanel() {

        setLayout(null);

        textPanel = new TextPanel();
        loadFilePanel = new LoadFilePanel(getTextPanel());

        setSize(480, 740);
        setLocation(10, 10);

        add(loadFilePanel);
        add(textPanel);


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
