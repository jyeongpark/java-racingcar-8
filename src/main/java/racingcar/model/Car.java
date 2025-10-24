package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Car {

    private final String name;
    private Integer distance;

    public Car(String value) {
        validateCar(value);
        this.name = value;
        this.distance = 0;
    }

    public void moveCar(boolean move) {
        if (move) {
            this.distance += 1;
        }
    }

    public String showMovement() {
        return String.format("%s : %s", this.name, distanceToDash());
    }

    private String distanceToDash() {
        List<String> fixedList = Collections.nCopies(this.distance, "-");
        return String.join("", fixedList);
    }


    private void validateCar(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없어요.");
        }

        if (value.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이상일 수 없어요.");
        }

        if (value.matches(".*\\s+.*")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 들어갈 수 없어요.");
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}

