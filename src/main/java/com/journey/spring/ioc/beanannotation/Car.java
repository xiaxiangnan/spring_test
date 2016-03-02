package com.journey.spring.ioc.beanannotation;

import org.springframework.stereotype.Component;

/**
 *
 * Created by xiaxiangnan on 16/2/24.
 */
@Component("car")
//@Repository DAO类
//@Service Service类
//@Controller Controller类
public class Car {

    private String brand;

    private String color;

    private int maxSpeed;



}
