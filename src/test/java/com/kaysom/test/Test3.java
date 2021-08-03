package com.kaysom.test;

import com.kaysom.test.bean.ProductService;
import com.kaysom.test.bean.UserDao;
import com.kayson.springframework.beans.PropertyValue;
import com.kayson.springframework.beans.PropertyValues;
import com.kayson.springframework.beans.factory.config.BeanDefinition;
import com.kayson.springframework.beans.factory.config.BeanReference;
import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;

public class Test3 {
    public static void main(String[] args) {
        // 1.init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. ProductService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. ProductService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(ProductService.class, propertyValues);
        beanFactory.registerBeanDefinition("productService", beanDefinition);

        // 5. ProductService 获取bean
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        productService.queryUserInfo();
    }
}
