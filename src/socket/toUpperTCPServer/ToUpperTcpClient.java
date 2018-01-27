package socket.toUpperTCPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ27ÈÕ
 */
public class ToUpperTcpClient {
	private  Socket clientSocket;
	
	public void startClient(String ip, int port,String msg) throws IOException, InterruptedException {
		while(true) {
			Thread.sleep(1000);
		try {
			clientSocket=new Socket(ip, port);
			StringBuilder builder=new StringBuilder();
			OutputStream output=clientSocket.getOutputStream();
			output.write(msg.getBytes());
			
			
			InputStream input=clientSocket.getInputStream();
			/*for(int c=input.read();c!='*';c=input.read()) {
				builder.append((char)c);
			}*/
			for (int c = input.read(); c != '*'; c = input.read()) {  
                builder.append((char)c);  
            }  
			System.out.println("client get  String "+builder.toString());
		} catch (Exception e) {
			System.out.println("catch a exception "+e.getMessage());
		}finally {
			if(clientSocket!=null) {
				clientSocket.close();  
			}
		}
		}
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		ToUpperTcpClient client=new ToUpperTcpClient();
		client.startClient(ToUpperTcpServer.SERVER_IP, ToUpperTcpServer.SERVER_PORT,"qwertyadfsd*");
	}
}
