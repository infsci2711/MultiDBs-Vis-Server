package edu.pitt.sis.infsci2711.multidbs.vis.dal.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;
 
/**
 *
 * @author leonidas
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
 
    protected Session getSession() throws HibernateException {
        return HibernateUtil.getSession();
    }
 
    /**
	 * Saves provided entity in the database.
	 * 
	 * @param entity to be saved in the database.
     * @throws Exception 
	 */
    @Override
	@SuppressWarnings("unchecked")
	public ID save(final T entity) throws HibernateException {
        Session hibernateSession = this.getSession();
        return (ID) hibernateSession.save(entity);
    }
    
    /**
	 * Saves provided entity in the database.
	 * 
	 * @param entity to be saved in the database.
     * @throws Exception 
	 */
    @Override
	public void saveOrUpdate(final T entity) throws HibernateException {
        Session hibernateSession = this.getSession();
        hibernateSession.saveOrUpdate(entity);
    }
 
    /**
	 * 
	 * @param entity
     * @throws Exception 
	 */
    @Override
	@SuppressWarnings("unchecked")
	public T merge(final T entity) throws HibernateException {
        Session hibernateSession = this.getSession();
        
		return (T) hibernateSession.merge(entity);
    }
 
    /**
     * Deletes provided entity.
     * 
     * @param entity to be deleted from database.
     * @throws Exception 
     */
    @Override
	public void delete(final T entity) throws HibernateException {
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }
 
    /**
     * Find all entities which satisfy provided query.
     * 
     * @param query to run to find the entities.
     * @return list of found entities.
     */
    @Override
	@SuppressWarnings("unchecked")
	public List<T> findMany(final Query query) {
        List<T> t;
        t = query.list();
        return t;
    }
 
    /**
     * Find only one entity.
     * 
     * @param query to run to find the entity.
     * @return the found entity.
     */
    @Override
	@SuppressWarnings("unchecked")
	public T findOne(final Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
    }
 
    /**
     * Find only one entity by id.
     * 
     * @param clazz of entity to be found.
     * @param id to search for.
     * @return found entity.
     * @throws Exception 
     */
    @Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findByID(final Class clazz, final ID id) throws HibernateException {
        Session hibernateSession = this.getSession();
        T t = null;
        t = (T) hibernateSession.get(clazz, id);
        return t;
    }
 
    /**
     * Get all entities.
     * 
     * @param clazz of entities to be returned.
     * @return all found entities.
     * @throws Exception 
     */
    @Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(@SuppressWarnings("rawtypes") final Class clazz) throws HibernateException {
        Session hibernateSession = this.getSession();
        List<T> result = null;
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        result = query.list();
        return result;
    }
    
}
