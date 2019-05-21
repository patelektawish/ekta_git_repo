package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class AppConfig {
    private static Properties properties;

    private AppConfig(){
        Path path = Paths.get("src//test//resources//project.properties");
        try {
            InputStream inputStream = new FileInputStream(path.toFile());
            properties = new Properties();
            properties.load(inputStream);
        }catch (IOException ex){

        }
    }

    public static String getProperty(String key){
        if(properties==null){
            new AppConfig();
        }
        return properties.getProperty(key);
    }
}

