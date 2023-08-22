package implementations;

import locators.Locators;
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
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));

    /**
     * Selects the leave date and type for leave application.
     */
    public static void selectLeaveDateAndType() {
        try {
            // Wait for loader to become invisible
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Locators.loadingImage)));
        } catch (Exception e) {
            Log.info("Loader not visible");
        }

        // Wait for the leaveManagementTab to be clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='today']")));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click on Leave Management tab
        WebElement leaveManagementTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.leaveManagement));
        leaveManagementTab.click();

        // Wait for loader to become invisible
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Locators.loadingImage)));
        } catch (Exception e) {
            Log.info("Loader not visible");
        }

        // Click on Leave Apply button
        WebElement leaveApplyButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.leaveApplyButton));
        leaveApplyButton.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            Log.info("Loader not visible");
        }
        try {
            // Select Leave From Date
            WebElement leaveFromDate = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.leaveFromDate));
            leaveFromDate.click();
            leaveFromDate.sendKeys(Keys.ARROW_RIGHT);
            leaveFromDate.sendKeys(Keys.ENTER);

            // Select Leave Till Date
            WebElement leaveTillDate = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.leaveTillDate));
            leaveTillDate.click();
            leaveTillDate.sendKeys(Keys.ENTER);
            try {
                wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Locators.loadingImage)));
                Thread.sleep(6000);
            } catch (Exception e) {
                Log.info("No loader present");
            }
            // Select Leave Type
            WebElement leaveType = driver.findElement(Locators.leaveType);
            Select leaveTypeSelect = new Select(leaveType);
            leaveTypeSelect.selectByIndex(1);

        } catch (Exception e) {
            WebElement unsuccessfulOkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.requestSuccessfulButton));
            unsuccessfulOkButton.click();
            Assert.fail("Leave already applied for following dates");
        }
    }

    /**
     * Sets the reason for leave application.
     */
    public static void setReasonBox() {
        WebElement reasonBox = driver.findElement(Locators.reasonBox);
        reasonBox.sendKeys("unwell");
    }

    /**
     * Marks availability checkboxes for leave.
     */
    public static void markAvailabilityCheckBox() {
        WebElement availableOnMobile = driver.findElement(Locators.availableOnMobile);
        availableOnMobile.click();
        WebElement availableOnEmail = driver.findElement(Locators.availableOnEmail);
        availableOnEmail.click();
    }

    /**
     * Submits the leave application.
     */
    public static void leaveSubmit() {
        WebElement leaveSubmitButton = driver.findElement(Locators.leaveSubmitButton);
        leaveSubmitButton.click();
        WebElement leaveSuccessfulOkButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.requestSuccessfulButton));
        leaveSuccessfulOkButton.click();
    }
}