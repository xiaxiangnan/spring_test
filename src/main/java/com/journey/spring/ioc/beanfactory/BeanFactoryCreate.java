package com.journey.spring.ioc.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 *
 * Created by zhangyuan on 15/12/30.
 */
public class BeanFactoryCreate {

    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beanfactory.xml");
        //1. 通过BeanFactory启动IOC并不会初始化xml中的bean，初始化发生在第一次调用
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Car car = beanFactory.getBean("car1", Car.class);

        //2. ApplicationContext 在初始化上下文时就实例化了所有单例Bean
        ApplicationContext ctx1 = new ClassPathXmlApplicationContext("beanfactory.xml");
        car = ctx1.getBean("car1", Car.class);

        // 基于类注解的配置方式
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Beans.class);
        car = ctx2.getBean("car1", Car.class);

        // WebApplicationContext web.xml配置

        System.out.println("car is rdy for use: " + car.getBrand());
    }

    @Configuration
    static class Beans {

        @Bean(name="car1")
        public Car buildCar() {
            Car car = new Car();
            car.setBrand("宝马X6");
            car.setColor("black");
            car.setMaxSpeed(400);
            return car;
        }
    }

}
