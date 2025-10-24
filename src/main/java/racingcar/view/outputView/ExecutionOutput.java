package racingcar.view.outputView;

import racingcar.model.Cars;

public class ExecutionOutput {
    public void executionOutput() {
        System.out.println("실행 결과");
    }

    public void output(Cars cars) {
        cars.printCars().forEach(System.out::println);
    }

    public void printEnter() {
        System.out.println();
    }
}
