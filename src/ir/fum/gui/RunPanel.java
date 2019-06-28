package ir.fum.gui;

import ir.fum.logic.Pen;
import ir.fum.logic.Statements.Statements;
import ir.fum.logic.Statements.StyleType;

import javax.swing.*;
import java.awt.*;

public class RunPanel extends JPanel {

    private NormalRunnerButton normalRunnerButton;
    private ProfilerRunnerButton profilerRunnerButton;
    private MainFrame mainFrame;
    private PaintPanel paintPanel;
    private Statements[] statements;
    private Pen pen;

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

        pen = Pen.getInstance();

        normalRunnerButton = new NormalRunnerButton(getStatements(), paintPanel, pen);
        profilerRunnerButton = new ProfilerRunnerButton(getStatements(), paintPanel, pen);
        setNormalRunnerButton(normalRunnerButton);
        setProfilerRunnerButton(profilerRunnerButton);

        add(normalRunnerButton);
        add(profilerRunnerButton);

        setVisible(true);
//        revalidate();
//        repaint();

    }

    public NormalRunnerButton getNormalRunnerButton() {
        return normalRunnerButton;
    }

    public void setNormalRunnerButton(NormalRunnerButton normalRunnerButton) {
        this.normalRunnerButton = normalRunnerButton;
    }

    public ProfilerRunnerButton getProfilerRunnerButton() {
        return profilerRunnerButton;
    }

    public void setProfilerRunnerButton(ProfilerRunnerButton profilerRunnerButton) {
        this.profilerRunnerButton = profilerRunnerButton;
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
