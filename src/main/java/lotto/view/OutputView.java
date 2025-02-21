package lotto.view;

import lotto.utils.MessageConstants;

import java.util.List;

public class OutputView {
    public void printLotto(List<List<Integer>> l) {
        System.out.println(l.size() + "개를 구매했습니다.");
        l.forEach(System.out::println);
    }

    public void printStats(int[] results, double profit) {
        System.out.println("당첨 통계\n---");
        MessageConstants[] m = MessageConstants.values();
        for (int i = 0; i < results.length; i++) {
            System.out.println(m[i].getMessage() + " - " + results[i] + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

    public void newLine() {
        System.out.println();
    }
}
