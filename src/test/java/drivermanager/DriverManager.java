package drivermanager;

//import com.sun.org.slf4j.internal.LoggerFactory;
import config.AppConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static WebDriver driver;
  //  private static Logger logger= LogManager.getLogger(DriverManager.class);
    private static Logger logger = LogManager.getLogger(DriverManager.class);

    private DriverManager() {
    }


    private static void initdriver() {
        logger.log(Level.INFO,"Initializing the webdriver with browserType {} ", AppConfig.getProperty("browser"));
        if (AppConfig.getProperty("browser").equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else

        if (AppConfig.getProperty("browser").equals(BrowserType.INTERNET_EXPLORER)) {
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
        }

    }
    public static WebDriver getinstance() {
        if (driver == null) {
          initdriver();
        }
        return driver;
    }
}