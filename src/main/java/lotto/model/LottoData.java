package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoData {
    private final List<Lotto> lottos;
    private final List<Integer> numbers;
    private int bonusNumber;
    private final int[] result;

    private LottoData() {
        lottos = new ArrayList<>();
        numbers = new ArrayList<>();
        bonusNumber = 0;
        result = new int[5];
    }

    public static LottoData init(List<List<Integer>> l, List<Integer> n, int bn) {
        LottoData data = new LottoData();
        data.lottos.addAll(l.stream().map(Lotto::new).toList());
        data.numbers.addAll(n);
        data.bonusNumber = bn;
        data.numbers.add(data.bonusNumber);
        return data;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int[] getResult() {
        return result;
    }

    public void addPrize(int number) {
        result[number]++;
    }
}
