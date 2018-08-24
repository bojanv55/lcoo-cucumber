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
	public Map<LineId[], Set<Outcome>> getOutcomes() {
		return null;
	}

	@Override
	public Line<T> withKeyFor(Key newKey, TypeKey... typeKeySpecifier) {
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
