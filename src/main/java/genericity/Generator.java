package genericity;

/**
 * @author gongxb
 * @date 2018/7/19
 * @desc 泛型接口
 * @return
 */
public interface Generator<T> {

    /**
     * print方法
     *
     * @param t
     * @return
     */
    T print(T t);
}

