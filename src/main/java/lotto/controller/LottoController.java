package lotto.controller;

import lotto.service.Calculator;
import lotto.service.LottoService;
import lotto.utils.ErrorConstants;
import lotto.utils.RandomNumber;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    Calculator calculator;
    LottoService lottoService;

    private int money;
    private double profit;

    public LottoController(InputView inputView, OutputView outputView, Calculator calculator, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
        this.lottoService = lottoService;
    }

    public void run() {
        initialize();
        execute();
        printResult();
    }

    private void initialize() {
        this.money = inputView.insertMoney();
        outputView.newLine();
        List<List<Integer>> lottos = RandomNumber.pickNumbers(calculator.calculateSheet(money));
        outputView.printLotto(lottos);
        outputView.newLine();
        List<Integer> numbers = inputView.selectNumber();
        outputView.newLine();
        int bonusNumber = readBonusNumber(numbers);
        outputView.newLine();
        lottoService.init(lottos, numbers, bonusNumber);
    }

    private void execute() {
        lottoService.matchNumber();
        profit = calculator.calculateProfit(money, lottoService.getResult());
    }

    private void printResult() {
        outputView.printStats(lottoService.getResult(), profit);
    }

    private int readBonusNumber(List<Integer> numbers) {
        int bn;
        while (true) {
            try {
                bn = Validator.checkDistinctBonusNumber(inputView.selectBonusNumber(), numbers);
                return bn;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INPUT_ERROR.getMessage());
            }
        }
    }
}
