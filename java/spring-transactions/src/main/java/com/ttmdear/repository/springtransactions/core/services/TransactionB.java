package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.Engine;
import com.ttmdear.repository.springtransactions.core.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Optional;

@Service
public class TransactionB {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private final EntityManager entityManagerTransaction;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private final EntityManager entityManagerExtended;

    private final EntityManager entityManagerInject;

    private final UserService userService;

    private final TransactionC transactionC;

    public TransactionB(EntityManager entityManagerTransaction, EntityManager entityManagerExtended, EntityManager entityManagerInject, UserService userService, TransactionC transactionC) {
        this.entityManagerTransaction = entityManagerTransaction;
        this.entityManagerExtended = entityManagerExtended;
        this.entityManagerInject = entityManagerInject;
        this.userService = userService;
        this.transactionC = transactionC;
    }

    @Transactional
    public Optional<User> findById(String id) {
        System.out.println(String.format("%s.entityManager: %s", this.getClass().getSimpleName(), TransactionSynchronizationManager.getCurrentTransactionName()));

        return userService.findById(id);
    }

    @Transactional
    public void checkEntityManager(
            String id,
            Engine engineTransactionOuter,
            Engine engineExtendedOuter,
            Engine engineInjectOuter
    ) {
        Engine engineTransaction = entityManagerTransaction.find(Engine.class, id);
        Engine engineExtended = entityManagerExtended.find(Engine.class, id);
        Engine engineInject = entityManagerInject.find(Engine.class, id);

        System.out.println("TransactionB.engineTransaction == engineTransactionOuter: " + (engineTransaction == engineTransactionOuter));
        System.out.println("TransactionB.engineExtended == engineExtendedOuter: " + (engineExtended == engineExtendedOuter));
        System.out.println("TransactionB.engineInject == engineInjectOuter: " + (engineInject == engineInjectOuter));

        System.out.println("C dla wlasnych");
        transactionC.checkEntityManager(id, engineTransaction, engineExtended, engineInject);

        System.out.println("C dla outer");
        transactionC.checkEntityManager(id, engineTransactionOuter, engineExtendedOuter, engineInjectOuter);
    }
}
