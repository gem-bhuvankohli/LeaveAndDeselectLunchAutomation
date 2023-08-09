package locators;

import org.openqa.selenium.By;

public class Locators {
    public static final String baseUri = "https://mymis.geminisolutions.com/";
    public static final By username = By.id("username");
    public static final By password = By.id("password");
    public static final By loginBtn = By.id("btnLogin");
    public static final By leaveManagement = By.xpath("//span[text()='Leave Management']");
    public static final By leaveApplyButton = By.xpath("(//span[text()='Apply']/parent::a)[2]");
    public static final By reasonBox = By.id("leaveReason");
    public static final By leaveFromDate = By.xpath("//input[@placeholder='Leave From']");
    public static final By leaveTillDate = By.xpath("//input[@placeholder='Leave Till']");
    public static final By availableOnMobile = By.id("avilableOnMobile");
    public static final By availableOnEmail = By.id("avilableOnEmail");
    public static final By leaveType = By.id("leaveType");
    public static final By leaveSubmitButton = By.xpath("//div[@class='col-md-8']/descendant::input");
    public static final By requestSuccessfulButton = By.xpath("//button[text()='OK']");
    public static final By applyButton = By.xpath("(//span[text()='Apply']/parent::a)[1]");

    public static final By applyForLunch = By.id("applyForlunch");
    public static final By buttonCloseLunch = By.xpath("//button[@id='btnCloseLunch']");
    public static final By loadingImage = By.xpath("//img[@class='loading-image-round']");
}