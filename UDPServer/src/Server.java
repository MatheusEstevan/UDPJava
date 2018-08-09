import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true)
           {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              String sentence = new String( receivePacket.getData());
              System.out.println("RECEIVED: " + sentence);
              InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              System.out.println(sentence);
              
              Calendar cal = Calendar.getInstance();
              SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");                            
              String time = sdf.format(cal.getTime()).toString();
              System.out.println(time);
              sendData = time.getBytes();
              
              DatagramPacket sendPacket =
              new DatagramPacket(sendData, sendData.length, IPAddress, port);
              serverSocket.send(sendPacket);
           }
	}

}
