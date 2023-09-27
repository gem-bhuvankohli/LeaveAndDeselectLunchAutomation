package implementations;

import logger.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static implementations.LoginFunctionImplementation.driver;

public class AutomaticLeaveApplyImplementation {

    public static final By leaveManagement = By.xpath("//span[text()='Leave Management']");
    public static final By leaveApplyBtn = By.xpath("(//span[text()='Apply']/parent::a)[2]");
    public static final By reasonBox = By.id("leaveReason");
    public static final By todayText = By.xpath("//button[text()='today']");
    public static final By leaveDateFrom = By.xpath("//input[@placeholder='Leave From']");
    public static final By leaveDateTill = By.xpath("//input[@placeholder='Leave Till']");
    public static final By avlbOnMobile = By.id("avilableOnMobile");
    public static final By avlbOnEmail = By.id("avilableOnEmail");
    public static final By leaveCategory = By.id("leaveType");
    public static final By leaveSubmitBtn = By.xpath("//div[@class='col-md-8']/descendant::input");
    public static final By requestSuccessfulButton = By.xpath("//button[text()='OK']");
    public static final By loadingImage = By.xpath("//img[@class='loading-image-round']");
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));

    /**
     * Selects the leave date and type for leave application.
     */
    public static void selectLeaveDateAndType() {
        try {
            // Wait for loader to become invisible
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingImage)));
        } catch (Exception e) {
            Log.info("Loader not visible");
        }

        // Wait for the leaveManagementTab to be clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(todayText));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click on Leave Management tab
        WebElement leaveManagementTab = wait.until(ExpectedConditions.elementToBeClickable(leaveManagement));
        leaveManagementTab.click();

        // Wait for loader to become invisible
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingImage)));
        } catch (Exception e) {
            Log.info("Loader not visible");
        }

        // Click on Leave Apply button
        WebElement leaveApplyButton = wait.until(ExpectedConditions.elementToBeClickable(leaveApplyBtn));
        leaveApplyButton.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            Log.info("Loader not visible");
        }
        try {
            // Select Leave From Date
            WebElement leaveFromDate = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveDateFrom));
            leaveFromDate.click();
            leaveFromDate.sendKeys(Keys.ARROW_RIGHT);
            leaveFromDate.sendKeys(Keys.ENTER);

            // Select Leave Till Date
            WebElement leaveTillDate = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveDateTill));
            leaveTillDate.click();
            leaveTillDate.sendKeys(Keys.ENTER);
            try {
                wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingImage)));
                Thread.sleep(6000);
            } catch (Exception e) {
                Log.info("No loader present");
            }
            // Select Leave Type
            WebElement leaveType = driver.findElement(leaveCategory);
            Select leaveTypeSelect = new Select(leaveType);
            leaveTypeSelect.selectByIndex(1);

        } catch (Exception e) {
            WebElement unsuccessfulOkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(requestSuccessfulButton));
            unsuccessfulOkButton.click();
            Assert.fail("Leave already applied for following dates");
        }
    }

    /**
     * Sets the reason for leave application.
     */
    public static void setReasonBox() {
        WebElement setReasonBox = driver.findElement(reasonBox);
        setReasonBox.sendKeys("unwell");
    }

    /**
     * Marks availability checkboxes for leave.
     */
    public static void markAvailabilityCheckBox() {
        WebElement availableOnMobile = driver.findElement(avlbOnMobile);
        availableOnMobile.click();
        WebElement availableOnEmail = driver.findElement(avlbOnEmail);
        availableOnEmail.click();
    }

    /**
     * Submits the leave application.
     */
    public static void leaveSubmit() {
        WebElement leaveSubmitButton = driver.findElement(leaveSubmitBtn);
        leaveSubmitButton.click();
        WebElement leaveSuccessfulOkButton = wait.until(ExpectedConditions.elementToBeClickable(requestSuccessfulButton));
        leaveSuccessfulOkButton.click();
    }
}