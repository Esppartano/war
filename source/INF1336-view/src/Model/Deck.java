package Model;

import java.util.ArrayList;
import java.util.Random;

class Deck{
    protected ArrayList<TerritoryCard> cards = new ArrayList<TerritoryCard>();

    protected Deck(ArrayList<TerritoryCard> cards){
        this.cards = cards;
    }

    protected void shuffleCards(){
        Random random = new Random();
        for (int i = 0; i < this.cards.size(); i++) {
            int index = random.nextInt(this.cards.size());
            TerritoryCard temp = this.cards.get(i);
            this.cards.set(i, this.cards.get(index));
            this.cards.set(index, temp);
        }
    }

    protected TerritoryCard drawCard(){
        if(this.cards.size() == 0){
            return null;
        }
        TerritoryCard card = this.cards.get(0);
        this.cards.remove(0);
        return card;
    }
}

