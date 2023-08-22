package stepdefinitions;

import implementations.LoginFunctionImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Credentials;

public class LoginFunctionStepDefinition {
    @Given("^the user attempts to log in with invalid credentials or encounters SSO failure$")
    public static void verifyLoginForInvalidCredentials() {
        Credentials.properties();
        LoginFunctionImplementation.clickLogin(Credentials.wrongPassword);
    }

    @Then("an appropriate error message should be displayed")
    public static void verifyUnsuccessfulLogin() {
        LoginFunctionImplementation.unsuccessfulLoginMessage();
    }

    @Given("^the user successfully logs in using valid credentials$")
    public static void verifyLogin() {
        Credentials.properties();
        LoginFunctionImplementation.clickLogin(Credentials.password);
    }

    @Then("the website should load successfully with the URL {string}")
    public void verifyWebsiteLoadedSuccessfullyWithUrl(String expectedUrl) {
        LoginFunctionImplementation.checkUrl(expectedUrl);
    }
}
