package implementations;

import logger.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Credentials;

import java.time.Duration;

public class LoginFunctionImplementation {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));

    public static final String baseUri = "https://mymis.geminisolutions.com/";
    public static final By usernameInputField = By.id("username");
    public static final By passwordInputField = By.id("password");
    public static final By loginButton = By.id("btnLogin");

    public static final By loadingImage = By.xpath("//img[@class='loading-image-round']");

    /**
     * Performs login action using provided password.
     *
     * @param password The password to use for login.
     */
    public static void clickLogin(String password) {
        try {
            String username = Credentials.username;

            // Open the base URI
            driver.get(baseUri);

            // Maximize the window
            driver.manage().window().maximize();

            // Find and fill the username field
            WebElement usernameField = driver.findElement(usernameInputField);
            usernameField.sendKeys(username);

            // Find and fill the password field
            WebElement passwordField = driver.findElement(passwordInputField);
            passwordField.sendKeys(password);

            try {
                // Wait for loader to become invisible
                wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingImage)));
            } catch (Exception e) {
                Log.info("Loader not visible");
            }

            // Find the login button and click it
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginBtn.click();

            // Log successful login
            Log.info("Login Successful via Credentials!\n\n\n");
        } catch (Exception e) {
            // Log and throw a runtime exception in case of errors
            Log.error("Error during login: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Logs the message for an unsuccessful login attempt.
     */
    public static void unsuccessfulLoginMessage() {
        Log.info("Login Unsuccessful");
    }

    /**
     * Checks if the current URL matches the expected URL.
     *
     * @param expectedUrl The URL expected to match.
     */
    public static void checkUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equalsIgnoreCase(expectedUrl)) {
            Log.info("Successfully verified URL");
        } else {
            Assert.fail("URL verification failed. Expected: " + expectedUrl + ", Actual: " + currentUrl);
        }
    }
}