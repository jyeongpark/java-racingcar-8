package racingcar.view.outputview;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String EXECUTION_MESSAGE = "실행 결과";
    private static final String PRINT_DASH = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String OUTPUT_DELIMITER = ", ";

    public void printMessage() {
        System.out.println(EXECUTION_MESSAGE);
    }

    public void printCarsDistance(Map<String, Integer> carsCondition) {
        carsCondition.forEach((name, distance) -> {
            String movement = showMovement(name, distance);
            System.out.println(movement);
        });
    }

    public String showMovement(String name, Integer distance) {
        return String.format("%s : %s", name, distanceToDash(distance));
    }

    private String distanceToDash(Integer distance) {
        List<String> fixedList = Collections.nCopies(distance, PRINT_DASH);
        return String.join("", fixedList);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(OUTPUT_DELIMITER, winners));
    }
}
