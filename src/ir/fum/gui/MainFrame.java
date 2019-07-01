package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame() {
        setSize(1440, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Auto Painter");
        setLayout(null);
        getContentPane().setBackground(new Color(155,255,255));
        WestPanel westPanel = new WestPanel(this);
        getContentPane().add(westPanel);
        setVisible(true);

    }


}
