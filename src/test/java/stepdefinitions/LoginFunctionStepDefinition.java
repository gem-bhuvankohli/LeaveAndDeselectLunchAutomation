package stepdefinitions;

import implementations.LoginFunctionImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Credentials;

public class LoginFunctionStepDefinition {
    @Given("^Verify error handling for invalid credentials or SSO failure$")
    public static void verifyLoginForInvalidCredentionals() {
        Credentials.properties();
        LoginFunctionImplementation.clickLogin(Credentials.wrongPassword);
    }

    @Then("^Verify successful login via credentials$")
    public static void verifyLogin() {
        Credentials.properties();
        LoginFunctionImplementation.clickLogin(Credentials.password);
    }


    @Then("Verify website loaded successfully with url {string}")
    public void verifyWebsiteLoadedSuccessfullyWithUrl(String expectedUrl) {
        LoginFunctionImplementation.checkUrl(expectedUrl);
    }
}
