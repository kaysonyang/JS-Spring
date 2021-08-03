package com.kayson.springframework.beans.factory.support;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Policies for instantiating beans  eg:cglib or DeclaredConstructor
 * @author yangxinchu
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
