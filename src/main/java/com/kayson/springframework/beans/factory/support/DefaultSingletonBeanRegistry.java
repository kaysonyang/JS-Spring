package com.kayson.springframework.beans.factory.support;

import com.kayson.springframework.beans.BeansException;
import com.kayson.springframework.beans.factory.DisposableBean;
import com.kayson.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generic registry for shared bean instances, implementing the SingletonBeanRegistry. Allows for registering singleton instances that should be shared for all callers of the registry, to be obtained via bean name.
 * Also supports registration of DisposableBean instances, (which might or might not correspond to registered singletons), to be destroyed on shutdown of the registry. Dependencies between beans can be registered to enforce an appropriate shutdown order.
 * This class mainly serves as base class for org.springframework.beans.factory.BeanFactory implementations, factoring out the common management of singleton bean instances. Note that the org.springframework.beans.factory.config.ConfigurableBeanFactory interface extends the SingletonBeanRegistry interface.
 * Note that this class assumes neither a bean definition concept nor a specific creation process for bean instances, in contrast to AbstractBeanFactory and DefaultListableBeanFactory (which inherit from it). Can alternatively also be used as a nested helper to delegate to.
 * Since:
 * 2.0
 * See Also:
 * registerSingleton, registerDisposableBean, DisposableBean, org.springframework.beans.factory.config.ConfigurableBeanFactory
 * @author kayson
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void  addSingletons(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }


    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
