package com.kayson.springframework.beans.factory.config;


import lombok.Data;

/**
 * A BeanDefinition describes a bean instance, which has property values, constructor argument values, and further information supplied by concrete implementations.
 * This is just a minimal interface: The main intention is to allow a BeanFactoryPostProcessor to introspect and modify property values and other bean metadata.
 *
 * @author kayson
 */
@Data
public class BeanDefinition {

    /*** version 1 */
    //private Object bean;
    /*** version 2 */
    private Class beanClass;

    public BeanDefinition(Class bean) {
        this.beanClass = bean;
    }


}
