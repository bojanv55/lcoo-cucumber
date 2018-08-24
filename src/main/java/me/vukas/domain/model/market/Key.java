package me.vukas.domain.model.market;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class Key {
	private final Integer value;

	public static Key fair(){
		return new Key(100);
	}
}
