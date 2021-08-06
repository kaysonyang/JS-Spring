package com.kayson.springframework.beans.factory;

/**
 * @author yangxinchu
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
