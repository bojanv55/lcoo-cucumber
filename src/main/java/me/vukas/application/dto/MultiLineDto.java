package me.vukas.application.dto;

import java.util.Map;

public class MultiLineDto implements LineDto {
    private String id;
    private Map<String, LineDto> specifierToLine;
}
