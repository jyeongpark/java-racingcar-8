package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Cars {
    private static final String SPLIT_REGEX = ",";

    List<Car> cars;

    public Cars(String inputValue) {
        List<String> cars = Arrays.stream(inputValue.split(SPLIT_REGEX)).toList();
        this.cars = cars.stream().map(Car::new).toList();
    }

    public Map<String, Integer> moveCars(List<Integer> movement) {
        Map<String, Integer> results = new HashMap<>();
        for (int i = 0; i < movement.size(); i++) {
            Car car = cars.get(i);
            car.moveCar(movement.get(i));
            results.putIfAbsent(car.getName(), car.getDistance());
        }

        return results;
    }

    public Integer size() {
        return cars.size();
    }

    public List<Car> getWinner() {
        Integer winnerDistance = getWinnerDistance();
        return this.cars.stream().filter(car -> Objects.equals(car.getDistance(), winnerDistance)).toList();
    }

    private Integer getWinnerDistance() {
        Car maxDistanceCar = Collections.max(cars, Comparator.comparing(Car::getDistance));
        return maxDistanceCar.getDistance();
    }
}
