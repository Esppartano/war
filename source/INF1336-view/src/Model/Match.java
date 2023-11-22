package Model;

/* class that implements a singleton and facade pattern to manage the game */

public class Match {
    public static Match instance = null;
    private Game game;

    private Match() {
        game = new Game();
    }

    public static Match getInstance() {
        if (instance == null) {
            instance = new Match();
        }
        return instance;
    }

    public void generateListTerritoriesAndObjectives() {
        game.generateListTerritoriesAndObjectives();
    }

    public void generateListTerritoryCards() {
        game.generateListTerritoryCards();
    }

    public void addPlayer(String color, String name) {
        game.addPlayer(new Player(name, color, game.getPlayers().size() + 1));
    }

    public void randomPlayerOrder() {
        game.randomPlayerOrder();
    }

    public void shuffleObjectives() {
        game.shuffleObjectives();
    }

    public void drawObjectives() {
        game.drawObjectives();
    }

    public void shuffleCards() {
        game.shuffleCards();
    }
}