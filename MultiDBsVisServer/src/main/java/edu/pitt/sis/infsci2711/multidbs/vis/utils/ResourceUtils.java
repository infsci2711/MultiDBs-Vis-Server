package edu.pitt.sis.infsci2711.multidbs.vis.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;


public class ResourceUtils {
	
	public static InputStream getResourceAsStream(final Class<?> clazz, final String resourceName) {
		return clazz.getClassLoader().getResourceAsStream(resourceName);
	}
	
	public static File getResourceAsFile(final Class<?> clazz, final String resourceName) {
		String resourceFileLocation = getResourceAsFileLocation(clazz, resourceName);
		
		return resourceFileLocation == null ? null : new File(resourceFileLocation);
	}
	
	public static String getResourceAsFileLocation(final Class<?> clazz, final String resourceName) {
		URL resourceFile = clazz.getClassLoader().getResource(resourceName);
		
		return resourceFile == null ? null : resourceFile.getFile();
	}

	public static boolean resourceExists(final Class<?> clazz,
			final String resourceName) {
		URL resourceFile = clazz.getClassLoader().getResource(resourceName);
		
		return resourceFile != null;
	}
	
	public static InputStream getResourceAsStream(final String resourceName) {
		return ResourceUtils.class.getResourceAsStream("/" + resourceName);
	}
	
	public static File getResourceAsFile(final String resourceName) {
		String resourceFileLocation = getResourceAsFileLocation(resourceName);
		
		return resourceFileLocation == null ? null : new File(resourceFileLocation);
	}
	
	public static String getResourceAsFileLocation(final String resourceName) {
		URL resourceFile = ResourceUtils.class.getResource("/" + resourceName);
		
		return resourceFile == null ? null : resourceFile.getFile();
	}

	public static boolean resourceExists(final String resourceName) {
		URL resourceFile = ResourceUtils.class.getResource("/" + resourceName);
		
		return resourceFile != null;
	}
}