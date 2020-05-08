package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.UserRole;
import com.ttmdear.repository.springtransactions.core.repositories.UserRoleRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleService {
    private final UserRoleRespository userRoleRespository;


    public UserRoleService(UserRoleRespository userRoleRespository) {
        this.userRoleRespository = userRoleRespository;
    }

    public <S extends UserRole> S save(S s) {
        return userRoleRespository.save(s);
    }

    public <S extends UserRole> Iterable<S> saveAll(Iterable<S> iterable) {
        return userRoleRespository.saveAll(iterable);
    }

    public Optional<UserRole> findById(String s) {
        return userRoleRespository.findById(s);
    }

    public boolean existsById(String s) {
        return userRoleRespository.existsById(s);
    }

    public Iterable<UserRole> findAll() {
        return userRoleRespository.findAll();
    }

    public Iterable<UserRole> findAllById(Iterable<String> iterable) {
        return userRoleRespository.findAllById(iterable);
    }

    public long count() {
        return userRoleRespository.count();
    }

    public void deleteById(String s) {
        userRoleRespository.deleteById(s);
    }

    public void delete(UserRole userRole) {
        userRoleRespository.delete(userRole);
    }

    public void deleteAll(Iterable<? extends UserRole> iterable) {
        userRoleRespository.deleteAll(iterable);
    }

    public void deleteAll() {
        userRoleRespository.deleteAll();
    }
}
