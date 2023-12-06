package Model;

import java.awt.*;
import java.util.ArrayList;

class Player {
    protected String name;
    protected ArrayList<Territory> owned = new ArrayList<Territory>();
    protected String color;
    protected int order;
    protected Objective objective;

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Territory> getOwned() {
        return owned;
    }

    public void setOwned(ArrayList<Territory> owned) {
        this.owned = owned;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    protected boolean isAlive(){
        return this.owned.size() > 0;
    }

    protected ArrayList<Territory> getTerritories() {
    	return owned;
    }
    
    protected Player(String name, Color color) {
        this.name = name;
        this.color = String.valueOf(color);
    }
    
    protected String getName() {
    	return this.name;
    }

}
