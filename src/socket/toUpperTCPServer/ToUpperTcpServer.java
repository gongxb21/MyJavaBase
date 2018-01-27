package socket.toUpperTCPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gongxb
 * 2018年1月27日
 */
public class ToUpperTcpServer {
	private ServerSocket serverSocket;
	public static final String SERVER_IP="127.0.0.1";
	public static final int SERVER_PORT=6666;
	public static final char END_FLAG='*';
	public void startServer(String ip,int port) throws IOException {
		try {
			InetAddress address;
			address=InetAddress.getByName(ip);
			serverSocket=new ServerSocket(port, 5, address);
			while(true) {
				StringBuilder builder =new StringBuilder();
				try(Socket connection=serverSocket.accept()){
					InputStream in=connection.getInputStream();
					 //读取客户端的请求字符串，请求字符串以#终结  
                    for (int c = in.read(); c != END_FLAG; c = in.read()) {  
                        builder.append((char)c);  
                    }  
                    builder.append('*');  
                      
                    String recvStr = builder.toString();  
                      
                    //向客户端写出处理后的字符串  
                    OutputStream out = connection.getOutputStream();  
                    System.out.println("server send string "+recvStr);
                    out.write(recvStr.toUpperCase().getBytes());
				}
			}			
		}catch (Exception e) {
			System.out.println("catch a exception "+e.getMessage());
		}finally {
			if(null!=serverSocket) {
				serverSocket.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		ToUpperTcpServer server=new ToUpperTcpServer();
		server.startServer(SERVER_IP, SERVER_PORT);
	}
}
