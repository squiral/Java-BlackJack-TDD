import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
        populateDeck();
        shuffleDeck();
    }

    public int countCards() {
        return this.cards.size();
    }

    public void populateDeck() {
        for (SuitType suit : SuitType.values()){
            for (RankType rank : RankType.values()){
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }

        this.shuffleDeck();

    }

    public Card dealCard() {
        return this.cards.remove(0);
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }


}
