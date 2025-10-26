package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String NUMBER_REGEX = "^-?[0-9]+$";
    private static final int MAX_NAME_SIZE = 5;
    private static final String BLANK_REGEX = ".*\\s+.*";

    private InputValidator() {
    }

    public static void validateNumber(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수 값이 비어있습니다.");
        }

        if (!value.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력해주세요.");
        }
    }

    public static void validateCarName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없어요.");
        }

        if (value.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이상일 수 없어요.");
        }

        if (value.matches(BLANK_REGEX)) {
            throw new IllegalArgumentException("자동차 이름에 공백이 들어갈 수 없어요.");
        }
    }

    public static void validateDuplicateCarName(List<String> values) {
        Set<String> unique = new HashSet<>(values);
        if (unique.size() != values.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
