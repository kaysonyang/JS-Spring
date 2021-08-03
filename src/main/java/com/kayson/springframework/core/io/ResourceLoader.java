package com.kayson.springframework.core.io;

/**
 * @author yangxinchu
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * load resource
     * @param location
     * @return
     */
    Resource getResource(String location);
}
