package me.vukas;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.vukas.application.dto.MarketDto;
import me.vukas.application.dto.MarketLineDto;
import me.vukas.application.dto.OutcomeDto;

public class MarketStepDef {

	private MarketDto marketDto;

	@Given("we receive single line market with identifier {string}")
	public void weReceiveSingleLineMarketWithIdentifier(String marketIdentifier) {
		marketDto = new MarketDto();
		marketDto.setId(Integer.parseInt(marketIdentifier));
	}

	@And("we receive probabilities for outcomes for that market")
	public void weReceiveProbabilitiesForOutcomesForThatMarket(List<ImportedOutcome> importedOutcomes) {
		MarketLineDto marketLineDto = new MarketLineDto();
		copyOutcomesToDto(importedOutcomes, marketLineDto);
		marketDto.getMarketLines().put("", marketLineDto);
	}

	@When("we copy all data from received single line DTO to domain object")
	public void weCopyAllDataFromReceivedSingleLineDTOToDomainObject() {

	}

	@Then("domain object should have all matching data from received single line DTO")
	public void domainObjectShouldHaveAllMatchingDataFromReceivedSingleLineDTO() {

	}

	@Given("we receive multi line market with identifier {string}")
	public void weReceiveMultiLineMarketWithIdentifier(String marketIdentifier) throws Throwable {
		marketDto = new MarketDto();
		marketDto.setId(Integer.parseInt(marketIdentifier));
	}

	@And("we receive probabilities for outcomes for that market for typeKey {string}")
	public void weReceiveProbabilitiesForOutcomesForThatMarketForTypeKey(String typeKey, List<ImportedOutcome> importedOutcomes) throws Throwable {
		MarketLineDto marketLineDto = new MarketLineDto();
		marketLineDto.setTypeKey(typeKey);
		copyOutcomesToDto(importedOutcomes, marketLineDto);
		marketDto.getMarketLines().put(typeKey, marketLineDto);
	}

	@When("we copy all data from received multi line DTO to domain object")
	public void weCopyAllDataFromReceivedMultiLineDTOToDomainObject() {

	}

	@Then("domain object should have all matching data from received multi line DTO")
	public void domainObjectShouldHaveAllMatchingDataFromReceivedMultiLineDTO() {

	}

	private void copyOutcomesToDto(List<ImportedOutcome> importedOutcomes, MarketLineDto marketLineDto) {
		for(ImportedOutcome io : importedOutcomes){
			OutcomeDto outcomeDto = new OutcomeDto();
			outcomeDto.setId(1);
			outcomeDto.setValue(io.probability);
			marketLineDto.getProbabilities().add(outcomeDto);
		}
	}
}
