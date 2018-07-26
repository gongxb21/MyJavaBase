package designpattern.observer;

import org.junit.Test;

/**
 * @author gongxb
 * @date 2018/7/26
 * @desc
 * @return
 */
public class ObserverTest {
    @Test
    public void testObserver(){
        WechatServer ws=new WechatServer();
        User user=new User("alpha");
        User beta=new User("beta");
        ws.registerObserver(user);
        ws.registerObserver(beta);
        ws.setMsg("hello World");

    }
}
