package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.Engine;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Service
public class TransactionC {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private final EntityManager entityManagerTransaction;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private final EntityManager entityManagerExtended;

    private final EntityManager entityManagerInject;

    public TransactionC(EntityManager entityManagerTransaction, EntityManager entityManagerExtended, EntityManager entityManagerInject) {
        this.entityManagerTransaction = entityManagerTransaction;
        this.entityManagerExtended = entityManagerExtended;
        this.entityManagerInject = entityManagerInject;
    }

    public void checkEntityManager(
            String id,
            Engine engineTransactionOuter,
            Engine engineExtendedOuter,
            Engine engineInjectOuter
    ) {
        Engine engineTransaction = entityManagerTransaction.find(Engine.class, id);
        Engine engineExtended = entityManagerExtended.find(Engine.class, id);
        Engine engineInject = entityManagerInject.find(Engine.class, id);

        System.out.println("TransactionC.engineTransaction == engineTransactionOuter: " + (engineTransaction == engineTransactionOuter));
        System.out.println("TransactionC.engineExtended == engineExtendedOuter: " + (engineExtended == engineExtendedOuter));
        System.out.println("TransactionC.engineInject == engineInjectOuter: " + (engineInject == engineInjectOuter));
    }
}
