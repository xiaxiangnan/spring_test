package com.journey.spring.ioc.beanannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * 注解注入
 * Created by xiaxiangnan on 16/2/24.
 */
@Scope("prototype") //默认作用范围为singleton
@Controller
public class Main {

    // 自动注入, false表示即使找不到car也不抛异常,默认为true
    @Autowired(required = false)
    private Car car;

    // 注入名为car,类型为Car的bean
    @Autowired
    @Qualifier("car")
    private Car car2;

    // 通过方法注入
    private Car car3;
    @Autowired
    @Qualifier("car")
    public void setCar3(Car car3) {
        this.car3 = car3;
    }

    //默认匹配类型,可以通过Qualifier指定名称
    private Car car4;
    private Car car5;
    @Autowired
    public void init(@Qualifier("car") Car car4, Car car5) {
        this.car4 = car4;
        this.car5 = car5;
    }

    // 集合类注入,spring会将容器中所有的类型为Plugin的Bean都注入到这个变量中
    @Autowired
    private List<Plugin> plugins;

    // 初始化方法 相当于xml配置中的init-method
    @PostConstruct
    private void init1() {
        System.out.println("init1 execute");
    }

    @PostConstruct
    private void init2() {
        System.out.println("init2 execute");
    }

    // 销毁前执行 相当于xml配置中的destroy-method
    @PreDestroy
    private void destroy() {
        System.out.println("destroy execute");
    }

}
