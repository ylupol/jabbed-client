package ua.yuri.logic;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/**
 * User: yuri
 * Date: May 15, 2010
 */
public class ManagementSystem {

    private static ManagementSystem instance;
    private XMPPConnection connection;
    private ConnectionConfiguration config;
    private Roster roster;

    public static final String SERVICE_NAME = "jabber.ru";    // TODO read these parameters from properties file
    public static final int SERVICE_PORT = 5222;
    public static final String USER_NAME = "nwlvl";
    public static final String USER_PASSWORD = "s7yw4vkT";

    /**
     * constructor
     */
    private ManagementSystem() {
    }

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }

    protected ConnectionConfiguration createConfig(boolean useSSL, boolean compressionEnabled) {
        ConnectionConfiguration config = new ConnectionConfiguration(SERVICE_NAME, SERVICE_PORT);
        config.setCompressionEnabled(compressionEnabled);
        config.setSASLAuthenticationEnabled(useSSL);
        return config;
    }

    protected void connect(boolean useSSL) {
        config = createConfig(true, true);
        connection = new XMPPConnection(config);
        try {
            connection.connect();
            connection.login(USER_NAME, USER_PASSWORD);
        } catch (XMPPException e) {
            e.printStackTrace();
        }
    }

    /**
     * Roster
     * @return
     */
    protected Roster getRoster() {
        return connection.getRoster();
    }

    
}
