package com.kayson.springframework.beans.factory.support;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.core.io.Resource;
import com.kayson.springframework.core.io.ResourceLoader;

/**
 * @author yangxinchu
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;

}
