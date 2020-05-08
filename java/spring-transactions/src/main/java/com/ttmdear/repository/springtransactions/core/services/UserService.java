package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.User;
import com.ttmdear.repository.springtransactions.core.repositories.UserRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class UserService {
    private final UserRespository userRespository;
    private final EntityManager entityManager;

    public UserService(UserRespository userRespository, EntityManager entityManager) {
        this.userRespository = userRespository;
        this.entityManager = entityManager;
    }

    Iterable<User> getUsers() {
        return userRespository.findAll();
    }

    public <S extends User> S save(S s) {
        System.out.println("isActualTransactionActive: " + TransactionSynchronizationManager.isActualTransactionActive());

        return userRespository.save(s);
    }

    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return userRespository.saveAll(iterable);
    }

    // @Transactional
    public Optional<User> findById(String s) {
        System.out.println(String.format("%s.entityManager: %s", this.getClass().getSimpleName(), TransactionSynchronizationManager.getCurrentTransactionName()));

        Optional<User> user = userRespository.findById(s);

        // user.get().getRoles().size();
        // user.get().getPhones().size();

        return user;
    }

    public boolean existsById(String s) {
        return userRespository.existsById(s);
    }

    public Iterable<User> findAll() {
        return userRespository.findAll();
    }

    public Iterable<User> findAllById(Iterable<String> iterable) {
        return userRespository.findAllById(iterable);
    }

    public long count() {
        return userRespository.count();
    }

    public void deleteById(String s) {
        userRespository.deleteById(s);
    }

    public void delete(User user) {
        userRespository.delete(user);
    }

    public void deleteAll(Iterable<? extends User> iterable) {
        userRespository.deleteAll(iterable);
    }

    public void deleteAll() {
        userRespository.deleteAll();
    }
}
