package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

   private List<Integer> userNumbers = new ArrayList<>();

    public List<Integer> validateInputNumbers(String userNumber) {

        String[] userNumberArr = userNumber.split(",");

        boolean isNumeric = isNumeric(userNumberArr); // 입력한 값 숫자인지 문자인지 검사

        List<Integer> intNumberList = new ArrayList<>();

        try {
            if (!isNumeric || userNumberArr[0].length() != 6) {
                throw new IllegalArgumentException("[ERROR] : 6자리 숫자를 입력해주세요.");
            }
            intNumberList = changeNumIntoList(userNumberArr);

            System.out.println(intNumberList);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            System.exit(0);
//            return intNumberList;
        }
        return intNumberList;
    }

    public List<Integer> validateInputNumber(String luckyNumber) {

        String[] luckyNumberArr = luckyNumber.split("");

        boolean isNumeric = isNumeric(luckyNumberArr);

        List<Integer> intLuckyNumList = new ArrayList<>();

        try {
            if (!isNumeric || luckyNumberArr.length != 1) {
                throw new IllegalArgumentException("[ERROR] : 1자리 숫자를 입력해주세요.");
            }

            intLuckyNumList = changeNumIntoList(luckyNumberArr);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            System.exit(0);
//            return intLuckyNumList;

        }
        return intLuckyNumList;
    }

    private static boolean isNumeric(String[] str) {
        for (String index : str) {
            try {
                Integer.parseInt(index);
            } catch (NumberFormatException e) {
                System.out.println("문자임");
                return false;
            }
        }
        System.out.println("숫자임");
        return true;
    }

    private List<Integer> changeNumIntoList(String[] userNumberArr) {

        for (String index : userNumberArr) {
            for (int i = 0; i < index.length(); i++) {
                int num = Character.getNumericValue(index.charAt(i));
                userNumbers.add(num);
            }
        }

        return userNumbers;
    }

}
