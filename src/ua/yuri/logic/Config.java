package ua.yuri.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * User: yuri
 * Date: May 16, 2010
 */
public class Config {
    private Properties properties;
    private String configName = "config";
    private Map<String, String> propsMap = new HashMap<String, String>();

    public Config(String configName) {
        this.configName = configName;
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        
    }


}
