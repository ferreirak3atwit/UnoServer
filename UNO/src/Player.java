import java.net.InetAddress;

public class Player {
	private String name; private Hand hand;
	private InetAddress ipa;
	private int port;
	
	
	public Player (InetAddress ip, int port, String name, Hand hand) {
		this.ipa = ip;
		this.name = name;
		this.port = port;
		this.hand = hand;
	}
	
	public void draw(Card card) {
		hand.addtop(card);
	}
	public String checkhand() {
		return "UNO";
		//if (hand.uno)
	}
	public Hand gethand() {
		return hand;
	}
	public InetAddress getIP() {
		return ipa;
	}
	public int getport() {
		return port;
	}
	public String getName(){
		return name;
	}
	
}
