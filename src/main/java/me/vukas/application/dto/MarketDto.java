package me.vukas.application.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class MarketDto {
	private int id;
	private final Map<String, MarketLineDto> marketLines = new HashMap<>();
}
