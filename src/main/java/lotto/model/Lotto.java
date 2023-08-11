package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Scanner;

public class Lotto {
    public List<List<Integer>> numbers;

    public Lotto(List<List <Integer>> numbers, int cutMoney) {
        makeLottoNumbers(numbers, cutMoney);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] : 로또는 6자리의 숫자여야 해요.");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }

    }

    private List<List <Integer>> makeLottoNumbers(List<List <Integer>> numbers, int cutMoney) {

        while (numbers.size() != cutMoney) {
            numbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        return numbers;
    }

}
