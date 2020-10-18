package springrestapi.services;

import java.util.List;
import java.util.Optional;
import javax.validation.ValidationException;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.TransactionSystemException;

public class ReadWriteServiceImpl<T, ID> implements ReadWriteService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public ReadWriteServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public long count() {
        return repository.count();
    }

    public <S extends T> long count(Example<S> example) {
        return repository.count(example);
    }

    public void delete(T t) {
        repository.delete(t);
    }

    public void deleteAll(Iterable<? extends T> iterable) {
        repository.deleteAll(iterable);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {
        repository.deleteInBatch(iterable);
    }

    public <S extends T> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public <S extends T> Page<S> findAll(Example<S> example,
        Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<T> findAllById(Iterable<ID> iterable) {
        return repository.findAllById(iterable);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public <S extends T> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public T getOne(ID id) {
        return repository.getOne(id);
    }

    public <S extends T> S save(S s) {
        try {
            return repository.save(s);
        } catch (TransactionSystemException e) {
            if (e.getRootCause() instanceof ValidationException) {
                throw (ValidationException) e.getRootCause();
            } else {
                throw e;
            }
        }
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> iterable) {
        try {
            return repository.saveAll(iterable);
        } catch (TransactionSystemException e) {
            if (e.getRootCause() instanceof ValidationException) {
                throw (ValidationException) e.getRootCause();
            } else {
                throw e;
            }
        }
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        try {
            return repository.saveAndFlush(s);
        } catch (TransactionSystemException e) {
            if (e.getRootCause() instanceof ValidationException) {
                throw (ValidationException) e.getRootCause();
            } else {
                throw e;
            }
        }
    }
}
