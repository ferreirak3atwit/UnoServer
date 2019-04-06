import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class unoclient {
	
	
	private static Client socket;
	static boolean up = true;
		
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int port; String ip;
		boolean joined =  false;
		
		System.out.println("Enter IP address of host: ");
		ip = in.nextLine();
		System.out.println("Enter the port: ");
		port = in.nextInt();
		
		socket = new Client(ip,port);
		
		System.out.println("Joining Server...");
		socket.sendmsg("joined");
		
		while (!joined) {
			DatagramPacket pkt = socket.getpacket();
			if (pkt != null) {
				String pktmsg = new String(pkt.getData());
				pktmsg = pktmsg.substring(0, pkt.getLength());
				if (pktmsg.toLowerCase().equals("true")) {
					System.out.println("Joined game");
					joined = true;
				}else {
					System.out.println(pktmsg);
					String s = in.nextLine();
					socket.sendmsg(s);
				}
			}
		}
		
		
		while (up) {
			DatagramPacket packet = socket.getpacket();
			if (packet!=null) {
				String pkt = new String(packet.getData());
				pkt = pkt.substring(0, packet.getLength());
				if (pkt.equals("Select a card # to play.") || 
						pkt.equals("Error: you chose a number that cant be played!\nSelect a card # to play.")) {
					System.out.println(pkt);
					int x = in.nextInt();
					String msg = x+"";
					socket.sendmsg(msg);
				}else if (pkt.equals("Choose a color (Red, Blue, Green, Yellow)")|| pkt.equals("That is an invalid color.\nChoose a color (Red, Blue, Green, Yellow) ")) {
					System.out.println(pkt);
					String msg = in.nextLine();
					socket.sendmsg(msg);
				}else System.out.println(pkt);
				
			}//end null if
			
		}//end while
		
	}
	
}
