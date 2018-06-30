import java.util.Stack;

/**
 * @author gongxb
 * @date 2018/6/17
 * @desc 用Java语言实现go 语言defer
 * @return
 */
public class DeferJava {
    public static Stack<Object> stack=new Stack();
    public static void defer(Object obj) {
        stack.push(obj);
    }

    public static void doDefer(){
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }


    public static void main(String[] args) {
        try {
            defer(1);
            defer("q");

            System.out.println("hello");
            defer("world");

            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                defer(i);
            }


            defer("end");
        }finally {
            doDefer();
        }


    }

}
