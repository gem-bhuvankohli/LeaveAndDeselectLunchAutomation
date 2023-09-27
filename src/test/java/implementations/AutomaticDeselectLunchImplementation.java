package implementations;

import logger.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static implementations.LoginFunctionImplementation.driver;

public class AutomaticDeselectLunchImplementation {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    static LocalDate lunchAppliedDate;
    public static final By applyBtn = By.xpath("(//span[text()='Apply']/parent::a)[1]");

    public static final By applyForLunch = By.id("applyForlunch");
    public static final By btnCloseLunch = By.xpath("//button[@id='btnCloseLunch']");
    public static final By requestSuccessfulButton = By.xpath("//button[text()='OK']");
    public static final By loadingImage = By.xpath("//img[@class='loading-image-round']");

    /**
     * Verifies and selects a lunch date for application.
     */
    public static void verifyAndSelectDateForLunch() {
        WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(applyBtn));
        applyButton.click();

        // Click on lunch apply button
        WebElement lunchApplyButton = wait.until(ExpectedConditions.elementToBeClickable(applyForLunch));
        lunchApplyButton.click();

        // Set the applied lunch date to tomorrow
        lunchAppliedDate = LocalDate.now().plusDays(1); // Set to tomorrow
    }

    /**
     * Deletes the selected lunch date.
     */
    public static void deleteSelectedLunch() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Format the lunch date using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = lunchAppliedDate.format(formatter);
        try {
            // Locate and click delete button for the lunch date
            WebElement deleteDate = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("((//td[text()='" + formattedDate + "']/following-sibling::td)[3]/button)[2]"))));
            deleteDate.click();
        } catch (Exception e) {
            Assert.fail("Lunch already not applied for the following date");
            // Close the lunch button
            WebElement buttonCloseLunch = wait.until(ExpectedConditions.visibilityOfElementLocated(btnCloseLunch));
            buttonCloseLunch.click();
            driver.close();
        }
        // Confirm deletion
        WebElement deletedSuccessfullyButton = wait.until(ExpectedConditions.elementToBeClickable(requestSuccessfulButton));
        deletedSuccessfullyButton.click();

        // Wait for loader to become invisible
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingImage)));
            Thread.sleep(3000);
        } catch (Exception e) {
            Log.info("Loader not visible");
        }

        // Close the lunch button
        WebElement buttonCloseLunch = wait.until(ExpectedConditions.visibilityOfElementLocated(btnCloseLunch));
        buttonCloseLunch.click();
        driver.close();
    }
}