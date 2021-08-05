package com.kayson.springframework.beans.factory;

/**
 * @author yangxinchu
 */
public interface InitializingBean {
    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
