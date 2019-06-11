package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class RunPanel extends JPanel {

private NormalRunnerButton normalRunnerButton;
private ProfilerRunnerButton profilerRunnerButton ;
    public RunPanel() {
        setSize(450, 100);
        setLocation(10, 600);
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        normalRunnerButton = new NormalRunnerButton();
        profilerRunnerButton = new ProfilerRunnerButton();

        add(normalRunnerButton);
        add(profilerRunnerButton);

        setVisible(true);
//        revalidate();
//        repaint();

    }


}
