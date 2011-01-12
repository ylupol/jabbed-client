package ru.mod.jabberclientapp;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

import org.jivesoftware.smack.*;
import ru.mod.jabberclientlib.*;

/**
 * Created by IntelliJ IDEA.
 * User: MoD
 * Date: 30.04.2010
 * Time: 11:54:50
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    private static Properties properties = new Properties();
    private static String propertiesPath =
           "D:\\Projects\\JabberClient\\src\\ru\\mod\\jabberclientapp\\Settings.properties"; //TODO 
    private static Client client = new Client();

    public static void setUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void showMainWindow() {
        MainWindow.main(null);
    }

    public static void showSettingsDialog() {
        Settings.main(null);
    }

    public static void loadProperties() {
        try {
            properties.load(new FileInputStream(propertiesPath));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void storeProperties() {
        try {
            properties.store(new FileOutputStream(propertiesPath), null);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static boolean connect() {
        return client.connect(getProperty("server"), 5222);
    }

    public static boolean login() {
        return client.login(getProperty("username"), getProperty("password"));
    }

    public static boolean disconnect() {
        return client.disconnect();
    }

    public static DefaultListModel getRosterModel() { //TODO ��� ��� �����-�� �����: ���� ����������� � �������/����� �������, � �� �� �� ����������� (����, ����������� ��, ��������, ������ ����������� � ��.)
        DefaultListModel model = new DefaultListModel();
        if (client.isAuthenticated()) {
            Roster roster = client.getRoster();

            if (roster != null) {
                int i = 0;
                for (RosterEntry entry : roster.getEntries()) {
                    model.add(i, entry.getName());
                    i++;
                }
            }
        }

        return model;
    }
}
