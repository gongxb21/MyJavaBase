package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author gongxb
 * <p>
 * 2018��1��27��
 */
public class ToUpperUDPServer {
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 6666;
    //ÿ�δ������󳤶�
    public static final int MAX_SIZE = 1024;

    private DatagramSocket serverSocket;

    public void startServer(String ip, int port) {
        try {
            InetAddress serverAddr = InetAddress.getByName(ip);
            serverSocket = new DatagramSocket(port, serverAddr);
            byte[] recvByte = new byte[MAX_SIZE];

            DatagramPacket recvPack = new DatagramPacket(recvByte, recvByte.length);
            //��ѭ����һֱ����
            while (true) {
                serverSocket.receive(recvPack);

                String receString = new String(recvByte, 0, recvByte.length);
                System.out.println("server recevie the message ,the message is" + receString);

                //�õ��ͻ��˵�IP�Ͷ˿ں�
                InetAddress clientAddr = recvPack.getAddress();
                int clientPort = recvPack.getPort();

                String upperString = receString.toUpperCase();
                byte[] sendBytes = upperString.getBytes();
                DatagramPacket sendPack = new DatagramPacket(sendBytes, sendBytes.length, clientAddr, clientPort);

                serverSocket.send(sendPack);
            }

        } catch (Exception e) {
            System.out.println("catch a exception" + e.getMessage());
        } finally {
            //�ǵùر�Socket  
            if (null != serverSocket) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

    public static void main(String[] args) {
        ToUpperUDPServer server = new ToUpperUDPServer();
        server.startServer(SERVER_IP, SERVER_PORT);
    }
}
