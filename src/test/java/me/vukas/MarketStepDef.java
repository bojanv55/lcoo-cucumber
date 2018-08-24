package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.vukas.domain.model.market.Key;
import me.vukas.domain.model.market.Line;
import me.vukas.domain.model.market.MarketId;
import me.vukas.domain.model.market.MultiLine;
import me.vukas.domain.model.market.SingleLine;
import me.vukas.domain.model.market.outcome.DefaultOutcomeId;
import me.vukas.domain.model.market.outcome.Odds;
import me.vukas.domain.model.market.outcome.Outcome;

public class MarketStepDef {

	private SingleLine.Builder<MarketId> singleLineBuilder;
	private MultiLine.Builder<MarketId> multiLineBuilder;
	private Line<MarketId> market;

	@Given("we have single line market with identifier {string}")
	public void we_have_single_line_market_with_identifier(String marketIdentifier) {
		singleLineBuilder = new SingleLine.Builder<>(MarketId.of(marketIdentifier));
	}

	@And("we have following odds for outcomes for that market")
	public void we_have_following_odds_for_outcomes_for_that_market(List<OutcomeDto> outcomes) {
		for(OutcomeDto outcome : outcomes){
			singleLineBuilder.addOutcome(new Outcome(DefaultOutcomeId.of(outcome.outcome), Odds.of(outcome.value)));
		}
		market = singleLineBuilder.build();
	}

	@When("we adjust key value to {string}")
	public void we_adjust_key_value_to(String keyValue) {
		Key newKey = Key.of(Integer.parseInt(keyValue));
		market = market.withKeyFor(newKey);
	}

	@Then("all odds should update to following values")
	public void all_odds_should_update_to_following_values(List<OutcomeDto> outcomesDto) {
		for(OutcomeDto outcomeDto : outcomesDto){
			Set<Outcome> outcomes = market.getOutcomes().get(null);
			Outcome outcomeById = outcomes.stream().filter(o -> Objects.equals(o.getOutcomeId().getValue(), outcomeDto.outcome)).findFirst().get();
			assertThat(outcomeById.getOdds().getValue()).isEqualTo(outcomeDto.value);
		}
	}

	@Given("we have multi line market with identifier {string}")
	public void we_have_multi_line_market_with_identifier(String marketIdentifier) {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("we have following odds for outcomes for typeKey {string} for that market")
	public void we_have_following_odds_for_outcomes_for_typeKey_for_that_market(String typeKey, List<OutcomeDto> outcomes) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new PendingException();
	}

	@When("we adjust key value to {string} for typeKey {string} in that market")
	public void we_adjust_key_value_to_for_typeKey_in_that_market(String keyValue, String typeKey) {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("odds for typeKey {string} should be adjusted to following values")
	public void odds_for_typeKey_should_be_adjusted_to_following_values(String typeKey, List<OutcomeDto> outcomes) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new PendingException();
	}

	@Then("odds for other typeKey should be unchanged")
	public void odds_for_other_typeKey_should_be_unchanged() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("we change {string} outcome value to {double}")
	public void we_change_outcome_value_to(String outcome, Double value) {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("other two outcomes should be adjusted to following values")
	public void other_two_outcomes_should_be_adjusted_to_following_values(List<OutcomeDto> outcomes) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new PendingException();
	}
}
