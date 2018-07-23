package socket.toUpperTCPServer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author gongxb
 * <p>
 * 2018��1��28��
 */
public class HeartBeatPack {
    /**
     * send hreart beat package
     * <p>
     * void
     */
    public static void sendHeartBeatPack() {
        Timer heartBeater = new Timer();
        TimerTask beat = new TimerTask() {
            @Override
            public void run() {
                ToUpperTcpClient client = new ToUpperTcpClient();
                try {
                    //	client.startClient(ToUpperTcpServer.SERVER_IP, ToUpperTcpServer.SERVER_PORT, "this is heartBeatPack\r");
                    System.out.println("this is a heartBeatPackage" + System.currentTimeMillis());
                } catch (Exception e) {
                    System.out.println("catch a exception");
                }
            }
        };

        heartBeater.schedule(beat, 2000, 1000);
    }

    public static void main(String[] args) {
        System.out.println("start time is" + System.currentTimeMillis());
        sendHeartBeatPack();
    }
}
