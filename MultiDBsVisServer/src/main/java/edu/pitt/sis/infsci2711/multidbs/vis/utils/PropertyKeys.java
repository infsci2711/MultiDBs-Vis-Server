package edu.pitt.sis.infsci2711.multidbs.vis.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to collect all properties for the whole colfusion system. 
 * These properties can be specified either via the config.properties file 
 * or via system properties passed to JVM.
 * 
 * @author Evgeny
 *
 */
public enum PropertyKeys implements IPropertyKeys {
	
	/**
	 * This is used only for testing.
	 */
	COLFUSION_PROPERTIES_SOURCE ("colfusion.properties.source"),
	
	/**
	 * This is used only for testing.
	 */
	COLFUSION_PROPERTIES_TEST_NEVER_EXISTING_PROPERTY ("colfusion.properties.test.never.existing.property"),
	
	COLFUSION_URL ("colfusion.url"),
	
	COLFUSION_STATIC_FILES_ROOT_LOCATION ("colfusion.static_files.root_location"),
	
	COLFUSION_UPLOAD_FILES_FOLDER ("colfusion.upload_files_folder"),
	
	/**
	 * Key for the property of location of the ktr base directory where newly created ktr should be put.
	 */
	COLFUSION_KTR_FOLDER ("colfusion.ktr.folder"),
	
	/**
	 * Key for the property of ktr template file location for transforming csv to database 
	 */
	COLFUSION_KTR_TEMPLATES_CSV_TO_DATABASE ("colfusion.ktr.templates.csv_to_database"),
	
	/**
	 * Key for the property of ktr template file location for transforming excel to database 
	 */
	COLFUSION_KTR_TEMPLATES_EXCEL_TO_DATABASE ("colfusion.ktr.templates.excel_to_database"),

	
	/**
	 * Target FileToDB database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * DatabaseName is the name of the database where the data should be loaded.
	 */
	COLFUSION_DATA_FROM_FILE_DATABASE_DATABASE_NAME_PREFIX ("colfusion.data.from_file_database.database_name_prefix"),

	/**
	 * Target FileToDB database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * UserName is the name user which need to be used to connect to the database.
	 */
	COLFUSION_DATA_FROM_FILE_DATABASE_USERNAME ("colfusion.data.from_file_database.username"),

	/**
	 * Target FileToDB database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Password is the password which need to be used to connect to the database.
	 */
	COLFUSION_DATA_FROM_FILE_DATABASE_PASSWORD ("colfusion.data.from_file_database.password"),

	/**
	 * Target FileToDB database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Server is the URL of the server on which the database is running.
	 */
	COLFUSION_DATA_FROM_FILE_DATABASE_HOST ("colfusion.data.from_file_database.host"),

	/**
	 * Target FileToDB database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Port is the port of the server on which the database is running.
	 */
	COLFUSION_DATA_FROM_FILE_DATABASE_PORT ("colfusion.data.from_file_database.port"),

	/**
	 * Target FileToDB database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Type is the database vendor, e.g. MySQL, MSSQL, etc.
	 */
	COLFUSION_DATA_FROM_FILE_DATABASE_VENDOR ("colfusion.data.from_file_database.vendor"),
	
	
	
	
	/**
	 * Logging database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * DatabaseName is the name of the database where the data should be loaded.
	 */
	COLFUSION_PENTAHO_LOGGING_DATABASE_DATABASE_NAME ("colfusion.pentaho.logging_database.database_name"),

	/**
	 * Logging database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * UserName is the name user which need to be used to connect to the database.
	 */
	COLFUSION_PENTAHO_LOGGING_DATABASE_USERNAME ("colfusion.pentaho.logging_database.username"),

	/**
	 * Logging database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Password is the password which need to be used to connect to the database.
	 */
	COLFUSION_PENTAHO_LOGGING_DATABASE_PASSWORD ("colfusion.pentaho.logging_database.password"),

	/**
	 * Logging database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Server is the URL of the server on which the database is running.
	 */
	COLFUSION_PENTAHO_LOGGING_DATABASE_HOST ("colfusion.pentaho.logging_database.host"),

	/**
	 * Logging database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Port is the port of the server on which the database is running.
	 */
	COLFUSION_PENTAHO_LOGGING_DATABASE_PORT ("colfusion.pentaho.logging_database.port"),

	/**
	 * Logging database is the database where the data should actually be loaded. Currently only one target database is used.
	 * 
	 * Type is the database vendor, e.g. MySQL, MSSQL, etc.
	 */
	COLFUSION_PENTAHO_LOGGING_DATABASE_VENDOR ("colfusion.pentaho.logging_database.vendor"),
	
	
	/**
	 * Carte Server URL to use for KTR transformation execution.
	 */
	COLFUSION_PENTAHO_CARTE_URL ("colfusion.pentaho.carte.url"),
	COLFUSION_PENTAHO_CARTE_HOST ("colfusion.pentaho.carte.host"),
	COLFUSION_PENTAHO_CARTE_PORT ("colfusion.pentaho.carte.port"),
	COLFUSION_PENTAHO_CARTE_USER ("colfusion.pentaho.carte.username"),
	COLFUSION_PENTAHO_CARTE_PASSWORD ("colfusion.pentaho.carte.password"),
	
	COLFUSION_PROCESS_MANAGER_MAX_CONCURRENT_PROCESSES ("colfusion.process_manager.max_concurrent_processes"),
	
	/*Appended by Hao Bai
	 * This value is used for setting timeout for connecting services 
	 * in ServiceMonitor.java of colfusionserverservicemonitor project
	*/
	COLFUSION_SERVICE_MONITOR_TIMEOUT ("colfusion.service_monitor.timeout"),
	/*Appended by Hao Bai
	 * This value is used for setting period for monitoring services 
	 * in ServiceMonitorController.java of colfusionserverservicemonitor project
	*/
	COLFUSION_SERVICE_MONITOR_PERIOD ("colfusion.service_monitor.period"),
	/*Appended by Hao Bai
	 * This value is used for setting email sender's address.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SENDER_ADDRESS ("colfusion.service_monitor.email_notification.sender_address"),
	/*Appended by Hao Bai
	 * This value is used for setting email sender's password.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SENDER_PASSWORD ("colfusion.service_monitor.email_notification.sender_password"),
	/*Appended by Hao Bai
	 * This value is used for setting email smtp starttls boolean value.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SMTP_START_TLS_ENABLE ("colfusion.service_monitor.email_notification.smtp.start_tls_enable"),
	/*Appended by Hao Bai
	 * This value is used for setting email smtp authentication boolean value.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SMTP_AUTH ("colfusion.service_monitor.email_notification.smtp.auth"),
	/*Appended by Hao Bai
	 * This value is used for setting email smtp server host.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SMTP_HOST ("colfusion.service_monitor.email_notification.smtp.host"),
	/*Appended by Hao Bai
	 * This value is used for setting email smtp port number.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SMTP_PORT ("colfusion.service_monitor.email_notification.smtp.port"),
	/*Appended by Hao Bai
	 * This value is used for setting email receiver's userLevel.
	*/
	COLFUSION_SERVICE_MONITOR_EMAIL_NOTIFICATION_SMTP_USER_LEVEL ("colfusion.service_monitor.email_notification.user_level"),
	
	//******* Hibernate properties (don't rename these properties) *************//
	COLFUSION_HIBERNATE_CONNECTION_DRIVER_CLASS ("colfusion.hibernate.connection.driver_class"),
	
	COLFUSION_HIBERNATE_CONNECTION_URL ("colfusion.hibernate.connection.url"),
	
	COLFUSION_HIBERNATE_DEFAULT_CATALOG ("colfusion.hibernate.default_catalog"),
	
	COLFUSION_HIBERNATE_CONNECTION_USERNAME ("colfusion.hibernate.connection.username"),
			
	COLFUSION_HIBERNATE_CONNECTION_PASSWORD ("colfusion.hibernate.connection.password"),
	
	COLFUSION_HIBERNATE_DIALECT ("colfusion.hibernate.dialect"),
	
	COLFUSION_HIBERNATE_HBM2DDL_AUTO ("colfusion.hibernate.hbm2ddl.auto"),
	
	COLFUSION_HIBERNATE_CONNECTION_ZERO_DATE_TIME_BEHAVIOR ("colfusion.hibernate.connection.zeroDateTimeBehavior"),
		
	COLFUSION_HIBERNATE_C3P0_MIN_SIZE ("colfusion.hibernate.c3p0.min_size"),
	
	COLFUSION_HIBERNATE_C3P0_MAX_SIZE ("colfusion.hibernate.c3p0.max_size"),
	
	COLFUSION_HIBERNATE_C3P0_TIMEOUT ("colfusion.hibernate.c3p0.timeout"),
	
	COLFUSION_HIBERNATE_C3P0_MAX_STATEMENTS ("colfusion.hibernate.c3p0.max_statements"),
	
	COLFUSION_HIBERNATE_C3P0_IDLE_TEST_PERIOD ("colfusion.hibernate.c3p0.idle_test_period"),
	
	COLFUSION_HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS ("colfusion.hibernate.current_session_context_class"),
	
	COLFUSION_HIBERNATE_SHOW_SQL ("colfusion.hibernate.show_sql"),
	
	COLFUSION_HIBERNATE_FORMAT_SQL ("colfusion.hibernate.format_sql"),
	
	//***** END OF HIBERNATE PROPERTIES *****************//

	COLFUSION_OPENREFINE_URL ("colfusion.openrefine.url"),	
	
	COLFUSION_OPENREFINE_FOLDER ("colfusion.openrefine.folder"),

	COLFUSION_OPENREFINE_FOLDER_TEMP ("colfusion.openrefine.folder.temp"),
	
	COLFUSION_OPENREFINE_LOCK_TIME ("colfusion.openrefine.lock_time"),
	
	COLFUSION_OPENREFINE_NOTICE_TIME ("colfusion.openrefine.notice_time"),
	
	COLFUSION_OPENREFINE_CSV_FILE_DIR ("colfusion.openrefine.csv_file_dir"),
	
	COLFUSION_OPENREFINE_CSV_FILE_NAME ("colfusion.openrefine.csv_file_name"),
	
	/**
	 * The system property that can be passed to JVM that provides absolute path to the
	 * properties file that need to be loaded. 
	 * This file's properties will override {@value #CONFIG_FILE_NAME} properties. 
	 */
	CONFIG_FILE_NAME_SYSTEM_PROPERTY ("colfusion.config.properties"),
	
	/* Docker properties */
	COLFUSION_DOCKER_VERSION ("colfusion.docker.version"),
	
	COLFUSION_DOCKER_URI ("colfusion.docker.uri"),
	
	COLFUSION_DOCKER_SERVER_ADDRESS ("colfusion.docker.server_address"),
	
	COLFUSION_DOCKER_CERT_PATH ("colfusion.docker.cert_path");

	private final String propertyKey;
	
	PropertyKeys(final String propertyKey) {
		this.propertyKey = propertyKey;
	}
	
	@Override
	public String getKey() {
		return propertyKey;
	}
	
	/**
	 * Get the subset of the properties that have specified prefix.
	 * 
	 * @param propertiesKeysPrefix
	 * 		the property keys prefix
	 * @return all properties that have specified prefix.
	 */
	public static Set<PropertyKeys> getPropertiesForPrefix(
			final String propertiesKeysPrefix) {
		Pattern pattern = Pattern.compile("^"+ Pattern.quote(propertiesKeysPrefix)); // strings that start with given prefix
		
		Set<PropertyKeys> result = new HashSet<PropertyKeys>();
		//TODO: once we update to java 8, this is a good candidate for lamdas
		for (PropertyKeys propertyKey : PropertyKeys.values()) {
			Matcher matcher = pattern.matcher(propertyKey.getKey());
			
			if (matcher.find()) {
				result.add(propertyKey);
			}
		}
		
		return result;
	}
}

