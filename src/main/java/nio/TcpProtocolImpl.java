package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class TcpProtocolImpl implements TcpProtocol {
    public int bufferSize;

    public TcpProtocolImpl(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public void handleAccept(SelectionKey key) throws IOException {
        SocketChannel channel=((ServerSocketChannel)key.channel()).accept();
        channel.configureBlocking(
                false);
        channel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
    }

    @Override
    public void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel=(SocketChannel)key.channel();
        ByteBuffer buffer=(ByteBuffer)key.attachment();
        buffer.clear();

        long byteRead =channel.read(buffer);
        if(byteRead==-1){
            System.out.println("===没有读取到任何东西====");
            channel.close();
        }else{
            //将缓冲区准备为数据传出状态
            buffer.flip();
            String recString= Charset.forName("UTF-16").newDecoder().decode(buffer).toString();
            System.out.println("接收到来自" + channel.socket().getRemoteSocketAddress() + "的信息:" + recString);


            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            String f = format.format(new Date());
            // 准备发送的文本
            String sendString = "你好,客户端. @" + f + "，已经收到你的信息:" + recString;

            buffer=ByteBuffer.wrap(sendString.getBytes("UTF-16"));
            channel.write(buffer);

            //设置为下一次读取或者是写入做准备
            key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);

        }


    }

    @Override
    public void handleWrite(SelectionKey key) throws IOException {
        System.out.println("====handleWrite===");
    }
}
