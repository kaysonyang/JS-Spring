package com.kaysom.test;

import com.kaysom.test.bean.ProductService;
import com.kayson.springframework.beans.factory.config.BeanDefinition;
import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test2 {
    public static void main(String[] args) {
        test_BeanFactory();
    }
    public static void test_BeanFactory() {
        // init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(ProductService.class);
        beanFactory.registerBeanDefinition("productService", beanDefinition);

        // 3.获取bean
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService.getProductName());
    }


    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        ProductService productService = ProductService.class.newInstance();
        System.out.println(productService);
    }


    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProductService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"apple"});
        System.out.println(obj);
    }


    @Test
    public void test_constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ProductService> userServiceClass = ProductService.class;
        Constructor<ProductService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        ProductService productService = declaredConstructor.newInstance("strawberry");
        System.out.println(productService);
    }

    @Test
    public void test_parameterTypes() throws Exception {
        Class<ProductService> beanClass = ProductService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[1];
        Constructor<ProductService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        ProductService productService = declaredConstructor.newInstance("lemon");
        System.out.println(productService);
    }
}
