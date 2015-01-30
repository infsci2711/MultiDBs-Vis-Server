package edu.pitt.sis.infsci2711.multidbs.vis.dal.dao;

/**
*
* @author leonidas from http://blog.patouchas.net/technology/hibernate-dao-java-tutorial/
*/
import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * Saves provided entity in the database.
	 * 
	 * @param entity to be saved in the database.
	 * @throws Exception 
	 */
	public ID save(T entity) throws HibernateException;
	
	/**
	 * Saves or updates provided entity in the database.
	 * 
	 * @param entity to be saved in the database.
	 * @throws Exception 
	 */
	public void saveOrUpdate(T entity) throws HibernateException;

	/**
	 * NOT SUREWHAT IT DOES :-)
	 * @param entity
	 * @throws Exception 
	 */
    public T merge(T entity) throws HibernateException;

    /**
     * Deletes provided entity.
     * 
     * @param entity to be deleted from database.
     * @throws Exception 
     */
    public void delete(T entity) throws HibernateException;

    /**
     * Find all entities which satisfy provided query.
     * 
     * @param query to run to find the entities.
     * @return list of found entities.
     */
    public List<T> findMany(Query query);

    /**
     * Find only one entity.
     * 
     * @param query to run to find the entity.
     * @return the found entity.
     */
    public T findOne(Query query);

    /**
     * Get all entities.
     * 
     * @param clazz of entities to be returned.
     * @return all found entities.
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	public List<T> findAll(Class clazz) throws HibernateException;

    /**
     * Find only one entity by id.
     * 
     * @param clazz of entity to be found.
     * @param id to search for.
     * @return found entity.
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
    public T findByID(Class clazz, ID id) throws HibernateException;
}


