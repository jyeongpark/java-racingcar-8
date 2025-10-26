package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomMovement;
import racingcar.view.inputview.AttemptInputView;
import racingcar.view.inputview.CarInputView;
import racingcar.view.outputview.ExecutionOutput;
import racingcar.view.outputview.WinnerOutput;

public class RacingCarController {
    public void startRace() {
        String inputValue = CarInputView.inputCarNames();
        Cars cars = new Cars(inputValue);
        Integer attemptValue = AttemptInputView.attemptInput();
        ExecutionOutput executionOutput = new ExecutionOutput();
        tried(cars, attemptValue, executionOutput);
        List<Car> winner = cars.getWinner();
        WinnerOutput winnerOutput = new WinnerOutput();
        winnerOutput.printWinner(winner);
    }

    private void tried(Cars cars, Integer attemptValue, ExecutionOutput executionOutput) {
        executionOutput.printMessage();
        for (int i = 0; i < attemptValue; i++) {
            List<Boolean> randoms = RandomMovement.getRandoms(cars.size());
            cars.moveCars(randoms);
            executionOutput.output(cars);
            executionOutput.printEnter();
        }
    }
}
