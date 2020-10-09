package com.lizza.spring_06_tx.tx_02_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-04-06
 */
@Configuration
@ComponentScan("com.lizza")
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

}
