package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static int checkMoney(String input) {
        try {
            double money = Integer.parseInt(input);
            if (!isInteger(money/1000)) { throw new IllegalArgumentException(); }
            return (int) money;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_ERROR.getMessage());
        }
    }

    public static List<Integer> checkPrizeNumbers(String input) {
        try {
            List<Integer> n = Arrays.stream(input.trim().split(","))
                    .mapToInt(Integer::parseInt)
                    .filter(Validator::isUnder45)
                    .distinct()
                    .boxed()
                    .toList();
            if (n.size() < 6) { throw new IllegalArgumentException(); }
            return n;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_ERROR.getMessage());
        }
    }

    public static int checkBonusNumber(String input) {
        try {
            int bn = Integer.parseInt(input);
            if (!isUnder45(bn)) { throw new IllegalArgumentException(); }
            return bn;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_ERROR.getMessage());
        }
    }

    public static int checkDistinctBonusNumber(int input, List<Integer> numbers) {
        try {
            if (numbers.contains(input)) { throw new IllegalArgumentException(); }
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_ERROR.getMessage());
        }
    }

    private static boolean isUnder45(int number) {
        return number < 46 && number > 0;
    }

    private static boolean isInteger(double number) {
        return number % 1 == 0.0;
    }
}
