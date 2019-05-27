package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame() {
        setSize(1440, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Part One");
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        WestPanel westPanel = new WestPanel();
        getContentPane().add(westPanel);
        setVisible(true);

    }


}
