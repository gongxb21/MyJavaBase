package lambda;

/**
 * @author gongxb
 * @date 2018/5/19
 * @desc
 * @return
 */
public class LambdaTest {
    /*   (params) -> expression
         (params) -> statement
         (params) -> { statements }*/
    static  String aaa="aaa";
    final static  String bbb="bbb";
    public static void main(String[] args) {
        LambdaTest tt=new LambdaTest();
        MathOperation add=(int a,int b)->a+b;
        MathOperation sub=(a, b)->a-b;
        MathOperation multi=(a, b) ->{ return a*b;};
        MathOperation div=(a, b)->a/b;
        System.out.println("10 + 5 = " + tt.operate(10, 5, add));
        System.out.println("10 - 5 = " + tt.operate(10, 5, sub));
        System.out.println("10 x 5 = " + tt.operate(10, 5, multi));
        System.out.println("10 / 5 = " + tt.operate(10, 5, div));

        GreetingService greeting =(name)-> System.out.println("helloworld"+name);
        GreetingService greeting2 =name-> System.out.println("helloworld"+name);

        GreetingService greeting3=(name)-> System.out.println(aaa+name);
        GreetingService greeting4=(name)-> System.out.println(bbb+name);

        greeting.sayMessage("hahaah");
        greeting2.sayMessage("gongxb");
        greeting3.sayMessage("haha");
        greeting4.sayMessage("hello");

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
