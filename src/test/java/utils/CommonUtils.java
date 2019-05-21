package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//creating screenshot folder
public class CommonUtils {
    public static String screenShotDirName;
    static Logger logger = LogManager.getLogger(CommonUtils.class);

    public static void createScreenShotDirectories(){

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");
        String folder = format.format(new Date());
        screenShotDirName = folder;
        logger.log(Level.INFO, "Creating screenshot direcotories {} ", folder);
        Path path = Paths.get("screenshot", folder);

        try {
            Files.createDirectories(path);
            Files.createDirectories(Paths.get(path.toString(),"pass"));
            Files.createDirectories(Paths.get(path.toString(),"fail"));
        }catch (IOException ex){
            logger.log(Level.ERROR,"Error in creating directory msg {}", ex.getMessage());
        }
    }

    public static String getFileName(String testName, boolean pass){
        createScreenShotDirectories();
        if(pass) {
            return Paths.get("screenshot",screenShotDirName,"pass", testName+".png").toString();
        }
        return Paths.get("screenshot",screenShotDirName,"fail", testName+".png").toString();
    }
}
