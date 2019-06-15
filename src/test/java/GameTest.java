import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Card highCard;
    Card lowCard;
    Card bustCard;
    Game game;
    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    ArrayList<Player> players;


    @Before
    public void before(){

        highCard = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        bustCard = new Card(SuitType.HEARTS, RankType.QUEEN);
        lowCard = new Card(SuitType.DIAMONDS, RankType.FIVE);

        deck = new Deck();
        dealer = new Dealer();

        player1 = new Player("Player 1");

        players = new ArrayList<Player>();
        players.add(player1);

        game = new Game(deck, dealer, players);
    }

    @Test
    public void canHavePlayers(){
        assertEquals(1, game.countPlayers());
    }

    @Test
    public void canDealPlayersCards(){
        game.dealCards();
        assertEquals(1, player1.countHand());
        assertEquals(1, dealer.countHand());
    }

    @Test
    public void dealingWillDepleteDeck(){
        game.dealCards();

        assertEquals(50, deck.countCards());
    }

    @Test
    public void canCheckWinnerDealerWins(){
        player1.addCard(lowCard);
        dealer.addCard(highCard);
        assertEquals(dealer, game.checkWinner());
    }

    @Test
    public void canCheckWinnerPlayer1Wins(){
        player1.addCard(highCard);
        dealer.addCard(lowCard);
        assertEquals(player1, game.checkWinner());
    }

    @Test
    public void canCheckDraw(){
        player1.addCard(lowCard);
        dealer.addCard(lowCard);
        assertEquals(null, game.checkWinner());
    }

    @Test
    public void playerCanTwist(){
        player1.addCard(highCard);
        game.twist(player1);
        assertEquals(2, player1.countHand());
    }

    @Test
    public void dealerCanTwist(){
        dealer.addCard(highCard);
        game.twist(dealer);
        assertEquals(2, dealer.countHand());
    }

    @Test
    public void playerCanGoBust(){
        player1.addCard(highCard);
        player1.addCard(lowCard);
        player1.addCard(bustCard);
        assertEquals(true, game.isBust(player1));

    }

    @Test
    public void dealerWillTwistIf16_OrLess(){
        Card card1 = new Card(SuitType.CLUBS, RankType.SIX);
        Card card2 = new Card(SuitType.CLUBS, RankType.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        game.turn(dealer);
        assertEquals(3, dealer.countHand());
        game.turn(dealer);
        assertEquals(3, dealer.countHand());
    }




}
