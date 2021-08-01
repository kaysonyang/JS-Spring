package com.kayson.springframework.beans.factory.support;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangxinchu
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingletons(beanName, bean);
        return bean;
    }
}
