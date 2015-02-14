package edu.pitt.sis.infsci2711.multidbs.vis.test.account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class accountTestDAO {

	public static List<accountTestDBModel> findAll() throws SQLException, Exception {
		
		try (Connection connection = accountTestUtil.getConnection()) {
			String sql = "SELECT * FROM pratise";
			try (Statement statement = connection.createStatement()){
				
				ResultSet resultSet = statement.executeQuery(sql);
				
				List<accountTestDBModel> result = new ArrayList<accountTestDBModel>();
				
				while (resultSet.next()) {
					result.add(new accountTestDBModel(resultSet.getString(1), resultSet.getString(2)));					 
				}
				
				return result;
			}
		}
		
	}
	
	public static boolean findByUserName(final String UserName) throws SQLException, Exception {
		
		try (Connection connection = accountTestUtil.getConnection()) {
			String sql = "SELECT * FROM practise where UserName = " + UserName;
			try (Statement statement = connection.createStatement()){
				
				ResultSet resultSet = statement.executeQuery(sql);
				
				if (resultSet.next()) {
					return true;					 
				}
				
				return false;
			}
		}
		
	}
	
	public static int save(final accountTestDBModel practise) throws SQLException, Exception {
		
		try (Connection connection = accountTestUtil.getConnection()) {
			String sql = String.format("INSERT INTO practise (UserName, Pin) VALUES ('%s', '%s')", practise.getUserName(), practise.getPin());
			try (Statement statement = connection.createStatement()){
				
				int res = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()){
					practise.setUserName(rs.getString(1));
				}
				
				return res;
			}
		}
	}}
		
		
	
