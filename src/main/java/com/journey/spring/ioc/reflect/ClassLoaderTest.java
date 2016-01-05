package com.journey.spring.ioc.reflect;

/**
 * 类加载器
 * Created by zhangyuan on 15/12/23.
 */
public class ClassLoaderTest {


    /**
     * JVM运行时产生3个ClassLoader：
     * 根装载器：C++编写，java中看不到。负责装载JRE核心类库（rt.jar等）
     * ExtClassLoader（扩展类）：负责装载JRE扩展目录ext中的JAR类包
     * AppClassLoader（系统类）：负责装载CLASSPATH路径下的类包
     * <p/>
     * 装载顺序：（全盘负责委托机制，除非显示的指定ClassLoader）1.根装载器；2.ExtClassLoader；3.AppClassLoader
     */
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

//        这句话没有执行类的初始化，相当于Class.forName("xx.xx"，false，loader)
        classLoader.loadClass("com.journey.spring.ioc.reflect.A");
//        初始化了类，相当于Class.forName("xx.xx"，true，loader)
        Class.forName("com.journey.spring.ioc.reflect.B");

        System.out.println("current class loader:" + classLoader);
        System.out.println("parent class loader:" + classLoader.getParent());
        System.out.println("grandparent class loader: " + classLoader.getParent().getParent());
    }

}

class A {
    static {
        System.out.println("---------init A Class");
    }
}

class B {
    static {
        System.out.println("----------init B Class");
    }
}