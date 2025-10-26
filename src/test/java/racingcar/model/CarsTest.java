package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    @DisplayName("문자열로 List<Car> 생성")
    void setUp() {
        String carsName = "pobi,woni,jy";
        cars = new Cars(carsName);
    }

    @Test
    @DisplayName("랜덤한 숫자를 인자로 받아 차를 이동시킨 후 Map으로 반환한다.")
    void moveCars_returnNameDistanceMap() {
        // given
        List<Integer> randoms = List.of(4, 3, 9);

        // when
        Map<String, Integer> result = cars.moveCars(randoms);

        // then
        assertThat(result)
                .containsEntry("pobi", 1)
                .containsEntry("woni", 0)
                .containsEntry("jy", 1);
    }

    @Test
    @DisplayName("자동차 중 이동 거리가 제일 큰 우승자를 가려낸다.")
    void findWinnersNames() {
        // given
        List<Integer> randoms = List.of(4, 3, 9);
        List<Integer> randoms2 = List.of(3, 3, 4);

        // when
        cars.moveCars(randoms);
        cars.moveCars(randoms2);

        // then
        List<String> winners = cars.findWinners();
        assertThat(winners).contains("jy");
    }
}
