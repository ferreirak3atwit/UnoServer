import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerIO {
	private int port; 
	private DatagramSocket socket;
	private DatagramPacket packet;
	private byte[] data;
	
	
	ServerIO(int port) throws SocketException{
		this.port = port;
		socket = new DatagramSocket(port);
	}
	
	   public DatagramPacket getPacket() throws IOException
	    {
	        data = new byte[10000];
	        packet = new DatagramPacket(data, data.length);
	        socket.receive(packet);
	        return packet;
	    }

	   public void sendpkt(DatagramPacket pkt) throws IOException {
		   socket.send(pkt);
	   }

	   	public int getPort() {
	   		return port;
	   	}
}
