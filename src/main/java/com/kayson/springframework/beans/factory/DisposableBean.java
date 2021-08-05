package com.kayson.springframework.beans.factory;

/**
 * @author yangxinchu
 */
public interface DisposableBean {
    /**
     * do something after the bean is destroyed
     */
    void destroy() throws Exception;
}
