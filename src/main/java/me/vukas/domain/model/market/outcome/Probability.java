package me.vukas.domain.model.market.outcome;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class Probability {
	private final Double value;

	public static Probability unknown(){
		return new Probability(null);
	}
}
