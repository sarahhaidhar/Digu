import java.io.*;
import java.lang.*;
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
		for (int i=1; i < Integer.parseInt(noOfPlayers); i++){
			Player player = new Player(i, deck.removeCard(10));
			players.add(player);
			System.out.println("Player" + (i+1) + ":" + player.getHand());

		}
		System.out.println("Current Deck: " + deck.getDeck());
		this.discard = new Stack<Card>();
		discard.push((deck.removeCard(1)).get(0));
		System.out.println("discard: " + discard);
		System.out.println("Current Deck: " + deck.getDeck());

		// Card testOne = new Card("a", "1", 1);
		// Card testTwo = new Card("a", "2", 2);
		// Card testThree = new Card("a", "3", 3);

		// ArrayList<Card> testHand = new ArrayList<Card>();
		// testHand.add(testOne);
		// testHand.add(testOne);
		// testHand.add(testOne);
		// testHand.add(testOne);
		// testHand.add(testTwo);
		// testHand.add(testTwo);
		// testHand.add(testTwo);
		// testHand.add(testThree);
		// testHand.add(testThree);
		// testHand.add(testThree);

		// Player testPlayer = new Player(5, testHand);

		// System.out.println(this.winCondition(testPlayer));


	}

	public boolean winCondition(Player p){
		Player player = p;
		ArrayList<Card> currentHand = player.getHand();
		Collections.sort(currentHand, new Sortbyvalue());
		System.out.println(currentHand);
		String possibleOne = "334";
		String possibleTwo = "343";
		String possibleThree = "433";
		String stringListOfValues = "";

		Map<String, Integer> cardAmount = new HashMap<String, Integer>();

		for (Card card: currentHand){
			Integer j = cardAmount.get(card.getValue());
			cardAmount.put(card.getValue(), (j == null) ? 1: j + 1);
		}

		ArrayList<Integer> listOfValues = new ArrayList<>(cardAmount.values());
		for (Integer value : listOfValues){
			stringListOfValues += Integer.toString(value);

		}

		System.out.println(stringListOfValues);

		if (stringListOfValues.equals(possibleOne) || stringListOfValues.equals(possibleTwo) || stringListOfValues.equals(possibleThree)){
			return true;
		}
		else{
			return false;
		}

	}
}