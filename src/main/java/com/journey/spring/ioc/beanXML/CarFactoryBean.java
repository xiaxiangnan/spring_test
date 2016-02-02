package com.journey.spring.ioc.beanXML;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 * Created by zhangyuan on 16/2/2.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setColor(infos[1]);
        car.setMaxSpeed(Integer.parseInt(infos[2]));
        return car;
    }

    public Class<Car> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
