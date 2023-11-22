package Model;

import java.util.ArrayList;
import java.util.Random;


class TerritoryCard {
    private String name;
    private Territory territory;
    private String shape;


    public TerritoryCard(String name, Territory territory, String shape) {
        this.name = name;
        this.territory = territory;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public Territory getTerritory() {
        return territory;
    }

    public String getShape() {
        return shape;
    }
}