import java.util.ArrayList;
import java.util.List;


public class Card{
	public String suit;
	public String value;
	public int score;

public Card(String st, String v, int s){
	suit = st;
	value = v;
	score = s;
}

public String getSuit(){
	return suit;
}

public String getValue(){
	return value;
}

public int getScore(){
	return score;
}

@Override
public String toString(){
	return (value + suit);
}
}