package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties property;

    /*
      Read values from config.property file
     */
    public Properties init_prop()
    {
        property = new Properties();
       try
       {
           FileInputStream PropertiesFile = new FileInputStream("./src/test/resources/config/config.properties");
           property.load(PropertiesFile);
       }
       catch (Exception e)
       {
           System.out.println("Exception: "+e.getMessage().toString());
       }
       return property;
    }
}
