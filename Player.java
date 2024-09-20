import java.util.*;

public class Player{
	int playerNumber;
	ArrayList<Card> hand;

	public Player(int n, ArrayList<Card> h){
		playerNumber = n;
		hand = h;
	}

//NEED TO REMOVE WHAT U ADD FROM MAIN DECK
	public void setHand(Stack<Card> h){
		this.hand = new ArrayList<>();
		for (int i=0; i<11; i++){
			this.hand.add(h.pop());
		}

	}

	public ArrayList<Card> getHand(){
		return this.hand;
	}

	public void getValues(ArrayList<Card> h){
		ArrayList<Card> hand = h;
		for (Card card : hand){
			System.out.println(card);
		}


	}
}