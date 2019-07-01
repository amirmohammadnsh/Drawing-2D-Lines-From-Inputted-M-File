package ir.fum.logic.Exceptions;

import ir.fum.gui.MainFrame;

import javax.swing.*;

public class RunTimeMoveException extends Exception {

    private MainFrame mainFrame;

    public RunTimeMoveException(MainFrame mainFrame) {
        setMainFrame(mainFrame);
        getMainFrame().dispose();


    }

    public void showMessage() {
        JOptionPane.showMessageDialog(null, "Movement Out Of Bounds ");
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }


}
