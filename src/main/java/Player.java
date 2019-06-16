import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private Boolean bust;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.bust = false;
    }


    public String getName() {
        return this.name;
    }

    public int countHand() {
        return this.hand.size();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int valueOfHand() {
        int total = 0;
        for (Card card : this.hand){
            int value = card.getValue();
            total += value;
        }

        return total;
    }

    public void clearHand() {
        this.hand.clear();
    }

    public void goesBust() {
        this.bust = true;
    }

    public boolean isBust() {
        return this.bust;
    }
}
