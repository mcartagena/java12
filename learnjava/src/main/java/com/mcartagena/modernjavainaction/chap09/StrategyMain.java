package com.mcartagena.modernjavainaction.chap09;

import lombok.AllArgsConstructor;

public class StrategyMain {

    public static void main(String[] args) {
        // old school
        Validator validatingNumeric = new Validator(new IsNumeric());
        System.out.println("Validating is Numeric: aaaa " + validatingNumeric.validate("aaaa"));
        Validator validatingLowerCases = new Validator(new IsAllLowerCase());
        System.out.println("Validating is all lower cases: bbbb " + validatingLowerCases.validate("bbbbb"));

        // with lambdas
        Validator validatingNumericWithLambda = new Validator((String s) -> s.matches("\\d+"));
        System.out.println("Validating is Numeric With Lambda: aaaa " + validatingNumericWithLambda.validate("aaaa"));
        Validator validatingLowerCasesWithLambda = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println("Validating is all lower cases with lambda: bbbb " + validatingLowerCasesWithLambda.validate("bbbb"));

        // my own example
        Validator validatingUpperCases = new Validator((String s) -> s.matches("[A-Z]+"));
        System.out.println("Validating is all lower cases with lambda: AbAb " + validatingUpperCases.validate("AbAb"));

    }

    interface ValidationStrategy {
        boolean execute(String s);
    }

    private static class IsAllLowerCase implements ValidationStrategy {

        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    private static class IsNumeric implements ValidationStrategy {

        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    @AllArgsConstructor
    private static class Validator {
        private final ValidationStrategy strategy;

        public boolean validate(String s){
            return strategy.execute(s);
        }

    }

}
