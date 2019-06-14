import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card();
    }

    @Test
    public void canGetSuit(){
        assertEquals(card.getSuit());
    }
}
