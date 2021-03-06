package designpattern.observer;


/**
 * @author gongxb
 * @date 2018/7/26
 * @desc 观察者接口的实现类
 * @return
 */
public class User implements Observer {
    private String name;

    public User(String name){
        this.name=name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name+" User get msg:"+msg);
    }

}
