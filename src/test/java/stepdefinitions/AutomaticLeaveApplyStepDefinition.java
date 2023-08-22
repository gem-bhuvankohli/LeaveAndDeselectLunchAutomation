package stepdefinitions;

import implementations.AutomaticLeaveApplyImplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomaticLeaveApplyStepDefinition {
    @Given("the user verifies the functionality to select leave dates \\(From-Till)")
    public static void verifyLeaveDateFunctionalityFromTill() {
        AutomaticLeaveApplyImplementation.selectLeaveDateAndType();
    }

    @When("^the user verifies the presence of the reason input box$")
    public static void verifyReasonBox() {
        AutomaticLeaveApplyImplementation.setReasonBox();
    }

    @And("^the user verifies the functionality of the availability checkbox$")
    public static void checkAvailabilityCheckBoxes() {
        AutomaticLeaveApplyImplementation.markAvailabilityCheckBox();
    }

    @Then("^the user should be able to apply for leave automatically$")
    public static void verifyLeaveApplyButton() {
        AutomaticLeaveApplyImplementation.leaveSubmit();
    }
}
