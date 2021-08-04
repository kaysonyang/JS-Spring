package com.kayson.test.common;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.PropertyValue;
import com.kayson.springframework.beans.PropertyValues;
import com.kayson.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.kayson.springframework.beans.factory.config.BeanDefinition;
import com.kayson.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
