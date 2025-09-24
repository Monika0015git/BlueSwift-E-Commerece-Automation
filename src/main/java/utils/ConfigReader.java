package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
    private Properties prop;

    public ConfigReader() throws IOException 
    {
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fis);
    }

    public String getProperty(String propertyKey) 
    {
        return prop.getProperty(propertyKey);
    }
}
