package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;

public class AttemptInputView {
    public static Integer attemptInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String value = Console.readLine();
        validateAttemptInput(value);
        return Integer.parseInt(value);
    }

    private static void validateAttemptInput(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("값이 비어있습니다.");
        }

        if (!value.matches("^-?[0-9]+$")) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력해주세요.");
        }
    }
}
