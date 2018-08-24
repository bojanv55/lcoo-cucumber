package me.vukas.domain.model.market;

import java.util.Map;
import java.util.Set;

import me.vukas.domain.model.market.outcome.Outcome;

public interface Line<T extends LineId> extends KeyAdjustable<T> {
	T getLineId();
	Map<LineId[], Set<Outcome>> getOutcomes();
}
