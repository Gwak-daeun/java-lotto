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

    public int insertMoney() {

        int intUserNumber = 0;

        lottoView.askMoney();

        String strUserNumber = Console.readLine();

        //문자열 돈을 숫자 돈으로 바꾸기
        intUserNumber = Integer.parseInt(strUserNumber);

        int restMoney = intUserNumber % 1000;

        int cutMoney = intUserNumber / 1000;

        try {
            if (restMoney != 0) {
                throw new IllegalArgumentException("1000원 단위의 돈을 입력하세요.");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            System.exit(0); // 나중에 return으로 바꿔야
        }

        return cutMoney;
    }
}
