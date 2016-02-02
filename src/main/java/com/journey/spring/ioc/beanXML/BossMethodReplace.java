package com.journey.spring.ioc.beanXML;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 *
 * Created by zhangyuan on 16/1/14.
 */
public class BossMethodReplace implements MethodReplacer{

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        Car car = new Car();
        car.setBrand("我是替换的");
        return car;
    }
}
