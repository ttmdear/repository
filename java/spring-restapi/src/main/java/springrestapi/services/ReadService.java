package springrestapi.services;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

public interface ReadService<T, ID> {
    List<T> findAll();

    List<T> findAll(Sort var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);

    List<T> findAllById(Iterable<ID> var1);

    T getOne(ID var1);
}
