package cnlab;
import java.io.*;
import java.net.*;
public class P5client {

	public static void main(String[] args) {
		DatagramSocket skt;
		try {
			skt = new DatagramSocket();
			String msg = "udp";
			byte[] b = msg.getBytes();
			InetAddress host = InetAddress.getByName("127.0.0.1");
			int serversocket = 6088;
			DatagramPacket request = new DatagramPacket(b, b.length, host, serversocket);
			skt.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			skt.receive(reply);
			System.out.println("client received: " + new String(reply.getData()));
		}
		catch(Exception ex)
		{
			
		}
	}

}
