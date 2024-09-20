import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.Stack;

public class Maindeck{
	Card card;
	Stack<Card> deck;

	public Maindeck(){
		//instantiate cards from 2-10 and add it to the deck arraylist
		List<String> suits = new ArrayList<>();
		this.deck = new Stack<>();
		suits.add("♥");
		suits.add("♠");
		suits.add("♣");
		suits.add("♦");
		for (int i = 2; i < 11; i++){
			for(int j=0; j < 4; j++){
				String val = Integer.toString(i);
				Card card = new Card(suits.get(j), val, i);
				deck.push(card);
			} 
		}
		//instantiate cards J,Q,K and add to deck arraylist
		String[] royalValues = {"J", "Q", "K", "A"};
		HashMap<String, Integer> royalScores = new HashMap<String, Integer>();
		royalScores.put("J", 10);
		royalScores.put("Q", 10);
		royalScores.put("K", 15);
		royalScores.put("A", 20);
		for(String val : royalValues){
			for (int j=0; j<4; j++){
				Card card = new Card(suits.get(j), val, royalScores.get(val));
				deck.push(card);
			}
		}
	}

	public Stack<Card> getDeck(){
		return this.deck;
	}

	public void shuffleDeck(){
		Collections.shuffle(this.deck);
	}

	public ArrayList<Card> removeCard(int n){
		ArrayList<Card> removedCards = new ArrayList<>();
		for (int i=0; i<n ; i++){
			removedCards.add((this.getDeck()).lastElement());
			this.deck.pop();
		}
		return removedCards;
	}
}