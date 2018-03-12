package ge.springfw.services;

import java.util.List;

/**
 * Created by kranthi on 15-Jul-16
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
