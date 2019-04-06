import java.net.*;
import java.io.IOException;


public class Client {
	DatagramPacket packet; DatagramSocket clientsocket; int port; InetAddress serverIP; byte[] data;
	
	Client (String IPaddress, int port) throws SocketException, UnknownHostException {
		this.port= port;
		serverIP = InetAddress.getByName(IPaddress);
		clientsocket = new DatagramSocket();
	}//end client
	
	public DatagramPacket getpacket() throws IOException {
		data = new byte[9999];
		packet = new DatagramPacket(data, data.length);
		clientsocket.receive(packet);
		return packet;
	}
	
	public void sendmsg(String line) throws IOException {
		data = line.getBytes();
		
		packet = new DatagramPacket(data,data.length, serverIP, port);
		clientsocket.send(packet);
	}
	
	public static void main(String[] args) {
		String s = "Name: name";
		System.out.println(s.substring(0,3));
	}

	
}
