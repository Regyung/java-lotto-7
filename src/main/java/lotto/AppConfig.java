package lotto;

import lotto.controller.LottoController;
import lotto.service.Calculator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public Calculator calculator() {
        return new Calculator();
    }

    public LottoService lottoService() {
        return new LottoService();
    }

    public LottoController lottoController() {
        return new LottoController(
                inputView(),
                outputView(),
                calculator(),
                lottoService()
        );
    }
}
