package ru.mod.jabbertest;

import org.jivesoftware.smack.*;
import ru.mod.jabberclientlib.*;

/**
 * Created by IntelliJ IDEA.
 * User: MoD
 * Date: 30.04.2010
 * Time: 9:42:57
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        boolean stat = client.connect("jabber.ru", 5222);
        System.out.println("Connection status: " + stat);

        stat = client.login("nwlvl", "s7yw4vkT");
        System.out.println("Login status: " + stat);

        Roster roster = client.getRoster();

        if (roster != null) {
            for (RosterEntry entry : roster.getEntries()) {
                System.out.println(entry.getName());
            }
        }

        client.disconnect();
    }
}
