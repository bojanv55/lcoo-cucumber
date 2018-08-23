package me.vukas.domain.model;

public class MarketId implements LineId {
    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
