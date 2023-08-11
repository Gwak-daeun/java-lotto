package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.UserLotto;
import lotto.view.LottoView;

import java.util.*;

public class Application {

    private static List<Integer> chosenNumbers = new ArrayList<>(Arrays.asList(3,4,5,6));
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
        int intUserNumber = Integer.parseInt(strUserNumber);

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

        System.out.println(lotto.numbers);

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

            if (commonValues.size() >= 3) {

            }

            System.out.println("갯수 확인 : " + commonValues);

            howManyAccordNumber.add(commonValues.size());





        }

        System.out.println(howManyAccordNumber + "개 일치");


        //당첨 금액 출력
        for (int howManyIndex = 0; howManyIndex < howManyAccordNumber.size(); howManyIndex++) {

        }

    }

    public static Map<Integer, Integer> countOccurrences(List<Integer> intNumberList, List<Integer> chosenNumbers) {
        Map<Integer, Integer> howManyAccordNumber = new HashMap<>();
        for (Integer target : chosenNumbers) {
            int count = 0;
            for (Integer number : intNumberList) {
                if (number.equals(target)) {
                    count++;
                }
            }
            howManyAccordNumber.put(target, count);
        }
        return howManyAccordNumber;
    }

}
