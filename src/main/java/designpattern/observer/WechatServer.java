package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxb
 * @date 2018/7/26
 * @desc
 * @return
 */
public class WechatServer implements  Observerable {

    private List<Observer> list;
    private String msg;

    public WechatServer(){
        list=new ArrayList<>(10);
    }

    @Override
    public void registerObserver(Observer obj) {
        list.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        if(!list.isEmpty()){
            list.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        list.stream()
                .forEach(obj->obj.update(msg));
    }


    public void setMsg(String msg){
        this.msg=msg;
        System.out.println("WechatServer更新消息："+msg);
        this.notifyObserver();
    }
}
