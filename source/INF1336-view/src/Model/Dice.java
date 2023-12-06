package Model;

class Dice {
    private int value;

    Dice() {
        this.value = 0;
    }

    int getValue() {
        return value;
    }

    void rollInternal() {
        this.value = (int) (Math.random() * 6) + 1;
    }

    int roll() {
        rollInternal();
        return this.value;
    }

}
