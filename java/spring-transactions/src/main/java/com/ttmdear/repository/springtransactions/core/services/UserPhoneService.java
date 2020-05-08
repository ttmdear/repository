package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.UserPhone;
import com.ttmdear.repository.springtransactions.core.domain.UserRole;
import com.ttmdear.repository.springtransactions.core.repositories.UserPhoneRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPhoneService {
    private final UserPhoneRespository userPhoneRespository;

    public UserPhoneService(UserPhoneRespository userPhoneRespository) {
        this.userPhoneRespository = userPhoneRespository;
    }

    public <S extends UserPhone> S save(S s) {
        return userPhoneRespository.save(s);
    }

    public <S extends UserPhone> Iterable<S> saveAll(Iterable<S> iterable) {
        return userPhoneRespository.saveAll(iterable);
    }

    public Optional<UserPhone> findById(String s) {
        return userPhoneRespository.findById(s);
    }

    public boolean existsById(String s) {
        return userPhoneRespository.existsById(s);
    }

    public Iterable<UserPhone> findAll() {
        return userPhoneRespository.findAll();
    }

    public Iterable<UserPhone> findAllById(Iterable<String> iterable) {
        return userPhoneRespository.findAllById(iterable);
    }

    public long count() {
        return userPhoneRespository.count();
    }

    public void deleteById(String s) {
        userPhoneRespository.deleteById(s);
    }

    public void delete(UserPhone userPhone) {
        userPhoneRespository.delete(userPhone);
    }

    public void deleteAll(Iterable<? extends UserPhone> iterable) {
        userPhoneRespository.deleteAll(iterable);
    }

    public void deleteAll() {
        userPhoneRespository.deleteAll();
    }
}
