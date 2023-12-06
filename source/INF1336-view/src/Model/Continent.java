package Model;

import java.util.ArrayList;
import java.util.Hashtable;

class Continent{
    private String name;
    private Hashtable<String, Territory> territories = new Hashtable<String, Territory>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable<String, Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(Hashtable<String, Territory> territories) {
        this.territories = territories;
    }

    public boolean isConquered(Player player){
        for (Territory territory : this.territories.values()) {
            if(territory.getOwner() != player){
                return false;
            }
        }
        return true;
    }


    protected void addTerritory(Territory territory){
        this.territories.put(territory.getName(), territory);
        territory.setContinent(this);
    }


    public Continent(String name){
        this.name = name;
       
    }

}