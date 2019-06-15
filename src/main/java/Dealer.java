import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;

    public Dealer(){
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public Card dealCard(Deck deck) {
        return deck.dealCard();
    }

    public int countCards() {
        return this.cards.size();
    }
}
