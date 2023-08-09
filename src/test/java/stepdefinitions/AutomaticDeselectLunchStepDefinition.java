package stepdefinitions;

import implementations.AutomaticDeselectLunchImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AutomaticDeselectLunchStepDefinition {
    @Given("^Verify entries in Apply For Lunch$")
    public static void verifyEntriesInLunchApply() {
        AutomaticDeselectLunchImplementation.verifyAndSelectDateForLunch();

    }

    @Then("Verify deletion of matching entries")
    public void verifyDeletionOfMatchingEntries() {
        AutomaticDeselectLunchImplementation.deleteSelectedLunch();
    }
}
