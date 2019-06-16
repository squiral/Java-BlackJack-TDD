import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;
    private Boolean bust;
    private Boolean sticking;

    public Dealer(){
        this.cards = new ArrayList<Card>();
        this.bust = false;
        this.sticking = false;
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

    public void goesBust() {
        this.bust = true;
    }

    public boolean isBust() {
        return this.bust;
    }

    public void stick() {
        this.sticking = true;
    }

    public boolean isSticking() {
        return this.sticking;
    }
}
