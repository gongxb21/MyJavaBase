package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxb
 * @date 2018/7/26
 * @desc 具体的被观察者
 * @return
 */
public class WechatServer implements  Observerable {

    private List<Observer> list;
    private String msg;

    public WechatServer(){
        list=new ArrayList<>(10);
    }

    /**
     * 添加观察者
     * @param obj
     */
    @Override
    public void registerObserver(Observer obj) {
        list.add(obj);
    }

    /**
     * 删除观察者
     * @param obj
     */
    @Override
    public void removeObserver(Observer obj) {
        if(!list.isEmpty()){
            list.remove(obj);
        }
    }

    /**
     * 通知观察者
     */
    @Override
    public void notifyObserver() {
        list.stream()
                .forEach(obj->obj.update(msg));
    }

    /**
     * 设置消息，这里是这个代码最巧妙的地方，在设置消息的时候，巧妙的去通知客户。
     * 其实好像也没有那么巧妙，只是自己没有想到这个点
     * @param msg
     */
    public void setMsg(String msg){
        this.msg=msg;
        System.out.println("WechatServer更新消息："+msg);
        this.notifyObserver();
    }
}
