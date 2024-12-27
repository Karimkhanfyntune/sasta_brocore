package com.example.demo.Enum;

import java.util.Optional;

public enum MyEnum {
	N,Y;

	public static Optional<MyEnum> check(String val) {
		try {
			return Optional.of(MyEnum.valueOf(val));
		} catch (IllegalArgumentException e) {
			// do nothing
		}
		return Optional.empty();
	}
}
