package racingcar.model;

public class Car {
    private static final int MOVEMENT_CONDITION = 4;

    private final String name;
    private int distance;

    public Car(String value) {
        this.name = value;
        this.distance = 0;
    }

    public void moveCar(int movement) {
        if (movement >= MOVEMENT_CONDITION) {
            this.distance += 1;
        }
    }


    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}

