package sk.stuba.fei.uim.vsa.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IDao<T> {

    Optional<T> get(Long id);

    List<T> getAll();

    List<T> find(String query, Map<String, Object> parameters);

    void save(T t);

    void delete(T t);

    void close();

}
