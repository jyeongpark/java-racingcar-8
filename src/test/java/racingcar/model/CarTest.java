package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름은 공백일 수 없다.")
    void isNameEmpty(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"j y", " jy", "jy "})
    @DisplayName("자동차 이름에 공백이 있을 수 없다.")
    void hasNameBlank(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("자동차 이름은 5글자 이하여야 한다.")
    void isUnderLengthLimit() {
        String name = "jyeongpark";
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

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
