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
    Player player3;
    ArrayList<Player> players;


    @Before
    public void before(){

        highCard = new Card(SuitType.DIAMONDS, RankType.QUEEN); //10
        bustCard = new Card(SuitType.HEARTS, RankType.QUEEN);   //10
        lowCard = new Card(SuitType.DIAMONDS, RankType.FIVE);   //5

        deck = new Deck();
        dealer = new Dealer();

        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        player3 = new Player("Player 3");

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
        assertEquals(2, player1.countHand());
        assertEquals(2, dealer.countHand());
    }

    @Test
    public void dealingWillDepleteDeck(){
        game.dealCards();

        assertEquals(48, deck.countCards());
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
    public void playerGoesBustOver21(){
        player1.addCard(highCard);
        player1.addCard(lowCard);
        player1.addCard(bustCard);
        assertEquals(true, game.isPlayerBust(player1));

    }

    @Test
    public void dealerWillTwistIf16_OrLess(){
        Card card1 = new Card(SuitType.CLUBS, RankType.SIX);
        Card card2 = new Card(SuitType.CLUBS, RankType.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        game.dealerTurn(dealer);
        assertEquals(3, dealer.countHand());
        game.dealerTurn(dealer);
        assertEquals(3, dealer.countHand());
    }

    @Test
    public void dealerGoesBustOver21(){
        dealer.addCard(highCard);
        dealer.addCard(lowCard);
        dealer.addCard(bustCard);
        assertEquals(true, game.isDealerBust(dealer));
    }

    @Test
    public void playerCanStickOrTwistInTurn() {
        player1.addCard(lowCard);
        player1.addCard(highCard);
        assertEquals(2, player1.countHand());
        game.playerTurn(player1, "twist");
        assertEquals(3, player1.countHand());
        game.playerTurn(player1, "stick");
        assertEquals(3, player1.countHand());
        assertEquals(true, player1.isSticking());
    }

    @Test
    public void gameCanFilterBustPlayers(){
        players.add(player2);
        players.add(player3);
        player2.goesBust();
        assertEquals(2, game.nonBustPlayers().size());
    }

    @Test
    public void gameWillChooseNonBustPlayerAsWinner() {
        players.add(player2);

        //player 1 has 25 and is bust
        player1.addCard(lowCard);
        player1.addCard(highCard);
        player1.addCard(bustCard);


        //player 2 has 15 and is not bust
        player2.addCard(highCard);
        player2.addCard(lowCard);

        //dealer has 10 and is not bust
        dealer.addCard(highCard);

        assertEquals(player2, game.checkWinner());
    }












}
