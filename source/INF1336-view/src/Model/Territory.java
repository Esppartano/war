package Model;

import java.util.ArrayList;

public class Territory {
    protected String name;
    protected Player owner = null;
    protected Continent continent;
    protected int armies = 0;
    protected ArrayList<Territory> adjacentTerritories = new ArrayList<Territory>();


    public void addAdjacentTerritory(Territory territory) {
        if(!this.adjacentTerritories.contains(territory))
            return;

        this.adjacentTerritories.add(territory);
        territory.adjacentTerritories.add(this);
    }

    public void removeAdjacentTerritory(Territory territory) {
        if(!this.adjacentTerritories.contains(territory))
            return;

        this.adjacentTerritories.remove(territory);
        territory.adjacentTerritories.remove(this);
    }

    public void addArmies(int armies) {
        this.armies += armies;
    }

    public void removeArmies(int armies) {
        this.armies -= armies;
    }


    public boolean isAdjacent(Territory territory) {
        return this.adjacentTerritories.contains(territory);
    }

    public boolean isOwner(Player player) {
        return this.owner == player;
    }

    public boolean isOwner(String playerName) {
        return this.owner.getName() == playerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public int getArmies() {
        return armies;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }

    public ArrayList<Territory> getAdjacentTerritories() {
        return adjacentTerritories;
    }

    public void setAdjacentTerritories(ArrayList<Territory> adjacentTerritories) {
        this.adjacentTerritories = adjacentTerritories;
    }

    protected void addNeighbour(Territory territory) {
        this.adjacentTerritories.add(territory);
        territory.adjacentTerritories.add(this);
    }
    protected Territory(String name) {
        this.name = name;
    }

}
