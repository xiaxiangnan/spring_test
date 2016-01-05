package com.journey.spring.ioc.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean后处理器
 * Created by zhangyuan on 16/1/1.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            Car car = (Car) bean;
            if(car.getColor() == null) {
                System.out.println("调用BeanPostProcessor的postProcessBeforeInitialization方法，color为空，设置默认为黑色");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            Car car = (Car) bean;
            if(car.getMaxSpeed() > 200) {
                System.out.println("调用BeanPostProcessor的postProcessAfterInitialization方法，将maxSpeed " + car.getMaxSpeed() + " 调整为200");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
