import java.util.ArrayList;

public class Deck extends Pile {

	public Deck() {

		super.add(new Card(Color.RED, CValue.ZERO));
		super.add(new Card(Color.RED, CValue.ZERO));
		super.add(new Card(Color.BLUE, CValue.ZERO));
		super.add(new Card(Color.BLUE, CValue.ZERO));
		super.add(new Card(Color.GREEN, CValue.ZERO));
		super.add(new Card(Color.GREEN, CValue.ZERO));
		super.add(new Card(Color.YELLOW, CValue.ZERO));
		super.add(new Card(Color.YELLOW, CValue.ZERO));
		super.add(new Card(Color.RED, CValue.ONE));
		super.add(new Card(Color.RED, CValue.ONE));
		super.add(new Card(Color.BLUE, CValue.ONE));
		super.add(new Card(Color.BLUE, CValue.ONE));
		super.add(new Card(Color.GREEN, CValue.ONE));
		super.add(new Card(Color.GREEN, CValue.ONE));
		super.add(new Card(Color.YELLOW, CValue.ONE));
		super.add(new Card(Color.YELLOW, CValue.ONE));
		super.add(new Card(Color.RED, CValue.TWO));
		super.add(new Card(Color.RED, CValue.TWO));
		super.add(new Card(Color.BLUE, CValue.TWO));
		super.add(new Card(Color.BLUE, CValue.TWO));
		super.add(new Card(Color.GREEN, CValue.TWO));
		super.add(new Card(Color.GREEN, CValue.TWO));
		super.add(new Card(Color.YELLOW, CValue.TWO));
		super.add(new Card(Color.YELLOW, CValue.TWO));
		super.add(new Card(Color.RED, CValue.THREE));
		super.add(new Card(Color.RED, CValue.THREE));
		super.add(new Card(Color.BLUE, CValue.THREE));
		super.add(new Card(Color.BLUE, CValue.THREE));
		super.add(new Card(Color.GREEN, CValue.THREE));
		super.add(new Card(Color.GREEN, CValue.THREE));
		super.add(new Card(Color.YELLOW, CValue.THREE));
		super.add(new Card(Color.YELLOW, CValue.THREE));
		super.add(new Card(Color.RED, CValue.FOUR));
		super.add(new Card(Color.RED, CValue.FOUR));
		super.add(new Card(Color.BLUE, CValue.FOUR));
		super.add(new Card(Color.BLUE, CValue.FOUR));
		super.add(new Card(Color.GREEN, CValue.FOUR));
		super.add(new Card(Color.GREEN, CValue.FOUR));
		super.add(new Card(Color.YELLOW, CValue.FOUR));
		super.add(new Card(Color.YELLOW, CValue.FOUR));
		super.add(new Card(Color.RED, CValue.FIVE));
		super.add(new Card(Color.RED, CValue.FIVE));
		super.add(new Card(Color.BLUE, CValue.FIVE));
		super.add(new Card(Color.BLUE, CValue.FIVE));
		super.add(new Card(Color.GREEN, CValue.FIVE));
		super.add(new Card(Color.GREEN, CValue.FIVE));
		super.add(new Card(Color.YELLOW, CValue.FIVE));
		super.add(new Card(Color.YELLOW, CValue.FIVE));
		super.add(new Card(Color.RED, CValue.SIX));
		super.add(new Card(Color.RED, CValue.SIX));
		super.add(new Card(Color.BLUE, CValue.SIX));
		super.add(new Card(Color.BLUE, CValue.SIX));
		super.add(new Card(Color.GREEN, CValue.SIX));
		super.add(new Card(Color.GREEN, CValue.SIX));
		super.add(new Card(Color.YELLOW, CValue.SIX));
		super.add(new Card(Color.YELLOW, CValue.SIX));
		super.add(new Card(Color.RED, CValue.SEVEN));
		super.add(new Card(Color.RED, CValue.SEVEN));
		super.add(new Card(Color.BLUE, CValue.SEVEN));
		super.add(new Card(Color.BLUE, CValue.SEVEN));
		super.add(new Card(Color.GREEN, CValue.SEVEN));
		super.add(new Card(Color.GREEN, CValue.SEVEN));
		super.add(new Card(Color.YELLOW, CValue.SEVEN));
		super.add(new Card(Color.YELLOW, CValue.SEVEN));
		super.add(new Card(Color.RED, CValue.EIGHT));
		super.add(new Card(Color.RED, CValue.EIGHT));
		super.add(new Card(Color.BLUE, CValue.EIGHT));
		super.add(new Card(Color.BLUE, CValue.EIGHT));
		super.add(new Card(Color.GREEN, CValue.EIGHT));
		super.add(new Card(Color.GREEN, CValue.EIGHT));
		super.add(new Card(Color.YELLOW, CValue.EIGHT));
		super.add(new Card(Color.YELLOW, CValue.EIGHT));
		super.add(new Card(Color.RED, CValue.NINE));
		super.add(new Card(Color.RED, CValue.NINE));
		super.add(new Card(Color.BLUE, CValue.NINE));
		super.add(new Card(Color.BLUE, CValue.NINE));
		super.add(new Card(Color.GREEN, CValue.NINE));
		super.add(new Card(Color.GREEN, CValue.NINE));
		super.add(new Card(Color.YELLOW, CValue.NINE));
		super.add(new Card(Color.YELLOW, CValue.SKIP));
		super.add(new Card(Color.RED, CValue.REVERSE));
		super.add(new Card(Color.RED, CValue.REVERSE));
		super.add(new Card(Color.BLUE, CValue.REVERSE));
		super.add(new Card(Color.BLUE, CValue.REVERSE));
		super.add(new Card(Color.GREEN, CValue.REVERSE));
		super.add(new Card(Color.GREEN, CValue.REVERSE));
		super.add(new Card(Color.YELLOW, CValue.REVERSE));
		super.add(new Card(Color.YELLOW, CValue.REVERSE));
		super.add(new Card(Color.RED, CValue.SKIP));
		super.add(new Card(Color.RED, CValue.SKIP));
		super.add(new Card(Color.BLUE, CValue.SKIP));
		super.add(new Card(Color.BLUE, CValue.SKIP));
		super.add(new Card(Color.GREEN, CValue.SKIP));
		super.add(new Card(Color.GREEN, CValue.SKIP));
		super.add(new Card(Color.YELLOW, CValue.SKIP));
		super.add(new Card(Color.YELLOW, CValue.NINE));
		super.add(new Card(Color.RED, CValue.DRAW2));
		super.add(new Card(Color.RED, CValue.DRAW2));
		super.add(new Card(Color.BLUE, CValue.DRAW2));
		super.add(new Card(Color.BLUE, CValue.DRAW2));
		super.add(new Card(Color.GREEN, CValue.DRAW2));
		super.add(new Card(Color.GREEN, CValue.DRAW2));
		super.add(new Card(Color.YELLOW, CValue.DRAW2));
		super.add(new Card(Color.YELLOW, CValue.DRAW2));
		super.add(new Card(Color.BLACK, CValue.WILD));
		super.add(new Card(Color.BLACK, CValue.WILD));
		super.add(new Card(Color.BLACK, CValue.WILD));
		super.add(new Card(Color.BLACK, CValue.WILD));
		super.add(new Card(Color.BLACK, CValue.DRAW4));
		super.add(new Card(Color.BLACK, CValue.DRAW4));
		super.add(new Card(Color.BLACK, CValue.DRAW4));
		super.add(new Card(Color.BLACK, CValue.DRAW4));
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Hand> deal(int players)
	{
		ArrayList<Hand> hands = new ArrayList<Hand>();
		super.shuffle();
		System.out.println(super.toString());
		for(int i = 0; i < players; i++)		//makes a hand and adds the cards to it
		{
			Hand hand = new Hand();
			for(int j = 1; j < 8; j++)		//adds seven cards to the hand
			{
				hand.add(super.removetop());
			}
			hands.add(hand);
		}
		return hands;
	}
}
