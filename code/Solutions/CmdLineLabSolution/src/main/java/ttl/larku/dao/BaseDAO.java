/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.dao;

import java.util.List;

/**
 * @param <T>
 * @author anil
 */
public interface BaseDAO<T> {

    public boolean update(T updateObject);

    public boolean delete(T deleteObject);

    public T create(T newObject);

    public T get(int id);

    public List<T> getAll();

    public void deleteStore();

    public void createStore();
}
