package state;

/**
 * @author gongxb
 * @date 2018/7/16
 * @desc
 * @return
 */
public interface State {
    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 根据摇动情况，处理摇动结果，返回处理结果，释放糖果
     */
    void ejectQuarter();

    /**
     * 转动手柄
     */
    void turnCrank();

    /**
     * 释放糖果
     */
    void dispense();
}
