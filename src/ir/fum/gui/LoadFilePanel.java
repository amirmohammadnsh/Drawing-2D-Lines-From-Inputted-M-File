package ir.fum.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoadFilePanel extends JPanel {

    private TextPanel textPanel;

    public JTextField getFileName() {
        return fileName;
    }

    public void setFileName(JTextField fileName) {
        this.fileName = fileName;
    }

    private JTextField fileName ;

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public LoadFilePanel(TextPanel textPanel) {

        setTextPanel(textPanel);
        fileName = new JTextField(30);
        setFileName(fileName);
        LoadFile loadFile = new LoadFile(getTextPanel(),fileName);

        loadFile.setBorder(new LineBorder(Color.GRAY, 3));


        setSize(450, 30);
        setLocation(10, 10);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        add(loadFile, gridBagConstraints);


        fileName.setBorder(new LineBorder(Color.GRAY, 3));

        gridBagConstraints.weightx = 0.5;
        add(fileName, gridBagConstraints);
        setVisible(true);

    }


}
