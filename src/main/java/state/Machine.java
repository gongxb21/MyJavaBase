package state;

/**
 * @author gongxb
 * @date 2018/7/16
 * @desc
 * @return
 */
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

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public void setState(State state) {
        this.state = state;
    }
}

