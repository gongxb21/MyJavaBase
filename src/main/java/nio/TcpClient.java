package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class TcpClient {

    private Selector selector;
    SocketChannel channel;
    private String hostIp;
    /**
     * 要连接的远程服务器在监听的端口
     */

    private int port;


    public TcpClient(String hostIp, int port) throws IOException {
        this.hostIp = hostIp;
        this.port = port;
        init();
    }

    /**
     * 初始化函数
     *
     * @throws IOException
     */
    public void init() throws IOException {
        channel = SocketChannel.open(new InetSocketAddress(hostIp, port));
        channel.configureBlocking(false);
        selector = Selector.open();
        channel.register(selector, SelectionKey.OP_WRITE);
        //启动读取线程
        new TcpClientReadThread(selector);
    }

    /**
     * 发送消息
     *
     * @param msg
     * @throws IOException
     */
    public void sendMsg(String msg) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes("UTF-16"));

        int r = channel.write(buffer);

        System.out.println("write return =" + r);

    }

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient("127.0.0.1", 2260);
        int maxSize = 10;
        for (int i = 0; i < maxSize; i++) {
            client.sendMsg("nio" + i + "hellowrold");
        }
    }
}
