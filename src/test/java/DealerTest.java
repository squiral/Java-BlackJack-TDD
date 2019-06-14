import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DealerTest {

    Dealer dealer;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
    }

    @Test
    public void canDealCard(){
        assertTrue(dealer.dealCard(deck) instanceof Card);
    }
}
