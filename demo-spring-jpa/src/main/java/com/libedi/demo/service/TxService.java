/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

/**
 * TxService
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 03. 27
 */
@Slf4j
@Service
public class TxService {

    @Transactional(readOnly = true)
    public void readOnly() {
        log.info("readOnly() - getCurrentTransactionName : {}", String.valueOf(TransactionSynchronizationManager.getCurrentTransactionName()));
        log.info("readOnly() - isCurrentTransactionReadOnly : {}", String.valueOf(TransactionSynchronizationManager.isCurrentTransactionReadOnly()));
        log.info("readOnly() - isActualTransactionActive : {}", String.valueOf(TransactionSynchronizationManager.isActualTransactionActive()));
        notReadOnly();
    }

    @Transactional
    public void notReadOnly() {
        log.info("notReadOnly() - getCurrentTransactionName : {}", String.valueOf(TransactionSynchronizationManager.getCurrentTransactionName()));
        log.info("notReadOnly() - isCurrentTransactionReadOnly : {}", String.valueOf(TransactionSynchronizationManager.isCurrentTransactionReadOnly()));
        log.info("notReadOnly() - isActualTransactionActive : {}", String.valueOf(TransactionSynchronizationManager.isActualTransactionActive()));
    }



}
