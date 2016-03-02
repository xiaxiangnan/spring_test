package com.journey.spring.ioc.beanjava;

import com.journey.spring.ioc.beanannotation.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 基于java类的配置信息
 * Created by xiaxiangnan on 16/3/2.
 */


// Configuration标注了这个类可以用于spring提供Bean的定义信息
@Configuration
public class JavaConfigTest {

    // bean的名称默认和方法名相同,除非指定name
    @Scope("prototype")
    @Bean(name = "new_car")
    public Car car() {
        Car car = new Car();
        return car;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfigTest.class);
//        applicationContext.register(JavaConfigTest.class);
//        applicationContext.refresh();
        Car car = (Car) applicationContext.getBean("new_car");
        System.out.println(car);

    }

}
