package com.libedi.demo.framework.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.support.StringObjectMapBuilder;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.libedi.demo.framework.model.DataSourceProperty;
import com.libedi.demo.framework.model.DynamicRoutingDataSource;
import com.libedi.demo.framework.type.DataSourceType;
import com.libedi.demo.framework.type.PersistenceUnits;

/**
 * CustomerDataSourceConfiguration
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 09
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.libedi.demo.repository.customer",
        entityManagerFactoryRef = "customerEntityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class CustomerDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("customer.datasource") // 실 운영시 customer.datasource.master로 변경가능.
    public DataSourceProperty customerDataSourceMasterConfig() {
        return new DataSourceProperty();
    }

    @Bean
    @ConfigurationProperties("customer.datasource") // 실 운영시 customer.datasource.slave로 변경가능.
    public DataSourceProperty customerDataSourceSlaveConfig() {
        return new DataSourceProperty();
    }

    @Bean
    public DataSource customerDataSourceMaster() {
        return createDataSource(customerDataSourceMasterConfig(), "customerDataSourceMaster");
    }

    @Primary
    @Bean
    public DataSource customerDataSource() {
        final Map<Object, Object> dataSourceMap = new HashMap<>();
        final DataSource masterDataSource = createDataSource(customerDataSourceMasterConfig(), "customerDataSourceMaster");
        dataSourceMap.put(DataSourceType.WRITABLE, masterDataSource);
        dataSourceMap.put(DataSourceType.READONLY, createDataSource(customerDataSourceSlaveConfig(), "customerDataSourceSlave"));

        final DynamicRoutingDataSource routingDataSource = new DynamicRoutingDataSource();
        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        routingDataSource.afterPropertiesSet();
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    private DataSource createDataSource(final DataSourceProperty dataSourceConfig, final String uniqueResourceName) {
        final JdbcDataSource h2XaDataSource = new JdbcDataSource();
        h2XaDataSource.setUrl(dataSourceConfig.getUrl());
        h2XaDataSource.setUser(dataSourceConfig.getName());
        h2XaDataSource.setPassword(dataSourceConfig.getPassword());

        final AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        // 유니트한 이름으로 해도 된다.
        xaDataSource.setUniqueResourceName(uniqueResourceName);
        xaDataSource.setXaDataSource(h2XaDataSource);
        xaDataSource.setMaxPoolSize(8);
        xaDataSource.setTestQuery("select 1");
        return xaDataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean
            customerEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder.dataSource(customerDataSource())
                .packages("com.libedi.demo.domain.customer")
                .properties(new StringObjectMapBuilder()
                        .put("javax.persistence.transactionType", "JTA")
                        .put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName())
                        .get())
                .persistenceUnit(PersistenceUnits.CUSTOMER.toString())
                .jta(true)
                .build();
    }

}
