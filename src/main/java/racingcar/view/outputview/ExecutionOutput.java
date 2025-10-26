package racingcar.view.outputview;

import racingcar.model.Cars;

public class ExecutionOutput {
    public void printMessage() {
        System.out.println("실행 결과");
    }

    public void printCarsDistance(Cars cars) {
        cars.printCars().forEach(System.out::println);
    }

    public void printEnter() {
        System.out.println();
    }
}
