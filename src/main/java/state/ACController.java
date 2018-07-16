package state;

import lombok.ToString;
import org.junit.Test;

/**
 * @author gongxb
 * @date 2018/7/16
 * @desc 空调的控制器
 * @return
 */
@ToString
public class ACController {
    private int  state=0;

    public int getState(){
        return this.state;
    }

    /**
     * 按下电源键
     */

    public void power(){

        if(0==state){
            state=1;
            System.out.println("0->1");
        }else if(1==state){
            state=0;
            System.out.println("1->0");
        }else{
            state=0;
            System.out.println("other->0");
        }

    }



    /**
     * 按制冷键
     */
    public void cool(){
        if(state==0){
            //off
            System.out.println("do nothing");
        }else if(state==1){
            //fan only
            state=2;
            System.out.println("1->2");
        }else{
            state=1;
            System.out.println("other ->1");
        }
    }

    @Test
    public void testState(){
        ACController acController=new ACController();
        System.out.println("init state="+acController.getState());
        acController.cool();
        acController.power();
        acController.cool();
        acController.cool();
        acController.power();
        acController.cool();
    }


}
