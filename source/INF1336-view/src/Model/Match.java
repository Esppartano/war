package Model;

import java.awt.*;
import java.util.ArrayList;

public class Match {
    public static Match instance;
    private Game game;

    private Match() {
        this.game = new Game();
    }

    public static Match getInstance() {
        if (instance == null) {
            instance = new Match();
        }
        return instance;
    }

    public void startGame(ArrayList<Player> players){
        this.game.generateListTerritoriesAndObjectives();
        this.game.generateListTerritoryCards();
        for(Player player : players){
            this.game.addPlayer(player);
        }
        this.game.randomPlayerOrder();
        this.game.shuffleObjectives();
        this.game.shuffleCards();
        this.game.drawObjectives(); // draws the objectives and assigns them to the players
        this.game.drawCards(); // draws the cards and assigns the territories to the players
    }

    public ArrayList<Player> getPlayers(){
        return (ArrayList<Player>) this.game.getPlayers();
    }

    public ArrayList<Player> setPlayers(int numberOfPlayers, String[] names, Color[] colors){
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++){
            players.add(new Player(names[i], colors[i]));
        }
        return players;
    }

    public void attackTerritory(Territory attacker, Territory defender, int attackerDice, int defenderDice){
        this.game.attackTerritory(attacker, defender);
    }

    public void moveTroops(Territory origin, Territory destination, int troops){
        this.game.moveArmies(origin, destination, troops);
    }

    public void attackTerritoryNotRandom(Territory attacker, Territory defender, int[] attackerDice, int[] defenderDice){
        this.game.attackTerritoryNotRandom(attackerDice, defenderDice, attacker, defender);
    }


    public String saveGameState(){
        return this.game.saveGameState();
    }
}