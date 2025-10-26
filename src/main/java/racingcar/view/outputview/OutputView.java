package racingcar.view.outputview;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public void printMessage() {
        System.out.println("실행 결과");
    }

    public void printCarsDistance(Cars cars) {
        cars.printCars().forEach(System.out::println);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printWinner(List<Car> winnerList) {
        System.out.println("최종 우승자 : " + winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
    }
}
