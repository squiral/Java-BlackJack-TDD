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

    public int countHand() {
        return this.cards.size();
    }

    public int valueOfHand() {
        int total = 0;
        for (Card card : this.cards){
            int value = card.getValue();
            total += value;
        }

        return total;
    }
}
