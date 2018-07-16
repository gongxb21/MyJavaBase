package state;

/**
 * @author gongxb
 * @date 2018/7/16
 * @desc
 * @return
 */
public class SoldOutState implements State {
    private Machine machine;

    public SoldOutState(Machine machine){
        this.machine=machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("please wait ,we are already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry ,you have turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("turning twice does not get you another gumball");
    }

    @Override
    public void dispense() {
        machine.releaseBall();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoQuarterState());
        } else {
            System.out.println("Out of Gumballs!");
            machine.setState(machine.getSoldOutState());
        }

    }
}
