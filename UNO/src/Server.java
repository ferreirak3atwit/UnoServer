import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;


public class Server {
	boolean running = true;
	static ServerIO serverIO;
	static String s;
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static Deck deck = new Deck();//self explanatory
	private static Pile discard = new Pile();//make discard pile
	private static final int maxp = 6;//set max players
	private static Card topcard;//top card in middle
	private static int direction =1;
	private static int playerindex = 0;
	private static int playernumber = 0;
	private static boolean skip = false;
	
	
	
	public static void draw(int draw, Card card) throws IOException {
		getindex();
		Player currentplayer = players.get(playerindex);
		boolean stack = false;
		int i = 0;
		if (card.compValue(new Card(Color.BLACK, CValue.DRAW2))==0) {
			for (i = 0; i <currentplayer.gethand().Length(); i++) {
				Card c = currentplayer.gethand().getC(i);
				if (c.compValue(new Card(Color.BLACK, CValue.DRAW2))==0) {
					stack = true;
					break;
				}
			}
		}
		
		if (stack) {
			s = currentplayer +" stacks a DRAW2";
			System.out.println(s);
			sendtoAll();
			discard.addtop(currentplayer.gethand().remove(i));
			topcard = discard.gettop();
			draw(draw+2, card);
		}else {
			s = currentplayer +" draws "+draw+ " cards.";
			System.out.println(s);
			sendtoAll();
			for (int j = 0; j < draw; j++) {
				if (deck.isEmpty()) {
					for(int x = 0; x < discard.Length(); x++)		//removes cards from discard pile and adds them to the deck
						deck.add(discard.remove(x));
						deck.shuffle();
				}
				s = " "+ deck.gettop();
				System.out.println(s);
				sendtoAll();
				currentplayer.draw(deck.removetop());
			}
		}
	}
	
	
	
	private static ArrayList<Integer> getplayable(Hand phand){
		ArrayList<Integer> cards = new ArrayList<>();
		for (int i = 0; i < phand.Length(); i++) {
			if(phand.getC(i).compareTo(topcard)==0||phand.getC(i).getColor()==Color.BLACK) {
				cards.add(i);
			}
		}
		
		return cards;
	}
	
	private static void changecolor() throws IOException {
		
		String color  = "white";
		s = "Choose a color (Red, Blue, Green, Yellow)";
		sendplayer(players.get(playerindex));
		
		while(!color.equals("red") && !color.equals("blue") && !color.equals("yellow") && !color.equals("green")) {
			DatagramPacket packet = serverIO.getPacket();
			if(packet != null && packet.getPort() == players.get(playerindex).getport())
			{
				String packetMessage = new String(packet.getData());
				packetMessage = packetMessage.substring(0, packet.getLength());
				color = packetMessage.toLowerCase();
				System.out.print(color);
				if(!color.equals("red") && !color.equals("blue") && !color.equals("yellow") && !color.equals("green") && packetMessage.length() > 0)
				{
					s = "That is an invalid color.\nChoose a color (Red, Blue, Green, Yellow) ";
					sendplayer(players.get(playerindex));
				}
			}
		}
		switch(color) {
		case "red" : topcard = new Card(Color.RED, CValue.WILD); 
		break;
		case "blue" : topcard = new Card(Color.BLUE, CValue.WILD); 
		break;
		case "green" : topcard = new Card(Color.GREEN, CValue.WILD); 
		break;
		case "yellow" : topcard = new Card(Color.YELLOW, CValue.WILD); 
		break;
		}
		s = "Color changed to " + topcard.getColor();
		System.out.println(s);
		sendtoAll();
	}
	
	private static void getindex() {
		playerindex = getin();
	}
	
	private static int getin() {
		return (playerindex + direction)%players.size() == -1 ? players.size() : (playerindex + direction) % players.size();
 	}
	
	private static void reverse()
	{
		direction *= -1;		
		switch(playerindex)	
		{
			case 0: playerindex= players.size()-1; break;
			default: playerindex = 0; break;
		}
	}
	
	public static void sendplayer(Player index) throws IOException {
		serverIO.sendpkt(new DatagramPacket(s.getBytes(), s.getBytes().length, index.getIP(), index.getport()));
	}
	
	public static void sendtoAll() throws IOException
	{
		for(int i = 0; i < players.size(); i++)
		{
			serverIO.sendpkt(new DatagramPacket(s.getBytes(), s.getBytes().length, players.get(i).getIP(), players.get(i).getport()));
		}
	}
	
	public static void initializegame() throws IOException {
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Enter number of players ");
			playernumber = in.nextInt();
			if(playernumber > maxp || playernumber < 2) {
				System.out.println("Error: Game can handle between 2 and 6 players!");
			}
		}while(playernumber > maxp|| playernumber < 2);
			
		System.out.println("Initializing");
		ArrayList<Hand> hands = deck.deal(playernumber);
		System.out.println("Players Joining...");
		int x = playernumber;
		
		while (x > 0) {
			DatagramPacket pkt = serverIO.getPacket();
			if (pkt != null) {
				String msg = new String(pkt.getData());
				msg = msg.substring(0, pkt.getLength());
				if (msg.toLowerCase().equals("joined")) {
					String playername = "Enter name in provided format within parentheses (name: yourname) ";
					 serverIO.sendpkt(new DatagramPacket(playername.getBytes(), playername.getBytes().length, pkt.getAddress(), pkt.getPort()));
				}else if (msg.contains("name:")) {
					String result = "true";
					serverIO.sendpkt(new DatagramPacket(result.getBytes(), result.getBytes().length, pkt.getAddress(), pkt.getPort()));
					String pname = msg.substring(msg.indexOf(':'), msg.length());
					System.out.println(pname + " joined the game.");
					players.add(new Player(pkt.getAddress(), pkt.getPort(), pname, hands.get(x-1) ));
				x--;
				}else {
					String result = ":";
					serverIO.sendpkt(new DatagramPacket(result.getBytes(), result.getBytes().length, pkt.getAddress(), pkt.getPort()));
				}
			}
		}//end while 
		
		s = "Everyone has joined time to start";
		sendtoAll();
		
		System.out.println("Players: ");
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).toString());
		}
		
		//time to make first card in play
		Card card = deck.removetop();
		while (card.iswild()) {
			deck.add(card);
			card = deck.removetop();
		}
		discard.add(card);//put first card in play from deck
	}//end initial
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int port = 0;
		
		System.out.println("Enter port number");
		port = in.nextInt();
		serverIO = new ServerIO(port);
		initializegame();
	
		boolean skip =  false;
		System.out.println("Time to Play UNO!");
		System.out.println("Deck initialized length: "+deck.Length());
		sendtoAll();
		topcard = discard.gettop();
		
		int endnumber = players.size()-1;
		while (players.size()>endnumber) {
			for (playerindex = 0; playerindex < players.size() && playerindex>=0; playerindex+= direction) {
				Player current = players.get(playerindex);
				
				s = "\n" + topcard + " is on top ";
				System.out.println(s);
				sendtoAll();
				s = current +"'s turn\n ";
				System.out.println(s);
				sendtoAll();
				
				if (!current.gethand().playable(topcard)){
					if (deck.isEmpty()) {
						for(int j = 0; j < discard.Length(); j++)		//removes cards from discard pile and adds them to the deck
							deck.add(discard.remove(j));
							deck.shuffle();
					}
					current.draw(deck.removetop());
					s = current + " can't play a card so they drew 1 card";
					System.out.println(s);
					sendtoAll();
					break;
				}
				s = "Your hand: " + current.gethand().toString();
				sendplayer(current);
				
				if(current.gethand().playable(topcard)) {
					s = "Card #'s "+ getplayable(current.gethand())+ " are playable";
					sendplayer(current);
					s = "Select a card # to play.";
					sendplayer(current);
					int chosen =-100;
					
					while (chosen != -1 && !getplayable(current.gethand()).contains(chosen)) {
						DatagramPacket pkt = serverIO.getPacket();
						if (pkt != null && pkt.getPort() == current.getport()) {
							String pktmsg = new String(pkt.getData());
							pktmsg = pktmsg.substring(0, pkt.getLength());
							chosen = Integer.parseInt(pktmsg);
							System.out.println(chosen);
							if (chosen != -1 && !getplayable(current.gethand()).contains(chosen)) {
								s = "Error: you chose a number that cant be played!\nSelect a card # to play.";
								sendplayer(current);
							}
						}
					}//end while
					if (chosen == -1) {
						current.draw(deck.removetop());
						s = current + " passes turn. Draws 1 " + current.gethand().gettop();
						System.out.println(s);
						sendtoAll();
						
					}else {
						Card chosencard = current.gethand().getC(chosen);
						s = current+ " played " + chosencard;
						System.out.println(s);
						sendtoAll();
						discard.addtop(current.gethand().remove(chosen));
						topcard = discard.gettop();
						
						if(chosencard.iswild()) {
							switch (chosencard.getValue()) {
							case REVERSE: reverse();
							break;
					
							case SKIP: getindex();
							s = players.get(playerindex)+ " was skipped";
							System.out.println(s);
							sendtoAll();
							skip = true;
							break;
							
							case WILD: changecolor();
							break;
							
							case DRAW2: draw(2, chosencard);
							break;
							
							case DRAW4: changecolor(); draw(4, chosencard);
							break;
							
							default: 
							break;
							}//switch
						}//if
					}//else		
				}//if
				
				if (current.gethand().OneCard()) {
					s = current + " calls uno!";
					System.out.println(s);
					sendtoAll();
				}
				
				if (current.gethand().isEmpty()) {
					s = current + " has won! Thanks for playing! now exiting...";
					System.out.println(s);
					sendtoAll();
					System.exit(0);
				}
				skip = false;
			}//end for
		}
		
	}//end main
}
