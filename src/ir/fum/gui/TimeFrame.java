package ir.fum.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TimeFrame extends JFrame {

    private JTextArea timeTextArea;

    public TimeFrame() {

        setTitle("Time Table");
        setSize(400, 400);
//        setLocation(10, 640);
//        setBackground(Color.MAGENTA);
        timeTextArea = new JTextArea(20, 3);
        timeTextArea.setBorder(new LineBorder(Color.GRAY, 2));
        JScrollPane jScrollPane = new JScrollPane(timeTextArea);
        jScrollPane.setPreferredSize(new Dimension(300, 300));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        timeTextArea.setEnabled(false);
        timeTextArea.setText("Operation : " + " \t\t" + "Time : \n");
        add(jScrollPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setVisible(true);


    }

    public JTextArea getTimeTextArea() {
        return timeTextArea;
    }

    public void setTimeTextArea(JTextArea timeTextArea) {
        this.timeTextArea = timeTextArea;
    }

}
