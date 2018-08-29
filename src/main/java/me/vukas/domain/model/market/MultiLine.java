package me.vukas.domain.model.market;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import me.vukas.domain.model.market.outcome.Outcome;

public class MultiLine <T extends LineId> implements Line<T> {
	private final T lineId;
	private final Map<TypeKey, Line<? extends TypeKey>> typeKeyedLines;

	private MultiLine(Builder<T> builder){
		lineId = builder.lineId;
		typeKeyedLines = builder.typeKeyedLines;
	}

	@Override
	public T getLineId() {
		return lineId;
	}

	@Override
	public Map<TypeKeysSpecifier, Set<Outcome>> getOutcomes() {
		Map<TypeKeysSpecifier, Set<Outcome>> lineIdsToOutcomes = new HashMap<>();
		for(Line<? extends TypeKey> line : typeKeyedLines.values()){
			TypeKey subLineTypeKey = line.getLineId();
			Map<TypeKeysSpecifier, Set<Outcome>> subLineOutcomesWithSpecifiers = line.getOutcomes();
			for(Map.Entry<TypeKeysSpecifier, Set<Outcome>> outcomesWithSpecifier : subLineOutcomesWithSpecifiers.entrySet()){
				TypeKeysSpecifier subLineSpecifier = outcomesWithSpecifier.getKey();
				Set<Outcome> subLineOutcomes = outcomesWithSpecifier.getValue();
				TypeKeysSpecifier prependedSpecifier = subLineSpecifier.withPrefix(subLineTypeKey);
				lineIdsToOutcomes.put(prependedSpecifier, subLineOutcomes);
			}
		}
		return lineIdsToOutcomes;
	}

	@Override
	public Line<T> withKeyFor(Key newKey, TypeKeysSpecifier specifier) {
		return null;
	}

	public static class Builder<T extends LineId> {
		private T lineId;
		private Map<TypeKey, Line<? extends TypeKey>> typeKeyedLines = new HashMap<>();

		public Builder(T lineId){
			this.lineId = lineId;
		}

		public Builder<T> addLine(Line<? extends TypeKey> line){
			typeKeyedLines.put(line.getLineId(), line);
			return this;
		}

		public MultiLine<T> build(){
			return new MultiLine<>(this);
		}
	}
}
