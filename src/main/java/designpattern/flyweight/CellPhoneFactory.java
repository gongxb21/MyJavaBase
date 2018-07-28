package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gongxb
 * @date 2018/7/29
 * @desc
 * @return
 */
public class CellPhoneFactory {
    private Map<String, CellPhone> cellPhones = new HashMap<>(10);

    /**
     * 根据手机功能获取手机
     * @param useAge
     * @return
     */
    public CellPhone getCellPhone(String useAge) {
        CellPhone cp = cellPhones.get(useAge);
        if (null != cp) {
            return cp;
        }
        cellPhones.put(useAge, new NokiaPhone(useAge));
        return getCellPhone(useAge);
    }

    /**
     * 查看cellPhones中的内容
     */
    public void  getCellPhones() {
        System.out.println(cellPhones.size());
        cellPhones.forEach((k,v)->{
            System.out.println(k);
        });
    }
}
