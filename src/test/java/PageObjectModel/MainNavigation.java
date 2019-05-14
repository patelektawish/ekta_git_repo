package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class MainNavigation {
        WebDriver driver;
        @FindBy(id="btnSolutions")
        private WebElement solution;

        @FindBy(className ="top-pricing")// click and inspect on planpricing menu button and use class
        private WebElement PlanNPricing;

        @FindBy(xpath="//*[@id=\"navbar\"]/ul[1]/li[9]/a")
        private WebElement ContactSale;

        @FindBy(id="btnJoinMeeting")
        private WebElement joinMeeting;

        @FindBy(id="btnHostMeeting")
        private WebElement hostMeeting;

        @FindBy(css=".singin>a")
        private WebElement signin;

        @FindBy(className = "signupfree")
        private WebElement signup;

        public MainNavigation(WebDriver driver) {  //constructor
            this.driver = driver;
            PageFactory.initElements(driver,this); //if i want to call @findby  something then it make object directly using pagefactory
            //if we don't write driver.find........then we use this findby
        }

        public ContactSalePage ClickonContactSale(){
            this.ContactSale.click();
            return new ContactSalePage(this.driver);
        }
    }

