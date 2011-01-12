package ru.mod.jabberclientapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: MoD
 * Date: 30.04.2010
 * Time: 10:47:46
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow {
    private JPanel main;
    private JComboBox statusBox;
    private JList rosterList;
    private JLabel stateLabel;

    public MainWindow() {
        statusBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (statusBox.getSelectedIndex() == 1)
                {
                    if (Controller.disconnect()) {
                        stateLabel.setText("Disconnected");
                    }
                } else {
                    if (Controller.connect()) {
                        stateLabel.setText("Connected");

                        if (Controller.login()) {
                            rosterList = new JList(Controller.getRosterModel()); //TODO 
                        } else {
                            stateLabel.setText("Authentication failed");
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");

        JMenuBar menuBar = getMenuBar();

        frame.setJMenuBar(menuBar);
        frame.setContentPane(new MainWindow().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

        private static JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem settingsItem = new JMenuItem("Settings", 0);

        settingsItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Controller.showSettingsDialog();
            }
        });

        fileMenu.add(settingsItem);
        menuBar.add(fileMenu);
        return menuBar;
    }
}
