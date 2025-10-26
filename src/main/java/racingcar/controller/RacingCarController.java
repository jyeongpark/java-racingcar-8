package racingcar.controller;

import java.util.List;
import java.util.Map;
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
        OutputView output = new OutputView();
        executeRound(cars, attemptValue, output);
        List<String> winners = cars.findWinners();
        output.printWinner(winners);
    }

    private void executeRound(Cars cars, Integer attemptValue, OutputView output) {
        output.printMessage();
        for (int i = 0; i < attemptValue; i++) {
            List<Integer> movements = RandomMovement.generateNumbers(cars.size());
            Map<String, Integer> carsCondition = cars.moveCars(movements);
            output.printCarsDistance(carsCondition);
            output.printEnter();
        }
    }
}
