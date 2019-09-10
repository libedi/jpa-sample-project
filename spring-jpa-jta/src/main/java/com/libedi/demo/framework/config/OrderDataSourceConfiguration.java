package com.libedi.demo.framework.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.libedi.demo.framework.model.CustomRoutingDataSource;
import com.libedi.demo.framework.model.DataSourceProperty;
import com.libedi.demo.framework.type.DataSourceType;
import com.libedi.demo.framework.type.PersistenceUnits;

/**
 * OrderDataSourceConfiguration
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableJpaRepositories(basePackages = "com.libedi.demo.domain.order",
        entityManagerFactoryRef = "orderEntityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class OrderDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("order.datasource") // 실 운영시 order.datasource.master로 변경가능.
    public DataSourceProperty orderDataSourceMasterConfig() {
        return new DataSourceProperty();
    }

    @Bean
    @ConfigurationProperties("order.datasource") // 실 운영시 order.datasource.slave로 변경가능.
    public DataSourceProperty orderDataSourceSlaveConfig() {
        return new DataSourceProperty();
    }

    @Bean
    public DataSource orderDataSource() {
        final Map<Object, Object> dataSourceMap = new HashMap<>();
        final DataSource masterDataSource = createDataSource(orderDataSourceMasterConfig());
        dataSourceMap.put(DataSourceType.WRITABLE, masterDataSource);
        dataSourceMap.put(DataSourceType.READONLY, createDataSource(orderDataSourceSlaveConfig()));

        final CustomRoutingDataSource routingDataSource = new CustomRoutingDataSource();
        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    private DataSource createDataSource(final DataSourceProperty dataSourceConfig) {
        final JdbcDataSource h2XaDataSource = new JdbcDataSource(); // 사용하는 DB에 맞게 변경
        h2XaDataSource.setUrl(dataSourceConfig.getUrl());
        h2XaDataSource.setUser(dataSourceConfig.getName());
        h2XaDataSource.setPassword(dataSourceConfig.getPassword());

        final AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        // 유니트한 이름으로 해도 된다.
        xaDataSource.setUniqueResourceName(h2XaDataSource.getUrl() + UUID.randomUUID().toString());
        xaDataSource.setXaDataSource(h2XaDataSource);
        xaDataSource.setMaxPoolSize(8);
        xaDataSource.setTestQuery("select 1");
        return xaDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean
            orderEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder.dataSource(orderDataSource())
                .packages("com.libedi.demo.domain.order")
                .persistenceUnit(PersistenceUnits.ORDER.toString())
                .jta(true)
                .build();
    }

}
