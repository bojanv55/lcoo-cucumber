package me.vukas.domain.model.market;

public interface KeyAdjustable<T extends LineId> {
	Line<T> withKeyFor(Key newKey, TypeKey... typeKeySpecifier);
}
