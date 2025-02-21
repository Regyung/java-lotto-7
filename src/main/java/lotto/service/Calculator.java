package lotto.service;

import lotto.utils.PrizeConstants;

public class Calculator {
    public int calculateSheet(int money) {
        return money/1000;
    }

    public double calculateProfit(int money, int[] result) {
        PrizeConstants[] p = PrizeConstants.values();
        double sum = 0;
        for (int i = 0; i < result.length; i++)
            sum += result[i] * p[i].getPrize();
        return Math.round(sum/(double)money*100 * 100) / 100.0;
    }
}
