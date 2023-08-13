package lotto.service;

import lotto.model.Lotto;
import lotto.model.User;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Integer> makeUserLottos() {
        User user = new User();

        List<Integer> intNumberList = user.insertLottoNumbers();

        List<Integer> luckyNumberList = user.insertLuckyNumber();

        intNumberList.add(luckyNumberList.get(0)); // 유저의 로또 번호 7자리

        return intNumberList;
    }

    public Lotto makeRandomLottos() {

        User user = new User();

        List<List <Integer>> lottoList = new ArrayList<>();

        //돈 얼마 투입할지 묻기
        int cutMoney =  user.insertMoney();

        //입력한 돈 몫으로 로또 몫만큼 생성
        Lotto lotto = new Lotto(lottoList, cutMoney);

        return lotto;
    }

}
