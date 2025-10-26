package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomMovement;
import racingcar.view.inputview.AttemptInputView;
import racingcar.view.inputview.CarInputView;
import racingcar.view.outputview.OutputView;

public class RacingCarController {
    public void startRace() {
        String inputValue = CarInputView.inputCarNames();
        Cars cars = new Cars(inputValue);
        Integer attemptValue = AttemptInputView.attemptInput();
        ExecutionOutput executionOutput = new ExecutionOutput();
        tried(cars, attemptValue, executionOutput);
        OutputView output = new OutputView();
        tried(cars, attemptValue, output);
        List<Car> winner = cars.getWinner();
        output.printWinner(winner);
    }

    private void tried(Cars cars, Integer attemptValue, OutputView output) {
        output.printMessage();
        for (int i = 0; i < attemptValue; i++) {
            List<Boolean> randoms = RandomMovement.getRandoms(cars.size());
            cars.moveCars(randoms);
            executionOutput.output(cars);
            executionOutput.printEnter();
            output.printCarsDistance(cars);
            output.printEnter();
        }
    }
}
