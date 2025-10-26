package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomMovement;
import racingcar.view.inputview.AttemptInputView;
import racingcar.view.inputview.CarInputView;
import racingcar.view.outputview.OutputView;

public class RacingCarController {
    public void startRace() {
        List<String> carNames = CarInputView.inputCarNames();
        List<Car> cars = namesToCars(carNames);
        Cars racingCars = new Cars(cars);
        Integer attemptValue = AttemptInputView.attemptInput();
        OutputView output = new OutputView();
        executeRound(racingCars, attemptValue, output);
        List<String> winners = racingCars.findWinners();
        output.printWinner(winners);
    }

    private List<Car> namesToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
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
