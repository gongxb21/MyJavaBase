package nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class TcpServer {
    private static final int bufferSize = 1024;
    private static final int timeOut = 3000;
    private static final int port = 2260;

    public static void main(String[] args) throws IOException {

        //创建选择器
        Selector selector = Selector.open();
        //创建通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        //绑定端口
        channel.socket().bind(new InetSocketAddress(port));

        channel.configureBlocking(false);

        // 将选择器绑定到监听信道,只有非阻塞信道才可以注册选择器.并在注册过程中指出该信道可以进行Accept操作
        //一个server socket channel准备好接收新进入的连接称为“接收就绪”
        channel.register(selector, SelectionKey.OP_ACCEPT);

        TcpProtocol protocol = new TcpProtocolImpl(bufferSize);


        while (true) {
            int key = selector.select(timeOut);
            if (key == 0) {
                System.out.println("独自等待");
                continue;
            }

            Set<SelectionKey> set = selector.selectedKeys();

            Iterator<SelectionKey> keyIt = set.iterator();

            while (keyIt.hasNext()) {
                SelectionKey selectionKey = keyIt.next();

                try {
                    if (selectionKey.isAcceptable()) {
                        System.out.println("acceptable");
                        //该方法在内部，会将interest由OP_ACCEPT改为OP_READ
                        //如果不执行下面的语句，则会一直是accept状态（初始时设置为了accept），无法进入后面的两个if语句
                        //console一直打印上面的语句
                        protocol.handleAccept(selectionKey);
                    }

                    if (selectionKey.isReadable()) {
                        // 从客户端读取数据
                        System.out.println("readable");
                        protocol.handleRead(selectionKey);
                    }

                    if (selectionKey.isValid() && selectionKey.isWritable()) {
                        //客户端连接一次后，N次连续进入该方法
                        //System.out.println("writable");//连续输出
                        protocol.handleWrite(selectionKey);
                    }

                } catch (Exception e) {
                    System.out.println("=====catch a exception===");
                    keyIt.remove();
                    continue;
                }
                //删除处理过的键
                keyIt.remove();
            }

        }


    }


}