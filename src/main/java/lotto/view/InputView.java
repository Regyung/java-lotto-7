package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ErrorConstants;
import lotto.utils.Validator;

import java.util.List;

public class InputView {
    public int insertMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return Validator.checkMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INPUT_ERROR.getMessage());
            }
        }
    }

    public List<Integer> selectNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return Validator.checkPrizeNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INPUT_ERROR.getMessage());
            }
        }
    }

    public int selectBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return Validator.checkBonusNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INPUT_ERROR.getMessage());
            }
        }
    }
}
