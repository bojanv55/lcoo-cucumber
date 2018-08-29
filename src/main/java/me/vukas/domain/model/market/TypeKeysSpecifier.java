package me.vukas.domain.model.market;

import java.util.Deque;
import java.util.LinkedList;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TypeKeysSpecifier {
	private final Deque<TypeKey> value;

	public static TypeKeysSpecifier empty(){
		return new TypeKeysSpecifier(new LinkedList<>());
	}

	public TypeKeysSpecifier withPrefix(TypeKey typeKey){
		Deque<TypeKey> newValue = new LinkedList<>(value);
		newValue.addFirst(typeKey);
		return new TypeKeysSpecifier(newValue);
	}

	public static TypeKeysSpecifier of(TypeKey typeKey){
		return TypeKeysSpecifier.empty().withPrefix(typeKey);
	}
}
