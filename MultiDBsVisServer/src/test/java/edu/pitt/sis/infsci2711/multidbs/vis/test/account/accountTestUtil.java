package edu.pitt.sis.infsci2711.multidbs.vis.test.account;
import java.sql.Connection;
import java.sql.DriverManager;

public class accountTestUtil {
	public static final String DEFAULT_HOST = "localhost";
	
	public static final int DEFAULT_PORT =  8889;
	
	public static final String DEFAULT_USER = "root"; 
	
	public static final String DEFAULT_PASSWOD = "root"; 
	
	public static final String DEFAULT_DATABASE = "practise";
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.accountTest.Driver");
		
		return DriverManager.getConnection(getConnectionString(), DEFAULT_USER, DEFAULT_PASSWOD);
	}
	
	public static String getConnectionString() {
		return String.format("accountTest:mysql://%s:%d/%s", DEFAULT_HOST, DEFAULT_PORT, DEFAULT_DATABASE);
	}
}
