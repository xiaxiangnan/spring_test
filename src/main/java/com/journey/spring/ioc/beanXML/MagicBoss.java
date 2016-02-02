package com.journey.spring.ioc.beanXML;

/**
 *
 * lookup-method注入后相当于
 *  public class MagicBossImple impl ..{
 *     public Car getCar() {
 *       return (Car) applicationContext.getBean("car1");
 *     }
 *  }
 *
 * Created by zhangyuan on 16/1/14.
 */
public interface MagicBoss {

    Car getCar();



}
