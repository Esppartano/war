package Model;

class ConquerTerritoriesObjective implements Objective {
    private String description;
    private int numberOfTerritories;
    private int armies = 0;

    protected ConquerTerritoriesObjective(String description, int numberOfTerritories, int armies) {
        this.description = description;
        this.numberOfTerritories = numberOfTerritories;
        this.armies = armies;
    }

    @Override
    public boolean isComplete(Player player) {
        // verify if the player has the number of armies in each of the territories
        for(Territory territory : player.getTerritories()){
            if(territory.getArmies() < this.armies){
                return false;
            }
        }

        return player.getTerritories().size() >= this.numberOfTerritories;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}