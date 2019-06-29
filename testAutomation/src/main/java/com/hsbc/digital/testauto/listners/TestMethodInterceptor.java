package com.hsbc.digital.testauto.listners;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import org.apache.commons.lang3.StringUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.hsbc.digital.testauto.library.XMLUtil;


/*
 * <p>
 * <b> this listner will filter test method based on entity and only entity
 * specific methods will be invoked </b>
 * </p> 
 */


public class TestMethodInterceptor implements IMethodInterceptor {
	public static final org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(TestMethodInterceptor.class);
	
	@Override
	public List<IMethodInstance> intercept(final List<IMethodInstance> methods,
			final ITestContext testContext) {
		//String entity = testContext.getSuite().getParameter("entity");
		String entity = System.getProperty("entity");
		String env = System.getProperty("env");
		String group = System.getProperty("testgroup");
		List<IMethodInstance> filteredMethods = new ArrayList<IMethodInstance>();
		try{
			Document document =XMLUtil.getProfileMappingXMLNew(entity);
			for (IMethodInstance methodInstance:methods){
				//String profile =XMLUtil.getProfileName(methodInstance.getMethod().getConstructorOrMethod().getMethod(), entity, document);
				String profile =XMLUtil.getProfileNameForEnv(methodInstance.getMethod().getConstructorOrMethod().getMethod(), entity, document,env);
				String methodExetype = XMLUtil
						.getMethodExceptionType(methodInstance.getMethod().getConstructorOrMethod().getMethod(), entity, document, env);
				if(StringUtils.isNotEmpty(profile) && methodExetype.contains(group)){
					filteredMethods.add(methodInstance);
				}
				
			}
					
		}catch(Exception e){
			TestMethodInterceptor.logger.error("Exception thrown at method interceptor:", e);
		}
		return filteredMethods;
	}
	

}
