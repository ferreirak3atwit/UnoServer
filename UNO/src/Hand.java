
public class Hand extends Pile{
	
	public boolean playable(Card card) {
		int x = 0;
		boolean playable = false;
		CValue topval = card.getValue();//top card in middle
		Color topcolor = card.getColor();//color of top card
		while (x < this.Length()) {
			CValue val = super.getC(x).getValue();
			Color cardcolor = super.getC(x).getColor();
			if(val.compareTo(topval)==0 || cardcolor.compareTo(topcolor)==0) {
				playable = true;
				break;
			}
			x++;
		}
		
		return playable;
	}

	
	public boolean OneCard() {
		boolean uno = false;
		if (super.Length()==1) {
			uno = true;
		}else uno = false;
		return uno;
	}
	
	@Override 
	public String toString() {
		int x = 0;
		String s = "";
		while (x < this.Length()) {
			s += "[ " + x + " "+ super.getC(x).getColor()+ " "+ super.getC(x).getValue()+" ]";
			x++;
		}
		return s;
	}
}
