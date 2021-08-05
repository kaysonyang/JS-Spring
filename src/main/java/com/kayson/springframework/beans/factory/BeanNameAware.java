package com.kayson.springframework.beans.factory;

/**
 * @author yangxinchu
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}