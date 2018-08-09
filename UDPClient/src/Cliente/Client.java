package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			  
		      DatagramSocket clientSocket = new DatagramSocket();
		   
		      InetAddress IPAddress = InetAddress.getByName("localhost");
		      byte[] sendData = new byte[1024];
		      byte[] receiveData = new byte[1024];
		      
		      String sentence = "Que horas são ? ";
		      sendData = sentence.getBytes();
		      
		      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		      clientSocket.send(sendPacket);
		      
		      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		      clientSocket.receive(receivePacket);
		      
		      String modifiedSentence = new String(receivePacket.getData());
		      System.out.println("Horario do servidor:" + modifiedSentence);
		      clientSocket.close();
	}

}
