package cnlab;
import java.io.*;
import java.net.*;
public class P5server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket skt = null;
		try {
			skt = new DatagramSocket(6088);
			byte[] buffer = new byte[1000];
			while(true)
			{
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				skt.receive(request);
				String[] message = (new String(request.getData()).split(""));
				byte[] sendMsg = (message[1] + "Network Laboratory").getBytes();
				DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(), request.getPort());
				skt.send(reply);
			}
		}
		catch(Exception ex){
			
		}
	}

}
