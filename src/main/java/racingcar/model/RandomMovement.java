package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomMovement {
    public static List<Boolean> getRandoms(Integer carSize) {
        return IntStream.range(0, carSize).mapToObj(i -> getRandom()).toList();
    }

    private static boolean getRandom() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
