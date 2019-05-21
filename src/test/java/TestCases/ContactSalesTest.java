package TestCases;

import PageObjectModel.ContactSalePage;
import PageObjectModel.MainNavigation;
import config.AppConfig;
import drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import listner.ScreenShotListner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShotListner.class})
public class ContactSalesTest {
    WebDriver driver= DriverManager.getinstance();
    Logger logger= LogManager.getLogger(ContactSalesTest.class);

    MainNavigation nav;
    ContactSalePage cp;

    @BeforeSuite
    public void setup(){
  //      WebDriverManager.chromedriver().setup();
  //      driver=new ChromeDriver();
        driver.manage().window().maximize();
        logger.log(Level.INFO ,"opening url{}",AppConfig.getProperty("url"));
        driver.get(AppConfig.getProperty("url"));
        nav =new MainNavigation(driver);
    }

    @Test
    public void contacttest(){
        cp=nav.ClickonContactSale();
        WebElement element =cp
                .keycompany("xyz")
                .keydescription("this is demo")
                .keyemail("ekd@gmail.com")
                .keyemployeecount(2)
                .keyInFirstName("ek")
                .keylastname("pa")
                .keyphone("3432423")
                .keyzip("548484")
                .selectcountry("US")
                .selectstate(2)
                .submitbutton();
        Assert.assertEquals(element.getText(),"Thank you for contacting Zoom! We will be in touch soon.");


    }
}
