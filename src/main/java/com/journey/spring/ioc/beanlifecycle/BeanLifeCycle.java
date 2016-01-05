package com.journey.spring.ioc.beanlifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * bean生命周期
 * Created by zhangyuan on 16/1/1.
 */
public class BeanLifeCycle {

    //ApplicationContext会通过反射机制自动识别配置文件中的BeanPostProcessor等，自动注册到应用上下文。
    private static void lifeCycleInApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ioc-beanlifecycle.xml");
        Car car1 = applicationContext.getBean("car", Car.class);
        car1.introduce();

    }

    private static void lifeCycleInBeanFactory() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:ioc-beanlifecycle.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器中注册MyInstantiationAwareBeanPostProcessorAdapter后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessorAdapter());

        //第一次从容器中获取car，将触发容器实例化该bean，这将引发bean的生命周期方法的调用
        Car car1 = beanFactory.getBean("car", Car.class);
        car1.introduce();
        car1.setColor("红色");

        //第二次从容器中取bean，直接从缓存中取
        Car car2 = beanFactory.getBean("car", Car.class);

        System.out.println("car1==car2: " + (car1 == car2));

        ((ConfigurableBeanFactory) beanFactory).destroySingletons();

    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
        System.out.println("------------------this is 分割线------------------------------");
        lifeCycleInApplicationContext();
    }

//    调用InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation
//    调用Car()构造函数。
//    调用InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation
//    调用InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues
//    调用setBrand()设置属性。
//    调用BeanNameAware的setBeanName方法
//    调用BeanFactoryAware的setBeanFactory方法
//    调用BeanPostProcessor的postProcessBeforeInitialization方法，color为空，设置默认为黑色

//    调用InitializingBean的afterPropertiesSet方法
//    调用init-method所指定的myInit()，将maxSpeed设置为240。
//    调用BeanPostProcessor的postProcessAfterInitialization方法，将maxSpeed 240 调整为200
//    brand: 宝马X6, color: 黑色, maxSpeed: 200
//    car1==car2: true
//    调用DisposableBean的destroy方法
//    调用destroy-method所指定的myDestroy()。

//    ------------------this is 分割线------------------------------

//    调用BeanFactoryPostProcessor的postProcessBeanFactory。
//    调用Car()构造函数。
//    调用setBrand()设置属性。
//    调用BeanNameAware的setBeanName方法
//    调用BeanFactoryAware的setBeanFactory方法
//    调用BeanPostProcessor的postProcessBeforeInitialization方法，color为空，设置默认为黑色

//    调用InitializingBean的afterPropertiesSet方法
//    调用init-method所指定的myInit()，将maxSpeed设置为240。
//    调用BeanPostProcessor的postProcessAfterInitialization方法，将maxSpeed 240 调整为200
//    brand: 奇瑞QQ, color: 黑色, maxSpeed: 200

}
