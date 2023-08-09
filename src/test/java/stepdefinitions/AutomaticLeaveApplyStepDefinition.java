package stepdefinitions;

import implementations.AutomaticLeaveApplyImplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomaticLeaveApplyStepDefinition {
    @Given("Verify leave date functionality \\(From-Till)")
    public static void verifyLeaveDateFunctionalityFromTill() {
        AutomaticLeaveApplyImplementation.selectLeaveDateAndType();
    }
    @When("^Verify reason box$")
    public static void verifyReasonBox(){
        AutomaticLeaveApplyImplementation.setReasonBox();
    }
    @And("^Verify availability checkbox$")
    public static void checkAvailibilityCheckBoxes(){
        AutomaticLeaveApplyImplementation.markAvailibilityCheckBox();
    }
    @Then("^Verify leave apply$")
    public static void verifyLeaveApplyButton(){
        AutomaticLeaveApplyImplementation.leaveSubmit();
    }

}
