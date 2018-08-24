package me.vukas.application.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MarketLineDto {
	private String typeKey;
	private List<OutcomeDto> odds = new ArrayList<>();
	private List<OutcomeDto> probabilities = new ArrayList<>();
}
