package com.kayson.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Object factory for any Resource conforming to the JavaBean spec.
 * This factory can be configured in a <Context> element in your conf/server.xml configuration file. An example of factory configuration is:
 *    <Resource name="jdbc/myDataSource" auth="SERVLET"
 *      type="oracle.jdbc.pool.OracleConnectionCacheImpl"/>
 *    <ResourceParams name="jdbc/myDataSource">
 *      <parameter>
 *        <name>factory</name>
 *        <value>org.apache.naming.factory.BeanFactory</value>
 *      </parameter>
 *      <parameter>
 *        <name>driverType</name>
 *        <value>thin</value>
 *      </parameter>
 *      <parameter>
 *        <name>serverName</name>
 *        <value>hue</value>
 *      </parameter>
 *      <parameter>
 *        <name>networkProtocol</name>
 *        <value>tcp</value>
 *      </parameter>
 *      <parameter>
 *        <name>databaseName</name>
 *        <value>XXXX</value>
 *      </parameter>
 *      <parameter>
 *        <name>portNumber</name>
 *        <value>NNNN</value>
 *      </parameter>
 *      <parameter>
 *        <name>user</name>
 *        <value>XXXX</value>
 *      </parameter>
 *      <parameter>
 *        <name>password</name>
 *        <value>XXXX</value>
 *      </parameter>
 *      <parameter>
 *        <name>maxLimit</name>
 *        <value>5</value>
 *        </parameter>
 *    </ResourceParams>
 * @author yangxinchu
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition definition) {
        beanDefinitionMap.put(name, definition);
    }
}
