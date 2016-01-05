package com.journey.spring.ioc.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 *
 * Created by zhangyuan on 16/1/1.
 */
public class MyInstantiationAwareBeanPostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter {

    //实例化bean之前进行调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("调用InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation");
        }
        return null;
    }

    //实例化bean之后进行调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("调用InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation");
        }
        return true;
    }

    //设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("调用InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues");
        }
        return pvs;
    }

}
