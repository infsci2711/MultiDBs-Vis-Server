package edu.pitt.sis.infsci2711.multidbs.vis.test.account;

import java.sql.SQLException;
import java.util.List;


public class accountTestService {

	public List<accountTestDBModel> getAll() throws SQLException, Exception {
		List<accountTestDBModel> result = accountTestDAO.findAll();
		
		return result;
	}
	
	public static boolean findByUserName(final String UserName) throws SQLException, Exception {
		boolean result = accountTestDAO.findByUserName(UserName);
		
		return result;
	}
	
	public accountTestDBModel add(final accountTestDBModel practise) throws SQLException, Exception {
		accountTestDAO.save(practise);
		
		return practise;
	}
}
