package com.grepiu.dbs.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * DB 설정
 * EnableTransactionManagement 를 통한 tx 설정
 *
 */
@Configuration
@EnableTransactionManagement
public class DBConfig {

  private final ApplicationContext applicationContext;

  public DBConfig(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Bean
  @ConfigurationProperties(prefix="spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/*.xml"));

    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate() throws Exception {
    SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
    return sqlSessionTemplate;
  }
}
