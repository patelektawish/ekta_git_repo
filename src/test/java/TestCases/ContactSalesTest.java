package TestCases;

import PageObjectModel.ContactSalePage;
import PageObjectModel.MainNavigation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ContactSalesTest {
    WebDriver driver;
    MainNavigation nav;
    ContactSalePage cp;
    
    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoom.us");
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
