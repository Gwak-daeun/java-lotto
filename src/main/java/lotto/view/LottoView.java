package lotto.view;

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

    public void speakLottoStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
