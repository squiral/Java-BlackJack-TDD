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

    public void dealCards() {
        Card dealerCard = dealer.dealCard(deck);
        dealer.addCard(dealerCard);

        for (Player player : this.players){
            Card card = dealer.dealCard(deck);
            player.addCard(card);
        }
    }

    public Object checkWinner() {
        if (this.checkDraw()){
            return null;
        }

        Player winner = this.players.get(0);

        for (Player player : this.players){
            if(player.valueOfHand() > winner.valueOfHand()){
                winner = player;
            }
        }

        if (winner.valueOfHand() > dealer.valueOfHand()){
            return winner;
        } else {
            return dealer;
        }
    }

    public boolean checkDraw() {
        Boolean draw = false;

        for (Player player : this.players){
            if (player.valueOfHand() == players.get(0).valueOfHand() && player.valueOfHand() == dealer.valueOfHand() ){
                draw = true;
            }
            else {
                draw = false;
            }
        }

        return draw;
    }

    public void twist(Player player) {
        Card card = dealer.dealCard(deck);
        player.addCard(card);
    }

    public boolean isBust(Player player) {
        Boolean bust = false;
        if (player.valueOfHand() > 21){
            bust = true;
        }

        return bust;
    }
}
