package lotto.controller;

import lotto.service.CalculatorService;
import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.*;

public class LottoController {
    public void mainController() {

        LottoService lottoService = new LottoService();

        CalculatorService calculatorService = new CalculatorService();

        //유저 입력으로 유저 로또 리스트 완성
        List<Integer> intNumberList = lottoService.makeUserLottos();

        Lotto lotto = lottoService.makeRandomLottos();

        //유저 로또랑 컴퓨터 로또 비교해서 몇개가 같은지 리스트에 담기
        Map<Integer, Integer> winningList =  calculatorService.compareLottos(lotto, intNumberList);

        calculatorService.countWinningMoney(winningList);

        calculatorService.earningRate(winningList);

    }

}
