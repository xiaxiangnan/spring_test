package com.journey.spring.ioc.beanXML;

import java.util.Set;

/**
 *
 * Created by zhangyuan on 16/1/6.
 */
public class Boss {

    private Car car;

    private String name;

    private Set<String> set;

    @Override
    public String toString() {
        return "car: " + getCar().toString() + ", name: " + name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
