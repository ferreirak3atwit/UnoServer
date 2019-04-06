
public enum Color {
	BLACK(1),RED(2),BLUE(3), YELLOW(4), GREEN(5);

	private int color;
	
	Color(int color){
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
}
