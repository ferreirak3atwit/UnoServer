import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Pile {
	// make pile
	private LinkedList<Card> Pile = new LinkedList<Card>();

	public boolean isEmpty() {
		return Pile.isEmpty();
	}

	public void shuffle() {
		Collections.shuffle(Pile);// self explanatory
		System.out.println("Shuffled");
	}

	public Card getC(int card) {
		if (card < Pile.size()) {
			return Pile.get(card);
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	public int Length() {
		return Pile.size();
	}

	public boolean compareCard(Card card) {//compares color and value
		boolean same = false;

		for (int i = 0; i < this.Length(); i++) {
			if (this.getC(i).compColor(card) == 0 && this.getC(i).compValue(card) == 0) {
				return same = true;
			}
		}

		return same;
	}

	public Card removetop() {
		if(!Pile.isEmpty()) {
			return Pile.removeFirst();
		}else throw new NoSuchElementException();
	}
	
	public Card gettop() {//returns top card in pile
		return Pile.getFirst();
	}
	
	public void clear() {
		Pile.clear();
	}
	
	
	public String toStringpile() {
		return Pile.toString();
	}
	
	public int Index(Card card) {
		int index = 0;
		boolean found = false;
		while (!found && index < Pile.size()) {
			if (Pile.get(index).compColor(card)==0 && Pile.get(index).compValue(card)==0) {
				found = true;
				break;
			}
			index++;
		}
		return found ? index : -1;
	}
	public void add(Card card) {//add card to pile
		Pile.add(card);
	}
	
	public void addtop(Card card) {
		Pile.add(0, card);
	}
	
	public Card remove(int card) {
		if (card<this.Length()) {
			return Pile.remove(card);
		}else throw new IndexOutOfBoundsException("");
	}
}
