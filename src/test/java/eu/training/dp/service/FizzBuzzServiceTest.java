package eu.training.dp.service;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @Test
    public void testFizzBuzzAlgorithmUntil100() {
        String fizzBuzzResult = fizzBuzzService.getFizzBuzzFor(100);

        Assert.assertEquals(EXPECTED_STRING_UNTIL_100, fizzBuzzResult);
    }

    @Test
    public void testFizzBuzzAlgorithmUntil50() {
        String fizzBuzzResult = fizzBuzzService.getFizzBuzzFor(50);

        Assert.assertEquals(EXPECTED_STRING_UNTIL_50, fizzBuzzResult);
    }

    @Test
    public void testFizzBuzzAlgorithmUntil30() {
        String fizzBuzzResult = fizzBuzzService.getFizzBuzzFor(30);

        Assert.assertEquals(EXPECTED_STRING_UNTIL_30, fizzBuzzResult);
    }

    @Test
    public void testFizzBuzzAlgorithmUntil10() {
        String fizzBuzzResult = fizzBuzzService.getFizzBuzzFor(10);

        Assert.assertEquals(EXPECTED_STRING_UNTIL_10, fizzBuzzResult);
    }

//    @Test
    public void testFizzBuzzWoofAlgorithmUntil100() {
        String fizzBuzzResult = fizzBuzzService.getFizzBuzzFor(100);

        Assert.assertEquals(EXPECTED_FIZZBUZZWOOF_STRING_UNTIL_100, fizzBuzzResult);
    }


    private static final String EXPECTED_STRING_UNTIL_100 = "1, " +
            "2, " +
            "Fizz, " +
            "4, " +
            "Buzz, " +
            "Fizz, " +
            "7, " +
            "8, " +
            "Fizz, " +
            "Buzz, " +
            "11, " +
            "Fizz, " +
            "13, " +
            "14, " +
            "FizzBuzz, " +
            "16, " +
            "17, " +
            "Fizz, " +
            "19, " +
            "Buzz, " +
            "Fizz, " +
            "22, " +
            "23, " +
            "Fizz, " +
            "Buzz, " +
            "26, " +
            "Fizz, " +
            "28, " +
            "29, " +
            "FizzBuzz, " +
            "31, " +
            "32, " +
            "Fizz, " +
            "34, " +
            "Buzz, " +
            "Fizz, " +
            "37, " +
            "38, " +
            "Fizz, " +
            "Buzz, " +
            "41, " +
            "Fizz, " +
            "43, " +
            "44, " +
            "FizzBuzz, " +
            "46, " +
            "47, " +
            "Fizz, " +
            "49, " +
            "Buzz, " +
            "Fizz, " +
            "52, " +
            "53, " +
            "Fizz, " +
            "Buzz, " +
            "56, " +
            "Fizz, " +
            "58, " +
            "59, " +
            "FizzBuzz, " +
            "61, " +
            "62, " +
            "Fizz, " +
            "64, " +
            "Buzz, " +
            "Fizz, " +
            "67, " +
            "68, " +
            "Fizz, " +
            "Buzz, " +
            "71, " +
            "Fizz, " +
            "73, " +
            "74, " +
            "FizzBuzz, " +
            "76, " +
            "77, " +
            "Fizz, " +
            "79, " +
            "Buzz, " +
            "Fizz, " +
            "82, " +
            "83, " +
            "Fizz, " +
            "Buzz, " +
            "86, " +
            "Fizz, " +
            "88, " +
            "89, " +
            "FizzBuzz, " +
            "91, " +
            "92, " +
            "Fizz, " +
            "94, " +
            "Buzz, " +
            "Fizz, " +
            "97, " +
            "98, " +
            "Fizz, " +
            "Buzz, ";

    private static final String EXPECTED_STRING_UNTIL_50 = "1, " +
            "2, " +
            "Fizz, " +
            "4, " +
            "Buzz, " +
            "Fizz, " +
            "7, " +
            "8, " +
            "Fizz, " +
            "Buzz, " +
            "11, " +
            "Fizz, " +
            "13, " +
            "14, " +
            "FizzBuzz, " +
            "16, " +
            "17, " +
            "Fizz, " +
            "19, " +
            "Buzz, " +
            "Fizz, " +
            "22, " +
            "23, " +
            "Fizz, " +
            "Buzz, " +
            "26, " +
            "Fizz, " +
            "28, " +
            "29, " +
            "FizzBuzz, " +
            "31, " +
            "32, " +
            "Fizz, " +
            "34, " +
            "Buzz, " +
            "Fizz, " +
            "37, " +
            "38, " +
            "Fizz, " +
            "Buzz, " +
            "41, " +
            "Fizz, " +
            "43, " +
            "44, " +
            "FizzBuzz, " +
            "46, " +
            "47, " +
            "Fizz, " +
            "49, " +
            "Buzz, ";

    private static final String EXPECTED_STRING_UNTIL_30 = "1, " +
            "2, " +
            "Fizz, " +
            "4, " +
            "Buzz, " +
            "Fizz, " +
            "7, " +
            "8, " +
            "Fizz, " +
            "Buzz, " +
            "11, " +
            "Fizz, " +
            "13, " +
            "14, " +
            "FizzBuzz, " +
            "16, " +
            "17, " +
            "Fizz, " +
            "19, " +
            "Buzz, " +
            "Fizz, " +
            "22, " +
            "23, " +
            "Fizz, " +
            "Buzz, " +
            "26, " +
            "Fizz, " +
            "28, " +
            "29, " +
            "FizzBuzz, ";

    private static final String EXPECTED_STRING_UNTIL_10 = "1, " +
            "2, " +
            "Fizz, " +
            "4, " +
            "Buzz, " +
            "Fizz, " +
            "7, " +
            "8, " +
            "Fizz, " +
            "Buzz, ";

    private static final String EXPECTED_FIZZBUZZWOOF_STRING_UNTIL_100 = "1, 2, Fizz, 4, Buzz, Fizz, Woof, 8, Fizz, Buzz, 11, Fizz, 13, Woof, FizzBuzz, 16, 17, Fizz, 19, Buzz, FizzWoof, 22, 23, Fizz, Buzz, 26, Fizz, Woof, 29, FizzBuzz, 31, 32, Fizz, 34, BuzzWoof, Fizz, 37, 38, Fizz, Buzz, 41, FizzWoof, 43, 44, FizzBuzz, 46, 47, Fizz, Woof, Buzz, Fizz, 52, 53, Fizz, Buzz, Woof, Fizz, 58, 59, FizzBuzz, 61, 62, FizzWoof, 64, Buzz, Fizz, 67, 68, Fizz, BuzzWoof, 71, Fizz, 73, 74, FizzBuzz, 76, Woof, Fizz, 79, Buzz, Fizz, 82, 83, FizzWoof, Buzz, 86, Fizz, 88, 89, FizzBuzz, Woof, 92, Fizz, 94, Buzz, Fizz, 97, Woof, Fizz, Buzz, ";
}