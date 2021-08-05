package com.kayson.springframework.beans.factory;

import com.kayson.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
