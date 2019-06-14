import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;

    public Game(Deck deck, Dealer dealer, ArrayList<Player> players){
        this.dealer = dealer;
        this.players = players;
        this.deck = deck;
    }

    public int countPlayers() {
        return this.players.size();
    }

}
