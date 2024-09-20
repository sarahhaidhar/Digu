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

public String get_suit(){
	return suit;
}

public String get_value(){
	return value;
}

public int get_score(){
	return score;
}

@Override
public String toString(){
	return (value + suit);
}
}