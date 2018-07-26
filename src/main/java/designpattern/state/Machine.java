package designpattern.state;

import lombok.Getter;
import lombok.Setter;

/**
 * @author gongxb
 * @date 2018/7/16
 * @desc
 * @return
 */
@Getter
@Setter
public class Machine {

    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;

    private State state;
    private int count = 0;

    public Machine(int count) {
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.count = count;
        if (this.count > 0) {
            this.state = noQuarterState;
        }
    }


    public void releaseBall() {
        System.out.println("the gumball is comming");
        if (count > 0) {
            count -= 1;

        }
    }

    public void insertQuerter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
}

