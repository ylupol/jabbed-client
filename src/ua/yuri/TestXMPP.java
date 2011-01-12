package ua.yuri;

import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

/**
 * Created by IntelliJ IDEA.
 * User: yuri
 * Date: May 14, 2010
 * Time: 12:27:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestXMPP {
    public static final String SERVICE_NAME = "jabber.ru";
    public static final int SERVICE_PORT = 5222;
    public static final String USER_NAME = "nwlvl";
    public static final String USER_PASSWORD = "s7yw4vkT";
    public XMPPConnection connection;

    @Test
    public void testConnection() throws XMPPException {
        connection = new XMPPConnection(SERVICE_NAME);
        connection.connect();
        assertTrue("Error: is not connected!", connection.isConnected());
        SASLAuthentication.supportSASLMechanism("PLAIN", 0);
        connection.login(USER_NAME, USER_PASSWORD);
        assertTrue("Error: is not aunthenticated!", connection.isAuthenticated());
    }

    @AfterClass
    public void tearDown() {
        if (connection != null && connection.isConnected()) {
            connection.disconnect();
        }
    }

}
