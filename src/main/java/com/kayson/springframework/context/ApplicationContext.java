package com.kayson.springframework.context;

import com.kayson.springframework.beans.factory.HierarchicalBeanFactory;
import com.kayson.springframework.beans.factory.ListableBeanFactory;
import com.kayson.springframework.core.io.ResourceLoader;

/**
 * @author yangxinchu
 */
public interface ApplicationContext extends ListableBeanFactory , HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher  {
}
