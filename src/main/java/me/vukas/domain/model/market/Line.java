package me.vukas.domain.model.market;

import java.util.Map;
import java.util.Set;

import me.vukas.domain.model.market.outcome.Outcome;

public interface Line<T extends LineId> extends KeyAdjustable<T> {
	T getLineId();
	Map<TypeKeysSpecifier, Set<Outcome>> getOutcomes();	//maybe only on MultiLine market?
	//Set<Outcome> getOutcomes(TypeKeysSpecifier specifier);
	//Set<Outcome> getOutcomes(TypeKey... typeKeys);	//beter in a way that we don't need to specify specifier for single line (also for key adjustments)

	//when transfering to dto -> get all typekeys with one method, then get all outcomes from other method?
	//Set<TypeKey[]> getTypeKeys();	-> empty set for single line
}
