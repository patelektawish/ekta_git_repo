package TestCases;

import PageObjectModel.RoomAndWorkspacePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RoomAndWorkspaceTest {
    WebDriver driver;
    RoomAndWorkspacePage room;
    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoom.us/zoomrooms");
    }
    @Test
    public void roomtest(){
    room=new RoomAndWorkspacePage(driver);
    String roomTitle=room.roomsAndSpaceTitle();
    Assert.assertEquals(roomTitle,"Zoom for the\n" +
            "Conference Room");
    room.keytrail();
    }
}
