package socket.toUpperTCPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author gongxb
 *
 *         2018年1月27日
 */
public class ToUpperTcpClient {
	private Socket clientSocket;

	public void startClient(String ip, int port, String msg) throws IOException, InterruptedException {
		while (true) {
			Thread.sleep(500);
			try {
				//System.out.println("client send msg :"+msg);
				clientSocket = new Socket(ip, port);
				StringBuilder builder = new StringBuilder();
				OutputStream output = clientSocket.getOutputStream();
				output.write(msg.getBytes());
				output.flush();
				InputStream input = clientSocket.getInputStream();
				for (int c = input.read(); c != '*'; c = input.read()) {
					builder.append((char) c);
				}
				System.out.println("client get  String " + builder.toString()+ ":"+new Date().toLocaleString());
				this.sendHeartBeatPack();
			} catch (Exception e) {
				System.out.println("catch a exception " + e.getMessage());
			} finally {
				if (clientSocket != null) {
					clientSocket.close();
				}
			}
		}

	}
	/**
	 * send hreart beat package
	 * 
	 * void
	 */
	public void sendHeartBeatPack() {
		Timer heartBeater=new Timer();
		TimerTask beat=new TimerTask() {
			@Override
			public void run() {
				ToUpperTcpClient client = new ToUpperTcpClient();
				try {
					System.out.println("send a heartBeatPackage"+new Date().toLocaleString());
					//client.startClient(ToUpperTcpServer.SERVER_IP, ToUpperTcpServer.SERVER_PORT, "this is heartBeatPack*");
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		};
		
		heartBeater.schedule(beat,1000,1000);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		ToUpperTcpClient client = new ToUpperTcpClient();
		client.startClient(ToUpperTcpServer.SERVER_IP, ToUpperTcpServer.SERVER_PORT, "qwertyadfsd*");
		//不能把心跳包內容放在下面，因為上面死循環
		//client.sendHeartBeatPack();
	}
}
