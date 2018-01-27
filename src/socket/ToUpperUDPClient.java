package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author gongxb
 *
 * 2018年1月27日 
 */
public class ToUpperUDPClient {
	private DatagramSocket clientSocket;
	
	public void startClient(String ip,int port,String msg) throws IOException {
		try {
			while(true) {
				clientSocket=new DatagramSocket();
				InetAddress serverAddr=InetAddress.getByName(ip);
				byte[] sendBytes=msg.getBytes();
				DatagramPacket sendPack=new DatagramPacket(sendBytes, sendBytes.length,serverAddr,port);
				//发送数据
				clientSocket.send(sendPack);
				
				byte[] recvByte=new byte[ToUpperUDPServer.MAX_SIZE];
				DatagramPacket recvPack=new DatagramPacket(recvByte, recvByte.length);
				//接收从服务端的响应
				clientSocket.receive(recvPack);
				String recvString=new String(recvByte, 0, recvByte.length);
				System.out.println("the messgae client recvive is "+recvString);
				
			}
		}finally {
			clientSocket.close();
			clientSocket=null;
		}
	}
	public static void main(String[] args) throws IOException {
		ToUpperUDPClient client=new ToUpperUDPClient();
		client.startClient(ToUpperUDPServer.SERVER_IP, ToUpperUDPServer.SERVER_PORT, "hahahahahahSSS");
	}
}
