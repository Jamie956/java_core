package com.example.java8inaction.ch08;

public class StrategyMain {
	public static void main(String[] args) {
		test01();
	}

	public static void test01() {
		// old school
		Validator v1 = new Validator(new IsNumeric());
		System.out.println(v1.validate("aaaa"));

		Validator v2 = new Validator(new IsAllLowerCase());
		System.out.println(v2.validate("bbbb"));
	}

	interface ValidationStrategy {
		public boolean execute(String s);
	}

	static private class IsAllLowerCase implements ValidationStrategy {
		public boolean execute(String s) {
			return s.matches("[a-z]+");
		}
	}

	static private class IsNumeric implements ValidationStrategy {
		public boolean execute(String s) {
			return s.matches("\\d+");
		}
	}

	static private class Validator {
		private final ValidationStrategy strategy;

		public Validator(ValidationStrategy v) {
			this.strategy = v;
		}

		public boolean validate(String s) {
			return strategy.execute(s);
		}
	}
}
