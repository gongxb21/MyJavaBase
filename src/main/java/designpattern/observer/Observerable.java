package designpattern.observer;

/**
 * @author gongxb
 * @date 2018/7/26
 * @desc 被观察者接口
 * @return
 */
public interface Observerable {
    void registerObserver(Observer obj);
    void removeObserver(Observer obj);
    void notifyObserver();
}
