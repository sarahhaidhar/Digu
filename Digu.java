import java.util.*;

public class Digu{
	ArrayList<Player> players;
	Maindeck deck;
	Stack<Card> discard;

	public Digu(){
		//Get number of players as input, prompts until a valid number (2-4) is provided
		String noOfPlayers = new String("0");
		while (Integer.parseInt(noOfPlayers) < 2 || Integer.parseInt(noOfPlayers) > 4){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter number of players (2-4)");
			noOfPlayers = scanner.nextLine();
		}
		this.players = new ArrayList<>();

        //creates the main deck and shuffles it
		this.deck = new Maindeck();
		deck.shuffleDeck();


        // instantiates new player objects and add to players arraylist
        // player objects are instantiated with a hand, those cards are also then removed from the main deck
		for (int i=0; i < Integer.parseInt(noOfPlayers); i++){
			Player player = new Player(i, deck.removeCard(10));
			players.add(player);
			System.out.println("Player" + (i+1) + ":" + player.getHand());

		}
		System.out.println("Current Deck: " + deck.getDeck());
		this.discard = new Stack<Card>();
		discard.push((deck.removeCard(1)).get(0));
		System.out.println("discard: " + discard);
		System.out.println("Current Deck: " + deck.getDeck());

		this.winCondition(players.get(0));


	}

	public void winCondition(Player p){
		Player player = p;
		ArrayList<Card> currentHand = player.getHand();
		player.getValues(currentHand);

	}
}