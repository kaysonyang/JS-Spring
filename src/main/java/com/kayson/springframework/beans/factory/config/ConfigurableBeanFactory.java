package com.kayson.springframework.beans.factory.config;

import com.kayson.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author yangxinchu
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
