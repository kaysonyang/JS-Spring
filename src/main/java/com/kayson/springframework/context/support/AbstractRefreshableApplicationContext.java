package com.kayson.springframework.context.support;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author yangxinchu
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }


    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
