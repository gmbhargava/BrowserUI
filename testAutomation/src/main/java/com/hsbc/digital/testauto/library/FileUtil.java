package com.hsbc.digital.testauto.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.sun.jna.platform.FileUtils;

/*
 * <p>
 * <b> this is class is used for reading files and return its data in different 
 * 
 * format.<br>
 * it includes reading of files like properties,excel etc.</b>
 * </p>
 * @version 1.0.0
 * 
 */
public class FileUtil {
	/*
	 * property file path for environment configuration declared.
	 */
//	public static final String PROPERTY_FILE_PATH="src/main/resource/projectenvconfig/";
	public static final String PROPERTY_FILE_PATH="D:\\eclipse\\workspace\\testAutomation\\src\\main\\resources\\projectenvconfig\\";
	
	public static final String PROFILE_FILE_PATH="src/main/resource/projectenvconfig";
	public static final org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(FileUtils.class);
	
	private FileUtil() {
		
	}
	
	/*
	 * Method for reading config file for environment based on given Entity.
	 * 
	 * @param entity
	 * @return Key/Value pair from property file.
	 */
	
	
	public static Map<String,String> getconfigproperties(final String entity){
		return readProperties(FileUtil.PROPERTY_FILE_PATH + entity + ".properties" );
	}
	
	
	public static Map<String,String> getconfigpropertiesEnv(final String entity,final String env){
		return readProperties(FileUtil.PROPERTY_FILE_PATH + entity + "_" + ".properties" );
	}
	
	
	/*
	 * generic method to read any property file from any loaction within
	 * project for given path
	 * 
	 * @param path:path of properties file
	 * 
	 * @return Key/value pair from properties file.
	 
	 * 
	 */
	
	
	public static Map<String,String> readProperties(final String path){
		Properties prop= new Properties();
		Map<String,String> propMap =new HashMap<String,String>();
		InputStream input = null;
		try{
			input=new FileInputStream(path);
			prop.load(input);
		}catch(IOException e){
			FileUtil.logger.error("Exception at read properties",e);
		}
		for (Entry<Object,Object> entries: prop.entrySet()){
			propMap.put((String) entries.getKey(), (String) entries.getValue());
		}
		return propMap;
		
	}
	
	
	//input=new FileInputStream("D:\\eclipse\\workspace\\testAutomation\\src\\main\\resources\\projectenvconfig\\us.properties");
	/*
	 * Generic method to write any property file from any location within
	 * 
	 * project for given path.
	 * 
	 * @param path :path of properties file.  :properties
	 * 
	 * @return void
	 */

	
	public static void writeProperties(final String path,final Map<String,String> properties){
		Properties prop= new Properties();
		FileOutputStream  out = null;
		try{
			out =new FileOutputStream(path);
			prop.putAll(properties);
			prop.store(out, null);
			out.close();
		}catch(IOException e){
			FileUtil.logger.error("Exception at readProperties:",e);
			
		}
	}
	
	
	/*
	 * Method to get Test Data for Profile from property file based on profile
	 * and location of file
	 * 
	 * @return Key/value pair from properties file based on given profile
	 * 
	 */
	
	
	public static Map<String,String> getTestDataproperties(final String entity){
		return readProperties(FileUtil.PROFILE_FILE_PATH + File.separator + entity +".properties");
	}
	
//	public static Map<String,String> getTestDataproperties(final String entity,final String profile){
//		return readProperties(FileUtil.PROFILE_FILE_PATH + entity +File.separator +profile +".properties");
//	}
	
	/*
	 * Method to set Test Data for Profile from property file based on profile
	 * and location of file
	 * 
	 * @return void
	 */
	
	
	public static void setTestDataproperties(final String entity, final String profile,final Map<String,String> properties){
		writeProperties(FileUtil.PROFILE_FILE_PATH + entity + File.separator + profile + ".properties",properties);
	}
	
	
}
