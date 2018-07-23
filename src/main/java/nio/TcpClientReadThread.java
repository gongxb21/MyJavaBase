package nio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class TcpClientReadThread implements Runnable {

    private Selector selector;

    public TcpClientReadThread(Selector selector) {
        this.selector = selector;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (selector.select() > 0) {
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        buffer.flip();

                        String recStr = Charset.forName("UTF-16").newDecoder().decode(buffer).toString();
                        // 控制台打印出来
                        System.out.println("接收到来自服务器" + sc.socket().getRemoteSocketAddress() + "的信息:" + recStr);
                        key.interestOps(SelectionKey.OP_READ);

                    }
                    selector.selectedKeys().remove(key);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
