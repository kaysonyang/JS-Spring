package com.kayson.springframework.context.support;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.config.BeanPostProcessor;
import com.kayson.springframework.context.ApplicationContext;
import com.kayson.springframework.context.ApplicationContextAware;

/**
 * @author yangxinchu
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
