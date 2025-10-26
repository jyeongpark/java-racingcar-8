package racingcar.model;

public class Car {
    private static final int MAX_NAME_SIZE = 5;
    private static final String BLANK_REGEX = ".*\\s+.*";
    private static final int MOVEMENT_CONDITION = 4;

    private final String name;
    private int distance;

    public Car(String value) {
        validateCar(value);
        this.name = value;
        this.distance = 0;
    }

    public void moveCar(int movement) {
        if (movement >= MOVEMENT_CONDITION) {
            this.distance += 1;
        }
    }

    private void validateCar(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없어요.");
        }

        if (value.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이상일 수 없어요.");
        }

        if (value.matches(BLANK_REGEX)) {
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

