package ru.mod.jabberclientlib;

import org.jivesoftware.smack.*;

/**
 * Created by IntelliJ IDEA.
 * User: MoD
 * Date: 30.04.2010
 * Time: 9:44:14
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private XMPPConnection conn;

    public boolean connect(String server, int port) {
        ConnectionConfiguration config = new ConnectionConfiguration(server, port);
        config.setSASLAuthenticationEnabled(true);
        try {
            conn = new XMPPConnection(config);
            conn.connect();
            return true;
        } catch (XMPPException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
    }

    public boolean login(String username, String password) {
        if (conn.isConnected()) {
            try {
                SASLAuthentication.supportSASLMechanism("PLAIN", 0); //Gets rid of the NullPointerException
                conn.login(username, password);
                return true;
            } catch (XMPPException e) {
                System.out.println("Authentication failed");
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                return false;
            }
        } else {
            return false;
        }
    }

    public Roster getRoster() {
        if (conn.isAuthenticated()) {
            return conn.getRoster();
        } else {
            return null;
        }
    }

    public boolean disconnect() {
        if (conn != null && conn.isConnected())
        conn.disconnect();
        return true;
    }

    public boolean isAuthenticated() {
        return (conn.isConnected() && conn.isAuthenticated());
    }
}
