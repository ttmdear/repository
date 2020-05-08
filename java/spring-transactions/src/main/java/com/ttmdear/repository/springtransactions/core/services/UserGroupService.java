package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.UserGroup;
import com.ttmdear.repository.springtransactions.core.repositories.UserGroupRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGroupService {
    private final UserGroupRespository userGroupRespository;

    public UserGroupService(UserGroupRespository userGroupRespository) {
        this.userGroupRespository = userGroupRespository;
    }

    public <S extends UserGroup> S save(S s) {
        return userGroupRespository.save(s);
    }

    public <S extends UserGroup> Iterable<S> saveAll(Iterable<S> iterable) {
        return userGroupRespository.saveAll(iterable);
    }

    public Optional<UserGroup> findById(UserGroup.UserGroupId userGroupId) {
        return userGroupRespository.findById(userGroupId);
    }

    public boolean existsById(UserGroup.UserGroupId userGroupId) {
        return userGroupRespository.existsById(userGroupId);
    }

    public Iterable<UserGroup> findAll() {
        return userGroupRespository.findAll();
    }

    public Iterable<UserGroup> findAllById(Iterable<UserGroup.UserGroupId> iterable) {
        return userGroupRespository.findAllById(iterable);
    }

    public long count() {
        return userGroupRespository.count();
    }

    public void deleteById(UserGroup.UserGroupId userGroupId) {
        userGroupRespository.deleteById(userGroupId);
    }

    public void delete(UserGroup userGroup) {
        userGroupRespository.delete(userGroup);
    }

    public void deleteAll(Iterable<? extends UserGroup> iterable) {
        userGroupRespository.deleteAll(iterable);
    }

    public void deleteAll() {
        userGroupRespository.deleteAll();
    }
}
