package PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactSalePage {
    WebDriver driver;
    @FindBy(id = "email")
    private WebElement workEmail;

    @FindBy(id = "company")
    private WebElement companyname;

    @FindBy(id = "first_name")
    private WebElement firstname;

    @FindBy(id = "last_name")
    private WebElement lastname;

    @FindBy(id = "employee_count")
    private WebElement employeecount;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement zip;

    @FindBy(id = "description")
    private WebElement additional;

    @FindBy(id="btnSubmit")
    private WebElement submit;
    public ContactSalePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactSalePage keyemail(String email) {
        this.workEmail.sendKeys(email);
        return this;
    }

    public ContactSalePage keyInFirstName(String name) {
        this.firstname.sendKeys(name);
        return this;
    }

    public ContactSalePage keycompany(String company) {
        this.companyname.sendKeys(company);
        return this;
    }

    public ContactSalePage keylastname(String lastname) {
        this.lastname.sendKeys(lastname);
        return this;
    }

    public ContactSalePage keyemployeecount(int index) {
        Select select = new Select(this.employeecount);
        select.selectByIndex(index);
        return this;
    }

    public ContactSalePage keyphone(String phone) {
        this.phone.sendKeys("4534545435");
        return this;
    }
    public ContactSalePage selectcountry(String value){
        Select select =new Select(this.country);
        select.selectByValue(value);
        return this;
    }
    public ContactSalePage selectstate(int index) {
        if (this.country.getAttribute("value").equalsIgnoreCase("US")) {
            this.state = driver.findElement(By.id("state"));
            Select select = new Select(this.state);
            select.selectByIndex(2);

        }
        return this;
    }
    public ContactSalePage keyzip(String zip){
        this.zip.sendKeys("34324234");
        return this;
    }
    public ContactSalePage keydescription(String description){
        this.additional.sendKeys("this is a demo");
        return this;
    }
    public WebElement submitbutton(){
        this.submit.click();

        return driver.findElement(By.xpath("//*[@id=\"support_contact\"]/div[2]/p"));

    }
}

//select select =new select(this.employeecount)
//select.selectbyindex(index)
//return this;

