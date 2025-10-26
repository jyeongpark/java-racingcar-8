package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.InputValidator;

public class CarInputView {
    private static final String SPLIT_REGEX = ",";

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String value = Console.readLine();
        List<String> carsName = splitCarsName(value);

        InputValidator.validateDuplicateCarName(carsName);
        carsName.forEach(InputValidator::validateCarName);
        return carsName;
    }

    private static List<String> splitCarsName(String inputValue) {
        return Arrays.stream(inputValue.split(SPLIT_REGEX)).toList();
    }
}
