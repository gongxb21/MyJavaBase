package designpattern.observer;


/**
 * @author gongxb
 * @date 2018/7/26
 * @desc 被观察者接口
 * @return
 */
public interface Observerable {
    /**
     * 添加观察者
     * @param obj
     */
    void registerObserver(Observer obj);

    /**
     * 去除观察者
     * @param obj
     */
    void removeObserver(Observer obj);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
