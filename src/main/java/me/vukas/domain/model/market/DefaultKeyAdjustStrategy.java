package me.vukas.domain.model.market;

import java.util.HashSet;
import java.util.Set;

import me.vukas.domain.model.market.outcome.Odds;
import me.vukas.domain.model.market.outcome.Outcome;

public class DefaultKeyAdjustStrategy implements KeyAdjustStrategy {
	@Override
	public Set<Outcome> applyKeyToOutcomes(Key newKey, Set<Outcome> outcomes) {
		Set<Outcome> adjustedOutcomes = new HashSet<>();
		for(Outcome outcome : outcomes){
			double currentOddsValue = outcome.getOdds().getValue();
			double newKeyValue = newKey.getValue();
			double newOddsValue = currentOddsValue * newKeyValue;
			adjustedOutcomes.add(outcome.withOdds(Odds.of(newOddsValue)));
		}
		return adjustedOutcomes;
	}
}
