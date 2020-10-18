package springrestapi.services;

import java.util.List;

public interface WriteService<T, ID> {
    void deleteAllInBatch();

    void deleteInBatch(Iterable<T> var1);

    void flush();

    <S extends T> S save(S var1);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    <S extends T> S saveAndFlush(S var1);
}
