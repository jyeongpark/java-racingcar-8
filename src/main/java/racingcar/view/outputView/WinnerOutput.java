package racingcar.view.outputView;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class WinnerOutput {
    public void winnerOutput(List<Car> winnerList) {
        System.out.println("최종 우승자 : " + winnerList.stream()
                .map(Car::getName).collect(Collectors.joining(", ")));
    }
}
