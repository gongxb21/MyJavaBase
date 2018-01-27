package socket.toUpperTCPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxb
 *
 *         2018年1月27日
 */
public class ToUpperTcpServerConcurrent {
	private ServerSocket serverSocket;
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 6666;
	public static final char END_FLAG = '*';

	public void startServer(String ip, int port) throws IOException {
		try {
			InetAddress address = InetAddress.getByName(ip);
			serverSocket = new ServerSocket(port, 5, address);
			StringBuilder builder = new StringBuilder();
			while (true) {
				Socket clientSocket = serverSocket.accept();

				// 开启线程池
				Executor pool = Executors.newFixedThreadPool(100);
				pool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						Socket con = clientSocket;
						try {
							InputStream in = con.getInputStream();
							for (int c = in.read(); c != END_FLAG; c = in.read()) {
								builder.append((char)c);
							}
							builder.append(END_FLAG);
							System.out.println("server get String "+builder.toString());
							OutputStream out = con.getOutputStream();
							out.write(builder.toString().toUpperCase().getBytes());
							out.flush();

						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							if (con != null) {
									try {
										con.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
							}
						}
					}
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}
	}
	public static void main(String[] args) throws IOException {
		ToUpperTcpServerConcurrent server=new ToUpperTcpServerConcurrent();
		server.startServer(SERVER_IP, SERVER_PORT);
	}
}
