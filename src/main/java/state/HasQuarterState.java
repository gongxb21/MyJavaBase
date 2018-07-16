package state;


import lombok.ToString;

/**
 * @author gongxb
 * @date 2018/7/16
 * @desc
 * @return
 */
@ToString
public class HasQuarterState implements State {
    Machine machine;

    public HasQuarterState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you have insert a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("quarter returned ");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you need ..");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
