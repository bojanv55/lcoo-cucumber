package me.vukas.application.dto;

import java.util.Collection;

public class SingleLineDto implements LineDto {
    private String id;
    private Collection<OutcomeDto> odds;
    private Collection<OutcomeDto> probabilities;
}
