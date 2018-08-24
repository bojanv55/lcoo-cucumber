package me.vukas.domain.model.market.outcome;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class DefaultOutcomeId implements OutcomeId {
	private final String value;
}
