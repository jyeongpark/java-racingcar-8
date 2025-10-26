package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputValidator;

public class CarInputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름은 공백일 수 없다.")
    void isNameEmpty(String name) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"j y", " jy", "jy "})
    @DisplayName("자동차 이름에 공백이 있을 수 없다.")
    void hasNameBlank(String name) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(name));
    }

    @Test
    @DisplayName("자동차 이름은 5글자 이하여야 한다.")
    void isUnderLengthLimit() {
        String name = "jyeongpark";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(name));
    }

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void notDuplicateCarName() {
        List<String> carNames = List.of("jy", "jy");
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDuplicateCarName(carNames));
    }
}
