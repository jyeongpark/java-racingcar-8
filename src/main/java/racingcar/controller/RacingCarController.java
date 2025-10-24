package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomMovement;
import racingcar.view.inputView.AttemptInputView;
import racingcar.view.inputView.CarInputView;
import racingcar.view.outputView.ExecutionOutput;
import racingcar.view.outputView.WinnerOutput;

public class RacingCarController {
    public void startRace() {
        String inputValue = CarInputView.input();
        Cars cars = new Cars(inputValue);
        Integer attemptValue = AttemptInputView.attemptInput();
        ExecutionOutput executionOutput = new ExecutionOutput();
        tried(cars, attemptValue, executionOutput);
        List<Car> winner = cars.getWinner();
        WinnerOutput winnerOutput = new WinnerOutput();
        winnerOutput.winnerOutput(winner);
    }

    private void tried(Cars cars, Integer attemptValue, ExecutionOutput executionOutput) {
        executionOutput.executionOutput();
        for (int i = 0; i < attemptValue; i++) {
            List<Boolean> randoms = RandomMovement.getRandoms(cars.size());
            cars.moveCars(randoms);
            executionOutput.output(cars);
            executionOutput.printEnter();
        }
    }
}
