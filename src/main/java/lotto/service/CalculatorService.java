package lotto.service;

import lotto.model.Lotto;
import lotto.view.LottoView;

import java.util.*;

public class CalculatorService {
    public Map<Integer, Integer>  compareLottos(Lotto lotto, List<Integer> intNumberList) {

        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(3,4,5,6));

        List<Integer> accordNumbers = new ArrayList<>();

        for (int lottoIndex = 0; lottoIndex < lotto.numbers.size(); lottoIndex++) {

            List<Integer> commonValues = new ArrayList<>(lotto.numbers.get(lottoIndex));

            commonValues.retainAll(intNumberList);

//            System.out.println("갯수 확인 : " + commonValues);

            accordNumbers.add(commonValues.size());

        }

        Map<Integer, Integer> winningList = countOccurrences(accordNumbers, winningNumbers);

        return winningList;
    }

    //3, 4, 5, 6개 중 몇개씩 맞았는지 모으기
    private Map<Integer, Integer> countOccurrences(List<Integer> howManyAccordNumber, List<Integer> winningNumbers) {
        Map<Integer, Integer> winningList = new HashMap<>();
        for (Integer target : winningNumbers) {
            int count = 0;
            for (Integer number : howManyAccordNumber) {
                if (number.equals(target)) {
                    count++;
                }
            }
            winningList.put(target, count);
        }
        return winningList;
    }

    //모은거로 몇개 당첨됐는지 계산하고  출력하기
    public void countWinningMoney(Map<Integer, Integer> winningList) {

        LottoView lottoView = new LottoView();

        int winningSum = 3;

        lottoView.speakStartLottoStatistics();

        Map<Integer, Integer> announceWinningList = new HashMap<>();

        for (int index = 0; index < winningList.size(); index++) {

            int realIndex = index + winningSum;

            if (winningList.get(index + winningSum) != 0) {
                announceWinningList.put(realIndex, winningList.get(realIndex));
                lottoView.speakLottoStatistics(announceWinningList);
            }
        }
    }

    public void earningRate(Map<Integer, Integer> winningList) { // 수익률 계산
        System.out.println(winningList);
         int intUserNumber = 0;
        LottoView lottoView = new LottoView();

        int earnings = 0;
        int winningSum = 3;
        double rate = 0;

        for (int index = 0; index < winningList.size() + winningSum; index++) {
            if (index + winningSum == 3 && winningList.get(index + winningSum) != 0) {
                earnings += winningList.get(index + winningSum) * 5000;
            }
            if (index + winningSum == 4 && winningList.get(index + winningSum) != 0) {
                earnings += winningList.get(index + winningSum) * 50000;
            }
            if (index + winningSum == 5 && winningList.get(index + winningSum) != 0) {
                earnings += winningList.get(index + winningSum) * 1500000;
            }
            if (index + winningSum == 6 && winningList.get(index + winningSum) != 0) {
                earnings += winningList.get(index + winningSum) * 2000000000;
            }
        }

        rate =  ((double)earnings/ (double)intUserNumber)*100;

        lottoView.SpeakEarningRate(rate);
    }
}
