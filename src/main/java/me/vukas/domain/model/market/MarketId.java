package me.vukas.domain.model.market;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class MarketId implements LineId {
	private final String value;
}
