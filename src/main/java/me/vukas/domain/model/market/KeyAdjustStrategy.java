package me.vukas.domain.model.market;

import java.util.Set;

import me.vukas.domain.model.market.outcome.Outcome;

public interface KeyAdjustStrategy {
	Set<Outcome> applyKeyToOutcomes(Key newKey, Set<Outcome> outcomes);
}
