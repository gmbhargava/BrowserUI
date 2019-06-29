package com.hsbc.digital.testauto.library;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;;



/*
 * <p>
 * <b> Utility class to instantiate Object of page Model for given
 * entity and pom name.</b>
 * </p>
 * 
 * 
 */
public class ReflectionUtil {
	
	/*
	 * 
	 * Variable to declare Base package for all pom model class.
	 * 
	 */
	public static final String BASE_PACKAGE="com.hsbc.digital.testauto.pageObject";
	private ReflectionUtil(){
		
	}
	
	/*
	 * Method to instantiate and get object of desire POM Model based on entity and pom Name.
	 * 
	 * @param entity
	 * @param pomName
	 * @param driver
	 * @return POM Object 
	 * @throws ClassNotFoundException
	 * @throws instantiationException
	 * @throws IllegaArgumentException
	 * @throw InvocationTargetException
	 *  
	 */
	
	
	public static Object getEntityPOM(final String pomName,final WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		{
			Class<?> customPomClass =Class.forName(ReflectionUtil.BASE_PACKAGE + "." + pomName);
			Constructor<?> pomConstructor =customPomClass.getConstructor(WebDriver.class);
			return pomConstructor.newInstance(driver);
			}
		
//	public static Object getEntityPOM(final String entity,final String pomName,final WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//			{
//				Class<?> customPomClass =Class.forName(ReflectionUtil.BASE_PACKAGE + entity + "." +pomName);
//				Constructor<?> pomConstructor =customPomClass.getConstructor(WebDriver.class);
//				return pomConstructor.newInstance(driver);
//			}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
