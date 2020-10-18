package springrestapi.services;

public interface ReadWriteService<T, ID> extends ReadService<T, ID>, WriteService<T, ID> {
}
