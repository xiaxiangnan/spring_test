package com.journey.spring.ioc.beanXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * xml参数注入
 * Created by zhangyuan on 16/1/6.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc-beanXML.xml");
        Boss boss = applicationContext.getBean("boss", Boss.class);
        System.out.println(boss);
        Boss bossAutowire = applicationContext.getBean("bossAutowire", Boss.class);
        System.out.println(bossAutowire);
        Boss boss1 = applicationContext.getBean("boss1", Boss.class);
        System.out.println(boss1);

        Boss childBoss = applicationContext.getBean("childBoss", Boss.class);
        System.out.println("childBoss: " + childBoss.getSet());

        List list = applicationContext.getBean("list", ArrayList.class);
        System.out.println("list: " + list);

        MagicBoss magicBoss = applicationContext.getBean("magicBoss", MagicBoss.class);
        System.out.println(magicBoss);

        Boss boss2 = applicationContext.getBean("boss2", Boss.class);
        System.out.println(boss2);

        Car carFactoryBean = applicationContext.getBean("carFactoryBean", Car.class);
        CarFactoryBean carFactoryBeanObj = applicationContext.getBean("&carFactoryBean", CarFactoryBean.class);
        System.out.println(carFactoryBean);
        System.out.println(carFactoryBeanObj.getClass());

    }

}
