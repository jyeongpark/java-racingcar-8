package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputValidator;

public class AttemptInputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력값이 비어있거나 공백일 경우 예외를 던진다.")
    void throwsException_whenInputIsBlank(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1번", "-", "a", "4.5", "1a"})
    @DisplayName("입력값이 숫자가 아닐 경우 예외를 던진다.")
    void throwsException_whenInputIsNotNumeric(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "999"})
    @DisplayName("입력값이 숫자일 경우 예외를 던지지 않는다.")
    void doesNotThrow_whenInputIsValidNumber(String input) {
        assertThatCode(() -> InputValidator.validateNumber(input))
                .doesNotThrowAnyException();
    }
}
