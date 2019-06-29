package com.hsbc.digital.testauto.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


/*
 * <p>
 * <b> TODO :insert description of the class's responsibility/role.</b>
 * 
 * </p> 
 */

public class AnnotationTransformer implements IAnnotationTransformer {
	
	/*
	 * (non -javadoc)
	 * 
	 */

	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor, final Method testmethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}
