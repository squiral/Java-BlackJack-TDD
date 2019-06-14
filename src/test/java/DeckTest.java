import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class DeckTest {

    Deck deck;
    Card card;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.countCards());
    }

    @Test
    public void canPopulateDeck(){
        deck.populateDeck();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canDealCard(){
        deck.populateDeck();
        assertTrue(deck.dealCard() instanceof Card);
    }









}
