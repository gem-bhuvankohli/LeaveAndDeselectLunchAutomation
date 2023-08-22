package stepdefinitions;

import implementations.AutomaticDeselectLunchImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AutomaticDeselectLunchStepDefinition {
    @Given("^the user verifies the entries in the \"Apply For Lunch\" section$")
    public static void verifyEntriesInLunchApply() {
        AutomaticDeselectLunchImplementation.verifyAndSelectDateForLunch();
    }

    @Then("the user verifies the ability to delete matching entries for lunch application")
    public void verifyDeletionOfMatchingEntries() {
        AutomaticDeselectLunchImplementation.deleteSelectedLunch();
    }
}
