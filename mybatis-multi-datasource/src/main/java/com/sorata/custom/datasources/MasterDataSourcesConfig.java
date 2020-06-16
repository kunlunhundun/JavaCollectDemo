package com.sorata.custom.datasources;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by :  Sorata   2017/6/26 0026 上午 11:02.
 */
@Configuration
@MapperScan(basePackages = MasterDataSourcesConfig.PACKAGES, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourcesConfig {

    static final String PACKAGES = "com.sorata.dao.master";

    private static final String MAPPER_LOCAL = "classpath:mapper/master/*.xml";

    @ConfigurationProperties("spring.datasource")
    @Primary
    @Bean(name = "masterDataSource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }


    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }


}
