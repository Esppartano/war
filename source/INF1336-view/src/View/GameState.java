package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update();
        }
    }

    void changeTerritoryState(String name, int armies, Color color) {

    }
    public void update() {
        notifyObservers();
    }


}
