package lotto.view;

import java.util.List;
import java.util.Map;

public class LottoView {

    public void askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void speakHowManyLotto(int lottoStock) {
        System.out.println(lottoStock + " 개를 구매했습니다.");
    }

    public void askWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askLuckyLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void speakStartLottoStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void speakLottoStatistics(Map<Integer, Integer> announceWinningList) {
        System.out.println("위닝리스트: " + announceWinningList);
        int winningSum = 3;
        for (int index = 0; index < announceWinningList.size(); index++) {
            int realIndex = index + winningSum;
            if (realIndex == 3){
                betweenWords("개 일치 (5000원) - ", realIndex, announceWinningList);
            }
            if (realIndex == 4) {
                betweenWords("개 일치 (50,000원) - ", realIndex, announceWinningList);
            }
            if (realIndex == 5) {
                betweenWords("개 일치 (1,500,000원) - ", realIndex, announceWinningList);
            }
            if (realIndex == 6) {
                betweenWords("개 일치 (2,000,000,000원) - ", realIndex, announceWinningList);
            }
        }
    }

    public void betweenWords(String moneyWord, int realIndex, Map<Integer, Integer> announceWinningList) {
        System.out.println(realIndex + moneyWord + announceWinningList.get(realIndex) + " 개");
    }

    public void SpeakEarningRate(double rate) {

//        double roundedRate = Math.round(rate);

        String roundedRate = String.format("%.0f", rate);

        System.out.println("총 수익률은 " + roundedRate + "% 입니다.");
    }
}
