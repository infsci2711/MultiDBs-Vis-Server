package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import org.hibernate.HibernateException;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

/**
 * @author Evgeny
 *
 */
public interface UserManager extends GeneralManager<Users, Integer> {
	
	/**
	 * 
	 * Finds users who has either first or last name, or username containing searchTerm.
	 * 
	 * @param searchTerm to find to be contained in user name.
	 * @param limit the number of users that should be returned.
	 * @return user who satisfy search term. 
	 */
	public List<Users> lookUpUser(String searchTerm, int limit);
	
	/**
	 * @author Hao Bai
	 * Query users' email address.
	 * 
	 * @param userLevel to find to be contained in user level.
	 * @return users' email addresses. 
	 * @throws Exception 
	 */
	public List<String> queryUserEmails(String userLevel) throws HibernateException;
}

