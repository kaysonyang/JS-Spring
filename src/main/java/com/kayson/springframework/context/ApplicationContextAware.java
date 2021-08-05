package com.kayson.springframework.context;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.Aware;

/**
 * @author yangxinchu
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}