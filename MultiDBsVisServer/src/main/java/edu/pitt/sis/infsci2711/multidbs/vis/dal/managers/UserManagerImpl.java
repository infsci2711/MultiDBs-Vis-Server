package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.UsersDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.UsersDAOImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;

/**
 * @author Evgeny
 *
 */
public class UserManagerImpl extends GeneralManagerImpl<UsersDAO, Users, Integer> implements UserManager {

	Logger logger = LogManager.getLogger(UserManagerImpl.class.getName());
	
	public UserManagerImpl() {
		super(new UsersDAOImpl(), Users.class);
	}

	//***************************************
	// From UserManager interface
	//***************************************
	
	@Override
	public List<Users> lookUpUser(final String searchTerm, final int limit) {
		try {
            HibernateUtil.beginTransaction();
            
            List<Users> result = _dao.lookUpUser(searchTerm, limit);
            
            HibernateUtil.commitTransaction();
            
            return result;
        } catch (NonUniqueResultException ex) {

        	HibernateUtil.rollbackTransaction();
        	
        	logger.error("save failed NonUniqueResultException", ex);
            throw ex;
        } catch (HibernateException ex) {

        	HibernateUtil.rollbackTransaction();
        	
        	logger.error("save failed HibernateException", ex);
        	throw ex;
        }
	}
	
	@Override
	public List<String> queryUserEmails(final String userLevel){
		try {
            HibernateUtil.beginTransaction();
            
            List<String> result = _dao.queryUserEmails(userLevel);
            
            HibernateUtil.commitTransaction();
            
            return result;
        } catch (NonUniqueResultException ex) {

        	HibernateUtil.rollbackTransaction();
        	
        	logger.error("save failed NonUniqueResultException", ex);
            throw ex;
        } catch (HibernateException ex) {

        	HibernateUtil.rollbackTransaction();
        	
        	logger.error("save failed HibernateException", ex);
        	throw ex;
        }
	}
}
