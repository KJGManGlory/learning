package com.lizza.spring_01_beanfactory.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-06
 */
public class BeanFactory {

    private static Properties prop;

    private static Map<String, Object> beans;

    static {
        prop = new Properties();
        beans = new HashMap<>();
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("spring_01_beans.properties");
        try {
            prop.load(is);
            Enumeration<Object> keys = prop.keys();
            // 保证创建的是单例bean
            while (keys.hasMoreElements()) {
                String name = keys.nextElement().toString();
                String path = prop.getProperty(name);
                Object object = Class.forName(path).newInstance();
                beans.put(name, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("配置文件初始化失败！");
        }
    }

    public static <T> T getBean(String beanName) {
        return (T) beans.get(beanName);
    }
}
