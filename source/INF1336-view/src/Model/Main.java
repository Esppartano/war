package Model;

// temporary file for testing

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.generateListTerritoriesAndObjectives();
        game.generateListTerritoryCards();
        System.out.println(game.getCards().size());
        System.out.println(game.getTerritories().size());
        System.out.println(game.getTerritories().get(0).getName());
        System.out.println(game.getTerritories().get(0).getContinent().getName());
        // checking if the territories are adjacent
        System.out.println(game.getTerritories().get(0).isAdjacent(game.getTerritories().get(1)));
        System.out.println(game.getTerritories().get(0).isAdjacent(game.getTerritories().get(2)));

        // getting territory by name and printing its adjacent territories
        System.out.println(game.getTerritoryByName("Brasil").getName());
        for(Territory territory : game.getTerritoryByName("Brasil").getAdjacentTerritories()){
            System.out.println(territory.getName());
        }

        // adding 3 players
        Player p1 = new Player("Player 1", "Vermelho", 1);
        game.addPlayer(p1);
        Player p2 = new Player("Player 2", "Azul", 2);
        game.addPlayer(p2);
        Player p3 = new Player("Player 3", "verde", 3);
        game.addPlayer(p3);

        // printing each of the players' names and order
        for(Player player : game.getPlayers()){
            System.out.println(player.getName());
            System.out.println(player.getOrder());
        }

        // shuffling the players
        game.randomPlayerOrder();
        for(Player player : game.getPlayers()){
            System.out.println(player.getName());
            System.out.println(player.getOrder());
        }

        // shuffling the objectives
        game.shuffleObjectives();

        // drawing one objective for each player
        game.drawObjectives();
        for(Player player : game.getPlayers()){
            System.out.println(player.getName());
            System.out.println(player.getObjective().getDescription());
        }
    }
}