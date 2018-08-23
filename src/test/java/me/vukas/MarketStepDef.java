package me.vukas;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;

public class MarketStepDef {
    @Given("^we receive single line market identifier$")
    public void weReceiveSingleLineMarketIdentifier(String marketId) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^we receive probabilities for that market$")
    public void weReceiveProbabilitiesForThatMarket(DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^we copy all data from received single line DTO to domain object$")
    public void weCopyAllDataFromReceivedSingleLineDTOToDomainObject() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^domain object should have all matching data from received single line DTO$")
    public void domainObjectShouldHaveAllMatchingDataFromReceivedSingleLineDTO() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^we receive probabilities for that market with the corresponding typeKey$")
    public void weReceiveProbabilitiesForThatMarketWithTheCorrespondingTypeKey(DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^we copy all data from received multi line DTO to domain object$")
    public void weCopyAllDataFromReceivedMultiLineDTOToDomainObject() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^domain object should have all matching data from received multi line DTO$")
    public void domainObjectShouldHaveAllMatchingDataFromReceivedMultiLineDTO() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
