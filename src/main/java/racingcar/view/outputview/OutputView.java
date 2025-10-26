package racingcar.view.outputview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.Car;

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

    public void printWinner(List<Car> winnerList) {
        System.out.println(WINNER_MESSAGE + winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(OUTPUT_DELIMITER)));
    }
}
