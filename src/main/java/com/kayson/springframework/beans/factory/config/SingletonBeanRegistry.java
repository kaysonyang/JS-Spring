package com.kayson.springframework.beans.factory.config;

/**
 * Interface that defines a registry for shared bean instances. Can be implemented by org.springframework.beans.factory.BeanFactory implementations in order to expose their singleton management facility in a uniform manner.
 * The ConfigurableBeanFactory interface extends this interface.
 * Since:
 * 2.0
 * See Also:
 * ConfigurableBeanFactory, org.springframework.beans.factory.support.DefaultSingletonBeanRegistry, org.springframework.beans.factory.support.AbstractBeanFactory
 * @author yangxinchu
 */
public interface SingletonBeanRegistry {

    /**
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
