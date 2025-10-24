package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String inputValue) {
        List<String> cars = Arrays.stream(inputValue.split(",")).toList();
        this.cars = cars.stream().map(Car::new).toList();
    }

    public List<String> printCars() {
        return this.cars.stream().map(Car::showMovement).toList();
    }

    public void moveCars(List<Boolean> movement) {
        for (int i = 0; i < movement.size(); i++) {
            Car car = this.cars.get(i);
            boolean shouldMove = movement.get(i);
            car.moveCar(shouldMove);
        }
    }

    public Integer size() {
        return cars.size();
    }

    public List<Car> getWinner() {
        Integer winnerDistance = getWinnerDistance();
        return this.cars.stream().filter(car -> car.getDistance() == winnerDistance).toList();
    }

    private Integer getWinnerDistance() {
        Car maxDistanceCar = Collections.max(cars, Comparator.comparing(Car::getDistance));
        return maxDistanceCar.getDistance();
    }
}
