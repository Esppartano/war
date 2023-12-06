package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Game {
    private List<Objective> objectives;
    private List<TerritoryCard> cards;
    private List<Territory> territories;
    private List<Continent> continents;
    private List<Player> players;
    private Deck deck;


    public Game() {
        objectives = new ArrayList<>();
        cards = new ArrayList<>();
        territories = new ArrayList<>();
        continents = new ArrayList<>();
        players = new ArrayList<>();
    }


    private TerritoryCard createCard(String name, Territory territory, String shape) {
        return new TerritoryCard(name, territory, shape);
    }

    private Territory createTerritory(String name) {
        return new Territory(name);
    }

    private Continent createContinent(String name) {
        return new Continent(name);
    }

    private Player createPlayer(String name, Color color, int order) {
        return new Player(name, color);
    }


    protected void generateListTerritoriesAndObjectives() {
        Territory africa_do_sul = createTerritory("Africa do Sul");
        this.territories.add(africa_do_sul);
        Territory angola = createTerritory("Angola");
        this.territories.add(angola);
        Territory argelia = createTerritory("Argelia");
        this.territories.add(argelia);
        Territory egito = createTerritory("Egito");
        this.territories.add(egito);
        Territory nigeria = createTerritory("Nigeria");
        this.territories.add(nigeria);
        Territory somalia = createTerritory("Somalia");
        this.territories.add(somalia);
        Territory alasca = createTerritory("Alasca");
        this.territories.add(alasca);
        Territory calgary = createTerritory("Calgary");
        this.territories.add(calgary);
        Territory california = createTerritory("California");
        this.territories.add(california);
        Territory groelandia = createTerritory("Groelandia");
        this.territories.add(groelandia);
        Territory mexico = createTerritory("Mexico");
        this.territories.add(mexico);
        Territory nova_iorque = createTerritory("Nova Iorque");
        this.territories.add(nova_iorque);
        Territory ontario = createTerritory("Ontario");
        this.territories.add(ontario);
        Territory quebec = createTerritory("Quebec");
        this.territories.add(quebec);
        Territory vancouver = createTerritory("Vancouver");
        this.territories.add(vancouver);
        Territory venezuela = createTerritory("Venezuela");
        this.territories.add(venezuela);
        Territory argentina = createTerritory("Argentina");
        this.territories.add(argentina);
        Territory brasil = createTerritory("Brasil");
        this.territories.add(brasil);
        Territory peru = createTerritory("Peru");
        this.territories.add(peru);
        Territory texas = createTerritory("Texas");
        this.territories.add(texas);
        Territory arabia_saudita = createTerritory("Arabia Saudita");
        this.territories.add(arabia_saudita);
        Territory Bangladesh = createTerritory("Bangladesh");
        this.territories.add(Bangladesh);
        Territory cazaquistao = createTerritory("Cazaquistao");
        this.territories.add(cazaquistao);
        Territory china = createTerritory("China");
        this.territories.add(china);
        Territory coreia_do_norte = createTerritory("Coreia do Norte");
        this.territories.add(coreia_do_norte);
        Territory coreia_do_sul = createTerritory("Coreia do Sul");
        this.territories.add(coreia_do_sul);
        Territory india = createTerritory("India");
        this.territories.add(india);
        Territory estonia = createTerritory("Estonia");
        this.territories.add(estonia);
        Territory ira = createTerritory("Ira");
        this.territories.add(ira);
        Territory iraque = createTerritory("Iraque");
        this.territories.add(iraque);
        Territory japao = createTerritory("Japao");
        this.territories.add(japao);
        Territory jordania = createTerritory("Jordania");
        this.territories.add(jordania);
        Territory letonia = createTerritory("Letonia");
        this.territories.add(letonia);
        Territory mongolia = createTerritory("Mongolia");
        this.territories.add(mongolia);
        Territory paquistao = createTerritory("Paquistao");
        this.territories.add(paquistao);
        Territory russia = createTerritory("Russia");
        this.territories.add(russia);
        Territory siria = createTerritory("Siria");
        this.territories.add(siria);
        Territory turquia = createTerritory("Turquia");
        this.territories.add(turquia);
        Territory australia = createTerritory("Australia");
        this.territories.add(australia);
        Territory coringa = createTerritory("Coringa");
        this.territories.add(coringa);
        Territory italia = createTerritory("Italia");
        this.territories.add(italia);
        Territory espanha = createTerritory("Espanha");
        this.territories.add(espanha);
        Territory franca = createTerritory("Franca");
        this.territories.add(franca);
        Territory polonia = createTerritory("Polonia");
        this.territories.add(polonia);
        Territory tailandia = createTerritory("Tailandia");
        this.territories.add(tailandia);
        Territory reino_unido = createTerritory("Reino Unido");
        this.territories.add(reino_unido);
        Territory romenia = createTerritory("Romenia");
        this.territories.add(romenia);
        Territory suecia = createTerritory("Suecia");
        this.territories.add(suecia);
        Territory ucrania = createTerritory("Ucraina");
        this.territories.add(ucrania);
        Territory nova_zelandia = createTerritory("Nova Zelandia");
        this.territories.add(nova_zelandia);
        Territory perth = createTerritory("Perth");
        this.territories.add(perth);
        Territory indonesia = createTerritory("Indonesia");
        this.territories.add(indonesia);
        Territory siberia = createTerritory("Siberia");
        this.territories.add(siberia);
        Territory bangladesh = createTerritory("Bangladesh");
        this.territories.add(bangladesh);

        // Adicionando os territorios aos continentes
        Continent africa = createContinent("Africa");
        africa.addTerritory(egito);
        africa.addTerritory(nigeria);
        africa.addTerritory(somalia);
        africa.addTerritory(argelia);
        africa.addTerritory(angola);
        africa.addTerritory(africa_do_sul);

        Continent america_do_norte = createContinent("America do Norte");
        america_do_norte.addTerritory(alasca);
        america_do_norte.addTerritory(california);
        america_do_norte.addTerritory(calgary);
        america_do_norte.addTerritory(groelandia);
        america_do_norte.addTerritory(mexico);
        america_do_norte.addTerritory(nova_iorque);
        america_do_norte.addTerritory(ontario);
        america_do_norte.addTerritory(quebec);
        america_do_norte.addTerritory(vancouver);
        america_do_norte.addTerritory(texas);

        Continent america_do_sul = createContinent("America do Sul");
        america_do_sul.addTerritory(argentina);
        america_do_sul.addTerritory(brasil);
        america_do_sul.addTerritory(peru);
        america_do_sul.addTerritory(venezuela);

        Continent asia = createContinent("Asia");
        asia.addTerritory(arabia_saudita);
        asia.addTerritory(bangladesh);
        asia.addTerritory(cazaquistao);
        asia.addTerritory(china);
        asia.addTerritory(coreia_do_norte);
        asia.addTerritory(coreia_do_sul);
        asia.addTerritory(india);
        asia.addTerritory(estonia);
        asia.addTerritory(ira);
        asia.addTerritory(iraque);
        asia.addTerritory(japao);
        asia.addTerritory(jordania);
        asia.addTerritory(letonia);
        asia.addTerritory(mongolia);
        asia.addTerritory(paquistao);
        asia.addTerritory(russia);
        asia.addTerritory(siria);
        asia.addTerritory(tailandia);
        asia.addTerritory(turquia);

        Continent oceania = createContinent("Oceania");
        oceania.addTerritory(australia);
        oceania.addTerritory(nova_zelandia);
        oceania.addTerritory(perth);
        oceania.addTerritory(indonesia);

        Continent europa = createContinent("Europa");
        europa.addTerritory(espanha);
        europa.addTerritory(franca);
        europa.addTerritory(italia);
        europa.addTerritory(polonia);
        europa.addTerritory(reino_unido);
        europa.addTerritory(romenia);
        europa.addTerritory(suecia);
        europa.addTerritory(ucrania);


        // Adding the neighbours
        // Africa
        africa_do_sul.addNeighbour(angola);
        africa_do_sul.addNeighbour(somalia);
        angola.addNeighbour(nigeria);
        angola.addNeighbour(somalia);
        somalia.addNeighbour(nigeria);
        somalia.addNeighbour(egito);
        somalia.addNeighbour(arabia_saudita);
        nigeria.addNeighbour(egito);
        nigeria.addNeighbour(argelia);
        nigeria.addNeighbour(brasil);
        egito.addNeighbour(argelia);
        egito.addNeighbour(jordania);
        egito.addNeighbour(romenia);
        argelia.addNeighbour(espanha);
        argelia.addNeighbour(italia);

        // America do Norte
        alasca.addNeighbour(siberia);
        alasca.addNeighbour(calgary);
        alasca.addNeighbour(vancouver);
        calgary.addNeighbour(vancouver);
        calgary.addNeighbour(groelandia);
        vancouver.addNeighbour(quebec);
        vancouver.addNeighbour(california);
        vancouver.addNeighbour(texas);
        quebec.addNeighbour(groelandia);
        quebec.addNeighbour(nova_iorque);
        quebec.addNeighbour(texas);
        nova_iorque.addNeighbour(texas);
        groelandia.addNeighbour(reino_unido);
        texas.addNeighbour(mexico);
        texas.addNeighbour(california);
        mexico.addNeighbour(california);
        mexico.addNeighbour(venezuela);

        // America do Sul
        venezuela.addNeighbour(brasil);
        venezuela.addNeighbour(peru);
        brasil.addNeighbour(peru);
        brasil.addNeighbour(argentina);
        peru.addNeighbour(argentina);

        // Oceania
        australia.addNeighbour(indonesia);
        australia.addNeighbour(nova_zelandia);
        australia.addNeighbour(perth);
        nova_zelandia.addNeighbour(indonesia);
        indonesia.addNeighbour(india);
        indonesia.addNeighbour(bangladesh);

        // Asia
        arabia_saudita.addNeighbour(iraque);
        arabia_saudita.addNeighbour(jordania);
        jordania.addNeighbour(iraque);
        jordania.addNeighbour(siria);
        siria.addNeighbour(iraque);
        siria.addNeighbour(turquia);
        siria.addNeighbour(ira);
        siria.addNeighbour(paquistao);
        iraque.addNeighbour(ira);
        ira.addNeighbour(paquistao);
        paquistao.addNeighbour(china);
        paquistao.addNeighbour(india);
        paquistao.addNeighbour(turquia);
        turquia.addNeighbour(letonia);
        turquia.addNeighbour(ucrania);
        turquia.addNeighbour(cazaquistao);
        turquia.addNeighbour(china);
        letonia.addNeighbour(ucrania);
        letonia.addNeighbour(russia);
        letonia.addNeighbour(estonia);
        letonia.addNeighbour(suecia);
        letonia.addNeighbour(polonia);
        estonia.addNeighbour(suecia);
        estonia.addNeighbour(russia);
        russia.addNeighbour(siberia);
        russia.addNeighbour(cazaquistao);
        siberia.addNeighbour(cazaquistao);
        cazaquistao.addNeighbour(china);
        cazaquistao.addNeighbour(mongolia);
        cazaquistao.addNeighbour(japao);
        japao.addNeighbour(coreia_do_norte);
        japao.addNeighbour(mongolia);
        mongolia.addNeighbour(china);
        china.addNeighbour(india);
        china.addNeighbour(coreia_do_norte);
        china.addNeighbour(coreia_do_sul);
        coreia_do_norte.addNeighbour(coreia_do_sul);
        coreia_do_sul.addNeighbour(india);
        coreia_do_sul.addNeighbour(bangladesh);
        coreia_do_sul.addNeighbour(tailandia);
        india.addNeighbour(bangladesh);
        bangladesh.addNeighbour(tailandia);

        // Europa
        espanha.addNeighbour(franca);
        franca.addNeighbour(reino_unido);
        franca.addNeighbour(italia);
        franca.addNeighbour(suecia);
        italia.addNeighbour(romenia);
        italia.addNeighbour(polonia);
        italia.addNeighbour(suecia);
        romenia.addNeighbour(ucrania);
        romenia.addNeighbour(polonia);
        polonia.addNeighbour(ucrania);

        // adding the objectives
        ArrayList<Continent> obj1 = new ArrayList<>();
        obj1.add(oceania);
        obj1.add(europa);
        obj1.add(null);
        ConquerContinentObjective europa_oceania_and_third = new ConquerContinentObjective("Conquistar Europa, Oceania e um terceiro continente", 0, obj1);
        this.objectives.add(europa_oceania_and_third);
        ArrayList<Continent> obj2 = new ArrayList<>();
        obj2.add(asia);
        obj2.add(america_do_sul);
        ConquerContinentObjective asia_and_south_america = new ConquerContinentObjective("Conquistar Asia e America do Sul", 0, obj2);
        this.objectives.add(asia_and_south_america);
        ArrayList<Continent> obj3 = new ArrayList<>();
        obj3.add(america_do_sul);
        obj3.add(europa);
        obj3.add(null);
        ConquerContinentObjective south_america_and_europe_and_third = new ConquerContinentObjective("Conquistar America do Sul, Europa e um terceiro continente", 0, obj3);
        this.objectives.add(south_america_and_europe_and_third);

        ConquerTerritoriesObjective territories_with_2_armies = new ConquerTerritoriesObjective("Conquistar 18 territorios com 2 exercitos em cada", 18, 2);
        this.objectives.add(territories_with_2_armies);

        ArrayList<Continent> obj5 = new ArrayList<>();
        obj5.add(asia);
        obj5.add(africa);
        ConquerContinentObjective asia_and_africa = new ConquerContinentObjective("Conquistar Asia e Africa", 0, obj5);
        this.objectives.add(asia_and_africa);

        ArrayList<Continent> obj6 = new ArrayList<>();
        obj6.add(america_do_norte);
        obj6.add(africa);
        ConquerContinentObjective north_america_and_africa = new ConquerContinentObjective("Conquistar America do Norte e Africa", 0, obj6);
        this.objectives.add(north_america_and_africa);

        ConquerTerritoriesObjective conquer_24_territories = new ConquerTerritoriesObjective("Conquistar 24 territorios", 24, 0);
        this.objectives.add(conquer_24_territories);

        ArrayList<Continent> obj8 = new ArrayList<>();
        obj8.add(america_do_norte);
        obj8.add(oceania);
        ConquerContinentObjective north_america_and_oceania = new ConquerContinentObjective("Conquistar America do Norte e Oceania", 0, obj8);
        this.objectives.add(north_america_and_oceania);

        ConquerPlayer conquer_blue = new ConquerPlayer("Conquistar o jogador Azul", "Azul");
        this.objectives.add(conquer_blue);

        ConquerPlayer conquer_red = new ConquerPlayer("Conquistar o jogador Vermelho", "Vermelho");
        this.objectives.add(conquer_red);

        ConquerPlayer conquer_green = new ConquerPlayer("Conquistar o jogador Verde", "Verde");
        this.objectives.add(conquer_green);

        ConquerPlayer conquer_yellow = new ConquerPlayer("Conquistar o jogador Amarelo", "Amarelo");
        this.objectives.add(conquer_yellow);

        ConquerPlayer conquer_black = new ConquerPlayer("Conquistar o jogador Preto", "Preto");
        this.objectives.add(conquer_black);

        ConquerPlayer conquer_white = new ConquerPlayer("Conquistar o jogador Branco", "Branco");
        this.objectives.add(conquer_white);

    }

    protected void generateListTerritoryCards() {
        this.cards.add(createCard("Africa do Sul", this.territories.get(0), "Triangulo"));
        this.cards.add(createCard("Angola", this.territories.get(1), "Quadrado"));
        this.cards.add(createCard("Argelia", this.territories.get(2), "Circulo"));
        this.cards.add(createCard("Egito", this.territories.get(3), "Triangulo"));
        this.cards.add(createCard("Nigeria", this.territories.get(4), "Circulo"));
        this.cards.add(createCard("Somalia", this.territories.get(5), "Quadrado"));
        this.cards.add(createCard("Alasca", this.territories.get(6), "Triangulo"));
        this.cards.add(createCard("Calgary", this.territories.get(7), "Circulo"));
        this.cards.add(createCard("California", this.territories.get(8), "Quadrado"));
        this.cards.add(createCard("Groelandia", this.territories.get(9), "Circulo"));
        this.cards.add(createCard("Mexico", this.territories.get(10), "Quadrado"));
        this.cards.add(createCard("Nova Iorque", this.territories.get(11), "Quadrado"));
        this.cards.add(createCard("Quebec", this.territories.get(12), "Circulo"));
        this.cards.add(createCard("Vancouver", this.territories.get(13), "Triangulo"));
        this.cards.add(createCard("Texas", this.territories.get(14), "Triangulo"));
        this.cards.add(createCard("Arabia Saudita", this.territories.get(15), "Circulo"));
        this.cards.add(createCard("Bangladesh", this.territories.get(16), "Circulo"));
        this.cards.add(createCard("Cazaquistao", this.territories.get(17), "Circulo"));
        this.cards.add(createCard("China", this.territories.get(18), "Quadrado"));
        this.cards.add(createCard("Coreia do Norte", this.territories.get(19), "Quadrado"));
        this.cards.add(createCard("Coreia do Sul", this.territories.get(20), "Triangulo"));
        this.cards.add(createCard("Estonia", this.territories.get(21), "Circulo"));
        this.cards.add(createCard("India", this.territories.get(22), "Triangulo"));
        this.cards.add(createCard("Ira", this.territories.get(23), "Quadrado"));
        this.cards.add(createCard("Iraque", this.territories.get(24), "Triangulo"));
        this.cards.add(createCard("Japao", this.territories.get(25), "Circulo"));
        this.cards.add(createCard("Jordania", this.territories.get(26), "Quadrado"));
        this.cards.add(createCard("Letonia", this.territories.get(27), "Quadrado"));
        this.cards.add(createCard("Mongolia", this.territories.get(28), "Triangulo"));
        this.cards.add(createCard("Paquistao", this.territories.get(29), "Circulo"));
        this.cards.add(createCard("Russia", this.territories.get(30), "Triangulo"));
        this.cards.add(createCard("Siberia", this.territories.get(31), "Quadrado"));
        this.cards.add(createCard("Siria", this.territories.get(32), "Quadrado"));
        this.cards.add(createCard("Tailandia", this.territories.get(33), "Triangulo"));
        this.cards.add(createCard("Turquia", this.territories.get(34), "Triangulo"));
        this.cards.add(createCard("Brasil", this.territories.get(35), "Circulo"));
        this.cards.add(createCard("Argentina", this.territories.get(36), "Quadrado"));
        this.cards.add(createCard("Peru", this.territories.get(37), "Triangulo"));
        this.cards.add(createCard("Venezuela", this.territories.get(38), "Triangulo"));
        this.cards.add(createCard("Coringa", this.territories.get(39), null));
        this.cards.add(createCard("Espanha", this.territories.get(40), "Circulo"));
        this.cards.add(createCard("Franca", this.territories.get(41), "Triangulo"));
        this.cards.add(createCard("Italia", this.territories.get(42), "Quadrado"));
        this.cards.add(createCard("Polonia", this.territories.get(43), "Triangulo"));
        this.cards.add(createCard("Reino Unido", this.territories.get(44), "Circulo"));
        this.cards.add(createCard("Romenia", this.territories.get(45), "Triangulo"));
        this.cards.add(createCard("Suecia", this.territories.get(46), "Quadrado"));
        this.cards.add(createCard("Ucrania", this.territories.get(47), "Circulo"));
        this.cards.add(createCard("Australia", this.territories.get(48), "Triangulo"));
        this.cards.add(createCard("Indonesia", this.territories.get(49), "Triangulo"));
        this.cards.add(createCard("Nova Zelandia", this.territories.get(50), "Quadrado"));
        this.cards.add(createCard("Perth", this.territories.get(51), "Circulo"));
    }


    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public List<TerritoryCard> getCards() {
        return cards;
    }

    public void setCards(List<TerritoryCard> cards) {
        this.cards = cards;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territory> territories) {
        this.territories = territories;
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    protected Player getPlayerByName(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    protected Territory getTerritoryByName(String name) {
        for (Territory territory : this.territories) {
            if (territory.getName().equals(name)) {
                return territory;
            }
        }
        return null;
    }

    protected void randomPlayerOrder() {
        // randomizes player order and sets the order for each player object
        Collections.shuffle(this.players);
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setOrder(i);
        }
    }

    protected void shuffleObjectives() {
        Collections.shuffle(this.objectives);
    }

    protected void drawObjectives() {
        for (Player player : this.players) {
            player.setObjective(this.objectives.get(0));
            this.objectives.remove(0);
        }
    }

    protected void shuffleCards() {
        Collections.shuffle(this.cards);
    }

    protected void drawCards() {
        for (Player player : this.players) {
            Territory tmp = getTerritoryByName(this.cards.get(0).getName());
            tmp.setArmies(1);
            this.cards.remove(0);
            tmp.setOwner(player);
        }
    }

    protected void turn(Player player) {

    }

    protected void turns() {
        while (true) {
            for (Player player : this.players) {
                // TODO: implement turn logic

                if (player.getObjective().isComplete(player)) {
                    System.out.println(player.getName() + " venceu o jogo!");
                    return;
                }
            }
        }
    }

    protected void attackTerritory(Territory attacker, Territory defender) {
        Dice dice = new Dice();
        if (attacker.getArmies() > 1) {
            int attackerDice = 0;
            int defenderDice = 0;
            if (attacker.getArmies() > 3) {
                attackerDice = 3;
            } else if (attacker.getArmies() == 3) {
                attackerDice = 2;
            } else if (attacker.getArmies() == 2) {
                attackerDice = 1;
            }
            if (defender.getArmies() > 1) {
                defenderDice = 2;
            } else if (defender.getArmies() == 1) {
                defenderDice = 1;
            }
            int[] attackerRoll = new int[attackerDice];
            int[] defenderRoll = new int[defenderDice];
            for (int i = 0; i < attackerDice; i++) {
                attackerRoll[i] = dice.roll();
            }
            for (int i = 0; i < defenderDice; i++) {
                defenderRoll[i] = dice.roll();
            }
            Arrays.sort(attackerRoll);
            Arrays.sort(defenderRoll);
            for (int i = 0; i < defenderDice; i++) {
                if (attackerRoll[attackerDice - 1 - i] > defenderRoll[defenderDice - 1 - i]) {
                    defender.setArmies(defender.getArmies() - 1);
                } else {
                    attacker.setArmies(attacker.getArmies() - 1);
                }
            }
        }
    }

    protected void attackTerritoryNotRandom(int[] diceValuesAttack, int[] diceValuesDefense, Territory attacker, Territory defender) {
        if (attacker.getArmies() > 1) {
            int attackerDice = 0;
            int defenderDice = 0;
            if (attacker.getArmies() > 3) {
                attackerDice = 3;
            } else if (attacker.getArmies() == 3) {
                attackerDice = 2;
            } else if (attacker.getArmies() == 2) {
                attackerDice = 1;
            }
            if (defender.getArmies() > 1) {
                defenderDice = 2;
            } else if (defender.getArmies() == 1) {
                defenderDice = 1;
            }
            int[] attackerRoll = new int[attackerDice];
            int[] defenderRoll = new int[defenderDice];
            System.arraycopy(diceValuesAttack, 0, attackerRoll, 0, attackerDice);
            System.arraycopy(diceValuesDefense, 0, defenderRoll, 0, defenderDice);
            Arrays.sort(attackerRoll);
            Arrays.sort(defenderRoll);
            for (int i = 0; i < defenderDice; i++) {
                if (attackerRoll[attackerDice - 1 - i] > defenderRoll[defenderDice - 1 - i]) {
                    defender.setArmies(defender.getArmies() - 1);
                } else {
                    attacker.setArmies(attacker.getArmies() - 1);
                }
            }
        }
    }

    protected void moveArmies(Territory origin, Territory destination, int armies) {
        if (origin.getArmies() > armies) {
            origin.setArmies(origin.getArmies() - armies);
            destination.setArmies(destination.getArmies() + armies);
        }
    }

    protected String saveGameState(){
        StringBuilder gameState = new StringBuilder();
        gameState.append("Territories:\n");
        for(Territory territory : this.territories){
            if (territory.getOwner() != null) {
                gameState.append(territory.getName()).append(" ").append(territory.getOwner().getName()).append(" ").append(territory.getArmies()).append("\n");
            } else {
                gameState.append(territory.getName()).append(" ").append("null").append(" ").append(territory.getArmies()).append("\n");
            }
        }
        gameState.append("Players:\n");
        for(Player player : this.players){
            gameState.append(player.getName()).append(" ").append(player.getColor()).append(" ").append(player.getOrder()).append(" ").append(player.getObjective().getDescription()).append("\n");
        }
        gameState.append("Cards:\n");
        for(TerritoryCard card : this.cards){
            gameState.append(card.getName()).append(" ").append(card.getTerritory().getName()).append(" ").append(card.getShape()).append("\n");
        }
        gameState.append("Objectives:\n");
        for(Objective objective : this.objectives) {
            gameState.append(objective.getDescription()).append("\n");
        }
        return gameState.toString();
    }

}
