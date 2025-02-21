package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoData;

import java.util.List;

public class LottoService {
    private LottoData lottoData;

    public void init(List<List<Integer>> l, List<Integer> n, int bn) {
        this.lottoData = LottoData.init(l, n, bn);
    }

    public int[] getResult() {
        return lottoData.getResult();
    }

    public void matchNumber() {
        List<Integer> intersectionList;
        for (Lotto l : lottoData.getLottos()) {
            intersectionList = l.getNumbers().stream().filter(n -> lottoData.getNumbers().contains(n)).toList();
            if (intersectionList.size() < 3) continue;
            if (intersectionList.size() == 6 && !isContainBonus(intersectionList)) {
                lottoData.addPrize(4);
                continue;
            }
            lottoData.addPrize(intersectionList.size() - 3);
        }
    }

    private boolean isContainBonus(List<Integer> l) {
        return l.contains(lottoData.getBonusNumber());
    }
}
