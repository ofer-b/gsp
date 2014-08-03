package org.hp.com;

/**
 * Created by borshtei on 24-Jul-14.
 */
public interface GenericObjectDao<T> {

    public T create(final T t) ;

    public void delete(final Object id) ;

    public T find(final Object id);

    public T update(final T t) ;

}
