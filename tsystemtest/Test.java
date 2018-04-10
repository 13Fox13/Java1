package tsystemtest;

public class Test {
    public static void main(String[] args) {
        // Task 1. Calculator
        tsystemtest.Calculator c = new tsystemtest.CalculatorImpl();
        System.out.println(c.evaluate("(1+38)*4-5")); // Result: 151
        c = new tsystemtest.CalculatorImpl();
        System.out.println(c.evaluate("7*6/2+8")); // Result: 29
        c = new tsystemtest.CalculatorImpl();
        System.out.println(c.evaluate("-12)1//(")); // Result: null
        System.out.println();

    }
}
