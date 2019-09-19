package com.libedi.demo.framework.model;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.libedi.demo.framework.type.DataSourceType;

/**
 * CustomRoutingDataSource
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TransactionSynchronizationManager.isActualTransactionActive()
                && TransactionSynchronizationManager.isCurrentTransactionReadOnly() == false
                        ? DataSourceType.WRITABLE : DataSourceType.READONLY;
    }

}
