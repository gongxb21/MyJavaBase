package designpattern.flyweight;

/**
 * @author gongxb
 * @date 2018/7/29
 * @desc
 * @return
 */
public class NokiaPhone implements CellPhone {
    private String brand;
    private String useAge;

    public NokiaPhone(String useAge) {
        System.out.println("create a new Nokia Phone for "+useAge);
        this.brand = "NOKIA";
        this.useAge=useAge;
    }

    /**
     * 打电话功能
     */
    @Override
    public void call() {
        System.out.println(this.brand+"can "+useAge);
    }
}
