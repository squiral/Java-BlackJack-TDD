import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {

    Player player;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        card1 = new Card(SuitType.HEARTS, RankType.FIVE);
        card2 = new Card(SuitType.CLUBS, RankType.FIVE);
        card3 = new Card(SuitType.DIAMONDS, RankType.FIVE);
        player = new Player("player 1");
    }

    @Test
    public void canGetName(){
        assertEquals("player 1", player.getName());
    }

    @Test
    public void startsWithEmptyHand(){
        assertEquals(0, player.countHand());
    }

    @Test
    public void canAddCard(){
        player.addCard(card1);
        assertEquals(1, player.countHand());
    }

    @Test
    public void canGetValueOfHand(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(15, player.valueOfHand());
    }

    @Test
    public void canClearHand(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        player.clearHand();
        assertEquals(0, player.countHand());
    }

    @Test
    public void startsNotBust(){
        assertEquals(false, player.isBust());
    }

    @Test
    public void canBeBust(){
        player.goesBust();
        assertEquals(true, player.isBust());
    }
    
}
