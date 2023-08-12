package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.UserLotto;
import lotto.view.LottoView;

import java.util.*;

public class Application {

    static int intUserNumber = 0;
    private static List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(3,4,5,6));

    private static int earning = 0;
    public static void main(String[] args) {

        Application application = new Application();

        UserLotto userLotto = new UserLotto();

        User user = new User();

        LottoView lottoView = new LottoView();

        List<Integer> intNumberList = user.insertLottoNumbers();

        List<Integer> luckyNumberList = user.insertLuckyNumber();

        List<List <Integer>> lottoList = new ArrayList<>(6);

        intNumberList.add(luckyNumberList.get(0)); // 유저의 로또 번호 7자리

        /////////////유저 입력으로 유저 로또 리스트 완성


        /////돈 투입해서 몇개의 배열을 만들지//////
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

        //입력한 돈 몫으로 로또 몫만큼 생성
        Lotto lotto = new Lotto(lottoList, cutMoney);

//        System.out.println(lotto.numbers);

        //유저 로또랑 컴퓨터 로또 비교해서 몇개가 같은지 리스트에 담기
        List<Integer> howManyAccordNumber = new ArrayList<>();

//        Map<Integer, Integer> howManyAccordNumber = countOccurrences(intNumberList, chosenNumbers);
//
//        for (Map.Entry<Integer, Integer> entry : howManyAccordNumber.entrySet()) {
//            System.out.println("Number " + entry.getKey() + ": " + entry.getValue() + " occurrences");
//        }

        for (int lottoIndex = 0; lottoIndex < lotto.numbers.size(); lottoIndex++) {

            List<Integer> commonValues = new ArrayList<>(lotto.numbers.get(lottoIndex));

            commonValues.retainAll(intNumberList);

//            System.out.println("갯수 확인 : " + commonValues);

            howManyAccordNumber.add(commonValues.size());

        }

        Map<Integer, Integer> winningList = countOccurrences(howManyAccordNumber, winningNumbers);


        //당첨 금액 출력
//        System.out.println("당첨 금액 주기 전 : " + winningList);

        countWinningMoney(winningList);

        earningRate(winningList);

    }

    //3, 4, 5, 6개 중 몇개씩 맞았는지 모으기
    public static Map<Integer, Integer> countOccurrences(List<Integer> howManyAccordNumber, List<Integer> winningNumbers) {
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

    //모은거로 몇개 당첨됐는지 출력하기
    public static void countWinningMoney(Map<Integer, Integer> winningList) { // 이건 view로 빠져야 하나....

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

    public static void earningRate(Map<Integer, Integer> winningList) {
        System.out.println(winningList);
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
