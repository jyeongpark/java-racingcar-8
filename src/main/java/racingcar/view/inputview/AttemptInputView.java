package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

public class AttemptInputView {
    public static Integer attemptInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String value = Console.readLine();
        InputValidator.validateNumber(value);
        return Integer.parseInt(value);
    }
}
