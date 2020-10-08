package com.lizza.spring_04_annotation.annotation_01.service.impl;

import com.lizza.spring_04_annotation.annotation_01.dao.UserDao;
import com.lizza.spring_04_annotation.annotation_01.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * spring IoC 注解
 * XML配置形式：
 * <bean id="" class="" scope="" init-method="" destroy-method="">
 *     <property name="" value="" | ref=""></property>
 * </bean>
 *
 * spring IoC注解：
 *
 *   用于创建对象的注解：同bean标签
 *     @Component: spring 通用组件的注解；
 *     @Controller: spring 表现层组件注解
 *     @Service: spring 服务层组件注解
 *     @Repository: spring 持久层组件注解
 *       属性：value，用于指定组件的id，默认为类的名称，且首字母小写
 *
 *   用于注入数据的注解：同property标签
 *     @Autowired: 自动按照类型注入，只要spring容器中有唯一的一个类型与被注入的bean类型相同的bean对象时，就可以注入成功
 *       1. 如果容器中没有对应类型的bean时，则报NoUniqueBeanDefinitionException异常
 *       2. 容器中有多个对应类型的bean时，用变量名称作为id在spring容器中查找对应的bean，若没有则报NoUniqueBeanDefinitionException异常
 *     @Qualifier: 按照类型注入的基础上再按照bean的id去注入
 *       1. 在给类成员注入时，不能单独使用
 *       2. 在给方法参数注入时，可以单独使用
 *       3. 属性value，用于指定bean的id
 *     @Resource: 按照id注入，可以独立使用
 *     总结：以上的三个注解只能注入其他bean类型的数据，而不能注入基本类型和String类型的数据，另外集合
 *          类型的数据只能使用XML来注入
 *     @Value: 用于注入String类型和基本类型的数据，在注解的属性值中可以使用SpEL（Spring的el表达式），即：${表达式}
 *       1. 属性：value，用于指定属性的值
 *
 *   用于描述作用范围的注解：同scope属性
 *     @Scope: 指定bean的作用范围，常用取值：singleton，prototype；默认singleton
 *
 *   用于配置生命周期的注解：同init-method和destroy-method属性
 *     @PostConstruct: 用于指定初始化的方法，执行完构造器之后会执行，可以注解多个
 *     @PreDestroy: 用于指定销毁方法
 */
@Component
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("UserService Construct Method!");
    }

    @PostConstruct
    public void init() {
        System.out.println("UserService init!");
    }

//  @Autowired
//  @Qualifier("userDao2")
    @Resource(name = "userDao2")
    private UserDao userDao;

    @Override
    public void saveUser(){
        userDao.saveUser();
    }
}
