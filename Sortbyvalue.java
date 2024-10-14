import java.io.*;
import java.lang.*;
import java.util.*;

class Sortbyvalue implements Comparator<Card> {
	public int compare(Card a, Card b){
		return a.value.compareTo(b.value);
	}
}