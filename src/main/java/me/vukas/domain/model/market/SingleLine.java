package me.vukas.domain.model.market;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import me.vukas.domain.model.market.outcome.Outcome;

public class SingleLine<T extends LineId> implements Line<T> {
	private final T lineId;
	private final Key key;
	private final KeyAdjustStrategy keyAdjustStrategy;
	private final Set<Outcome> outcomes;

	private SingleLine(Builder<T> builder){
		lineId = builder.lineId;
		key = builder.key;
		keyAdjustStrategy = builder.keyAdjustStrategy;
		outcomes = builder.outcomes;
	}

	@Override
	public T getLineId() {
		return lineId;
	}

	@Override
	public Map<LineId[], Set<Outcome>> getOutcomes() {
		Map<LineId[], Set<Outcome>> lineIdsToOutcomes = new HashMap<>();
		lineIdsToOutcomes.put(null, outcomes);	//parent caller of this (if any) will map this to proper type-key
		return lineIdsToOutcomes;
	}

	@Override
	public Line<T> withKeyFor(Key newKey, TypeKey... typeKeySpecifier) {
		Builder<T> builder = new Builder<>(lineId);
		builder.setKey(newKey);
		keyAdjustStrategy.applyKeyToOutcomes(newKey, outcomes).forEach(builder::addOutcome);
		return builder.build();
	}

	public static class Builder<T extends LineId> {
		private T lineId;
		private Key key = Key.fair();
		private final KeyAdjustStrategy keyAdjustStrategy = new DefaultKeyAdjustStrategy();
		private Set<Outcome> outcomes = new HashSet<>();

		public Builder(T lineId){
			this.lineId = lineId;
		}

		public Builder<T> setKey(Key key){
			this.key = key;
			return this;
		}

		public Builder<T> addOutcome(Outcome outcome){
			outcomes.add(outcome);
			return this;
		}

		public SingleLine<T> build(){
			return new SingleLine<>(this);
		}
	}
}
