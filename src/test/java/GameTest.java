import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Card highCard;
    Card lowCard;
    Game game;
    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    ArrayList<Player> players;


    @Before
    public void before(){

        highCard = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        lowCard = new Card(SuitType.DIAMONDS, RankType.FIVE);

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

    @Test
    public void canDealPlayersCards(){
        game.dealCardstoPlayers();
        assertEquals(1, player1.countHand());
        assertEquals(1, player2.countHand());
    }

    @Test
    public void canCheckWinner(){
        player1.addCard(lowCard);
        player2.addCard(highCard);
        assertEquals(player2, game.checkWinner());
    }

    @Test
    public void canCheckDraw(){
        player1.addCard(lowCard);
        player2.addCard(lowCard);
        assertEquals(null, game.checkWinner());
    }
}
