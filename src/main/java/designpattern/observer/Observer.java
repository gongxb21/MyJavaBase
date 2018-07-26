package designpattern.observer;

/**
 * @author gongxb
 * @date 2018/7/26
 * @desc 观察者接口
 * @return
 */
public interface Observer {
    /**
     * 更新
     * @param msg
     */
    void update(String msg);
}
