import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game game;
    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    ArrayList<Player> players;


    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();

        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        game = new Game(deck, dealer, players);
    }

    @Test
    public void canHavePlayers(){
        assertEquals(2, game.countPlayers());
    }
}
