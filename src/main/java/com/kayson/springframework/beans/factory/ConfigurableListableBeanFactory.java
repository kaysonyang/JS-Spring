package com.kayson.springframework.beans.factory;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.kayson.springframework.beans.factory.config.BeanDefinition;
import com.kayson.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author yangxinchu
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
