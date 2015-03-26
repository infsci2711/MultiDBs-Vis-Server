package edu.pitt.sis.infsci2711.multidbs.vis.test.utils;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.pitt.sis.exp.colfusion.utils.ConfigManager;
import edu.pitt.sis.exp.colfusion.utils.ResourceUtils;
import edu.pitt.sis.exp.colfusion.utils.StreamUtils;
import edu.pitt.sis.ext.colfusion.docker.utils.DockerImageType;
import edu.pitt.sis.ext.colfusion.docker.utils.DockerTestBase;
import edu.pitt.sis.ext.colfusion.docker.utils.containers.MySQLDockerContainer;
import edu.pitt.sis.ext.colfusion.docker.utils.containers.MySQLDockerContainer.MySQLDockerContainerConnectionInfo;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;

// This is an example how to use docker for unit tests in your project

public class DockerTest extends DockerTestBase {

	/**
	 * Set during {@link #setUp()}
	 */
	protected static MySQLDockerContainer mysqlContainer;
	
	static ConfigManager configMng = ConfigManager.getInstance();
	
	/**
	 * Set's up database for test.
	 * @throws URISyntaxException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@BeforeClass
	public static void setUp() throws Exception {
	
		mysqlContainer = (MySQLDockerContainer) createAndStartContainer(DockerImageType.MYSQL_IMAGE);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		setSystemProperties(mysqlContainer.getMySQLConnectionInfo());
	}
	
	@Before
	public void createDatabase() throws ClassNotFoundException, SQLException, IOException {
		//Creating database
		String colfusionDatabaseName = configMng.getProperty("colfusion.hibernate.default_catalog");
		String sql = makeCreateDatabaseSqlStatement(colfusionDatabaseName);
		executeMySQLUpdateQuery(mysqlContainer.getMySQLConnectionInfo().getConnectionString(), sql);
		
		String dbConectionUrl = mysqlContainer.getMySQLConnectionInfo().getConnectionString(colfusionDatabaseName);
		
		// Creating tables
		createTables(dbConectionUrl);
		insertTestData(dbConectionUrl);
	}
	
	@After
	public void dropDatabase() throws ClassNotFoundException, SQLException {
		//TODO: drop all databases, not just colfusion, but also those create to hold data. Don't drop mysql system databases.
		String sql = String.format("DROP DATABASE IF EXISTS `%s`", 
				configMng.getProperty("colfusion.hibernate.default_catalog"));
		
		executeMySQLUpdateQuery(mysqlContainer.getMySQLConnectionInfo().getConnectionString(), sql);
	}
	
	private void insertTestData(final String dbConnectionUrl) throws ClassNotFoundException, IOException, SQLException {
		InputStream fileContentStream = ResourceUtils.getResourceAsStream(this.getClass(), "databaseAdditionalSetupInserts.sql");
		
		executeUpdateMutliStatementScript(dbConnectionUrl, fileContentStream);
	}
	
	private void executeUpdateMutliStatementScript(final String dbConnectionUrl, final InputStream fileContentStream) throws IOException, ClassNotFoundException, SQLException {
		String fileContentStrOneLine = StreamUtils.toString(fileContentStream).replaceAll("[\\t\\n\\r]+"," ");

		String[] separateSqls = fileContentStrOneLine.split(";");
		
		for (String sql : separateSqls) {
			executeMySQLUpdateQuery(dbConnectionUrl, sql);
		}
	}
	
	/**
	 * @param dbConectionUrl 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws HibernateException
	 * @throws IOException
	 */
	private void createTables(final String dbConectionUrl) throws ClassNotFoundException, SQLException,
			HibernateException, IOException {
		
		// This will trigger hibernate to create tables from mappings
		HibernateUtil.initiSessionFactory();
		HibernateUtil.beginTransaction();
		HibernateUtil.commitTransaction();
	}
	
	/**
	 * @param databaseName 
	 * @return
	 */
	private static String makeCreateDatabaseSqlStatement(final String databaseName) {
		String sql = String.format("CREATE DATABASE IF NOT EXISTS `%s`", databaseName);
		return sql;
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected static void executeMySQLUpdateQuery(final String connectionUrl, final String query) throws ClassNotFoundException,
			SQLException {
		if ("".equals(query)) {
			return;
		}
		
//		logger.info(String.format("About to execute MySQL Update Query at connection %s query: %s", connectionUrl, query));
		
		try (Connection connection = getConnection(connectionUrl)) {
			try (Statement statement = connection.createStatement()){
				
				statement.executeUpdate(query);
			} 
		}
	}
	
	protected static Connection getConnection(final String connectionUrl) throws SQLException {
		return DriverManager.getConnection(connectionUrl, 
				mysqlContainer.getMySQLConnectionInfo().getUserName(), mysqlContainer.getMySQLConnectionInfo().getPasswordt());
	}
	
	/**
	 * @param dockerMySQLConnectionInfo2
	 */
	private static void setSystemProperties(final MySQLDockerContainerConnectionInfo mySQLDockerContainerConnectionInfo) {
		String connectionStringWithSchema = mySQLDockerContainerConnectionInfo.getConnectionString(
				configMng.getProperty("colfusion.hibernate.default_catalog"));
		
		redefineSystemPropertyForClass("colfusion.hibernate.connection.url", connectionStringWithSchema);
		redefineSystemPropertyForClass("colfusion.hibernate.connection.username", mySQLDockerContainerConnectionInfo.getUserName());
		redefineSystemPropertyForClass("colfusion.hibernate.connection.password", mySQLDockerContainerConnectionInfo.getPasswordt());
	}
	
	
	
	@Test
	public void testDocker() throws Exception {
		MySQLDockerContainer mysqlContainer = (MySQLDockerContainer) createAndStartContainer(DockerImageType.MYSQL_IMAGE);
		
		assertNotNull(mysqlContainer);
		
		assertNotNull(mysqlContainer.getMySQLConnectionInfo());
	}
	
     protected Users getTestUser() throws Exception {
		UserManager userMng =  new UserManagerImpl();
		Users user = userMng.findAll().get(0);
		
		return user;
	}
}