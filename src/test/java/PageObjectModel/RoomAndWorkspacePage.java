package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomAndWorkspacePage {
 WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content_container\"]/section[1]/div/div/div/h1") //zoom for the xpath
    private WebElement roomsAndWorkSpaceText;

    @FindBy(xpath="//*[@id=\"content_container\"]/section[1]/div/div/div/a[2]") //trialLink
    private WebElement trialLink;

    public RoomAndWorkspacePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String roomsAndSpaceTitle() {

        return this.roomsAndWorkSpaceText.getText();
    }
    public RoomAndWorkspacePage keytrail(){
        this.trialLink.click();
        return this;
    }
}




     /*   Actions action = new Actions(driver);
        action.moveToElement(this.RoomsAndWorkSpace).build().perform();
        driver.findElement(By.linkText("Rooms and Workspaces")).click();*/
