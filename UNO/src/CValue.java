
public enum CValue {
	ZERO(0,false),ONE(1,false),TWO(2,false),THREE(3,false),FOUR(4,false),FIVE(5,false),SIX(6,false),SEVEN(7,false),	EIGHT(8,false),	NINE(9,false),	WILD(10,true),	REVERSE(11,true),SKIP(12,true),DRAW2(13,true),DRAW4(14,true);         
	
	private final int value;
	private final boolean wild;
	
	
	CValue(int val, boolean wild){
		this.value= val; 
		this.wild= wild;
	}
	public boolean getW() {
		return wild;
	}
	
	public int getV() {
		return value;
	}
}
