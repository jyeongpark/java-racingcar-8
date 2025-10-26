package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomMovement {
    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;

    public static List<Integer> generateNumbers(int carSize) {
        return IntStream.range(0, carSize)
                .mapToObj(i -> generateRandomNumber())
                .toList();
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
