package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoView;

import java.util.List;

public class User {

  private final LottoView lottoView = new LottoView();

    UserLotto userLotto = new UserLotto();

    public List<Integer> insertLottoNumbers() {

        lottoView.askWinningLottoNumbers();

        String userNumber = Console.readLine();

        List<Integer> intNumberList = userLotto.validateInputNumbers(userNumber);

        return intNumberList;
    }

    public List<Integer> insertLuckyNumber() {
        lottoView.askLuckyLottoNumber();

        String insertLuckyNumber = Console.readLine();

      List<Integer> luckyNumberList = userLotto.validateInputNumber(insertLuckyNumber);

        return luckyNumberList;
    }
}
