import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DealerTest {

    Dealer dealer;
    Deck deck;
    Card card;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        card = new Card(SuitType.DIAMONDS, RankType.JACK);
    }

    @Test
    public void canAddCard(){
        dealer.addCard(card);
        assertEquals(1, dealer.countHand());
    }

    @Test
    public void canDealCard(){
        assertTrue(dealer.dealCard(deck) instanceof Card);
    }

    @Test
    public void canGetValueOfHand(){
        dealer.addCard(card);
        assertEquals(10, dealer.valueOfHand());
    }

    @Test
    public void startsNotBust() {
        assertEquals(false, dealer.isBust());
    }

    @Test
    public void canBeBust() {
        dealer.goesBust();
        assertEquals(true, dealer.isBust());
    }
}
