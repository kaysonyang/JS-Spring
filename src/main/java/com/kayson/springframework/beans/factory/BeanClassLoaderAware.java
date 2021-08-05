package com.kayson.springframework.beans.factory;

/**
 * @author yangxinchu
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}