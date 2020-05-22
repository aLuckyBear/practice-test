import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * @author ：shujie
 * @date ：2020/04/11
 * @description:
 */
public class Test<T> {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);


    public static void main(String[] args) {

        ThreadLocal<Dog> local = new ThreadLocal<>();
        Dog dog = new Dog();
        dog.setTest(111);

        local.set(dog);
        Dog dog1 = local.get();

        System.out.println("dog = " + JSON.toJSONString(dog1));

        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);

        Test<Number> test = new Test();

//        test.showKeyValue1(gInteger);
        test.showKeyValue1(gNumber);

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();

    }

    public <T, E> T show(E e) {
        return null;
    }

    public void showkey(T genericObj){

    }


    public void showKeyValue1(Generic<T> object) {

    }




}