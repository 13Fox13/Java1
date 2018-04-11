package T.SystemTestJava;

import java.util.Arrays;

public class TestCalculatorSubsequence {
    public static void main(String[] args) {
        // Task 1. Calculator
        Calculator c = new CalculatorImpl();
        System.out.println(c.evaluate("(1+38)*4-5")); // Результат: 151
        c = new CalculatorImpl();
        System.out.println(c.evaluate("7*6/2+8")); // Результат: 29
        c = new CalculatorImpl();
        System.out.println(c.evaluate("-12)1//(")); // Результат: null
        System.out.println();

        // Task 3. Subsequence
        Subsequence s = new SubsequenceImpl();
        boolean b = s.find(Arrays.asList("A", "B", "C", "D"),
                Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D"));
        System.out.println(b); // Результат: true
    }
}

