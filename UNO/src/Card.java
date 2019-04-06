import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Card implements Comparable<Card> {
	private Color color;
	private CValue value;

	public Card(Color color, CValue value) {
		this.color = color;
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public int compareTo(Card card) {
		// TODO Auto-generated method stub
		if (this.compValue(card) == 0 || this.compColor(card) == 0) {
			return 0;
		} else
			return -1;
	}

	public CValue getValue() {
		return value;
	}

	public int compColor(Card card) {
		if (this.getColor() == card.getColor()) {
			return 0;
		} else
			return -1;
	}

	public int compValue(Card card) {
		if (this.getValue().getV() == card.getValue().getV()) {
			return 0;
		} else
			return -1;
	}

	public String toString() {
		return this.getColor().name() + " " + this.getValue().name();
	}
	
	public boolean iswild() {
		return this.value.getW();
	}

}
