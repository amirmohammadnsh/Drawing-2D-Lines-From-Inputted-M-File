package ir.fum.gui;

import ir.fum.logic.Statements.Statements;

import javax.swing.*;
import java.awt.*;

public class RunPanel extends JPanel {

    private NormalRunnerButton normalRunnerButton;
    private ProfilerRunnerButton profilerRunnerButton;
    private MainFrame mainFrame;
    private PaintPanel paintPanel;
    private Statements[] statements;

    public RunPanel(MainFrame mainFrame, Statements[] statements) {
        setMainFrame(mainFrame);
        setStatements(statements);
        setSize(450, 100);
        setLocation(10, 600);
//        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        paintPanel = new PaintPanel();
        getMainFrame().add(paintPanel);
        getMainFrame().revalidate();// If you add components to the frame after it is visible then you need to revalidate() the JPanel that you add the components to.
        paintPanel.repaint(); // this Keeps the RunPanel Area As We Set in The Code


        normalRunnerButton = new NormalRunnerButton(getStatements(), paintPanel);
        profilerRunnerButton = new ProfilerRunnerButton(getStatements(), paintPanel);

        add(normalRunnerButton);
        add(profilerRunnerButton);

        setVisible(true);
//        revalidate();
//        repaint();

    }

    public Statements[] getStatements() {
        return statements;
    }

    public void setStatements(Statements[] statements) {
        this.statements = statements;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }


}
