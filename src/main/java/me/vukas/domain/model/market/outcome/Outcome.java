package me.vukas.domain.model.market.outcome;

import lombok.Data;

@Data
public class Outcome {
	private final OutcomeId outcomeId;
	private final Odds odds;
	private final Probability probability;

	public Outcome(OutcomeId outcomeId, Odds odds, Probability probability){
		this.outcomeId = outcomeId;
		this.odds = odds;
		this.probability = probability;
	}

	public Outcome(OutcomeId outcomeId, Odds odds){
		this(outcomeId, odds, Probability.unknown());
	}

	public Outcome withOdds(Odds odds){
		return new Outcome(outcomeId, odds, probability);
	}
}
