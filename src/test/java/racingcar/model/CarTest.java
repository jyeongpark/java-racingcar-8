package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차는 4 이상의 숫자가 주어지면 이동한다.")
    void moveCar_WhenNumberIsGreaterOrEqualThan4() {
        // given
        int number = 4;
        Car car = new Car("jy");

        // when
        car.moveCar(number);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void notMoveCar_WhenNumberIsLessThan4() {
        // given
        int number = 3;
        Car car = new Car("jy");

        // when
        car.moveCar(number);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
