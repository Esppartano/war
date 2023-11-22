package Model;

import java.util.ArrayList;
import java.util.Random;

class ConquerContinentObjective implements Objective {
    private String description;
    private ArrayList<Continent> continents = new ArrayList<Continent>();
    private int numberOfTerritories = 0;

    protected ConquerContinentObjective(String description, int numberOfTerritories, ArrayList<Continent> continents) {
        this.description = description;
        this.continents = continents;
        if(numberOfTerritories != 0){
            this.numberOfTerritories = numberOfTerritories;
        }
    }

    @Override
    public boolean isComplete(Player player) {
        int count = 0;
        for (Continent continent : this.continents) {
            // verify if the continent is null, that means that the player can conquer any continent
            if (continent.isConquered(player) || continent == null) {
                count++;
            }
        }
        // if the objective is to conquer a certain number of territories alongside the continents
        if(this.numberOfTerritories != 0){
            return count == this.continents.size() && player.getTerritories().size() >= this.numberOfTerritories;
        }
        return count == this.continents.size();
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}