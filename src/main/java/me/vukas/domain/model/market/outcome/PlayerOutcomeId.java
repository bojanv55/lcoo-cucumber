package me.vukas.domain.model.market.outcome;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class PlayerOutcomeId implements OutcomeId {
	private String value;
}
