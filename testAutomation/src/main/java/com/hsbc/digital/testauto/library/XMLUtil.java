package com.hsbc.digital.testauto.library;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;

import com.hsbc.digital.testauto.exceptions.MappingXMLPrasingException;


/*
 * 
 * <p>
 * <b> Class to read data from XML and get required information.</b>
 * </p>
 */

public class XMLUtil {
	
	private static DocumentBuilderFactory buliderFactory = DocumentBuilderFactory.newInstance();
	private static final String PROFILE_MAPPING_XML ="profileMapping.xml";
	private static final String MAPPING_XML_PATH="src/main/resource";
	private static final String MAPPING_XML_ENTITY_PATH="src/main/resource/projecttestdata";
	private static final String MAPPING_EXP ="/TESTSCRIPT//TESTCLASS[@NAME='s']//METHOD[@NAME='%s']//ENTITY_PROFILE[@NAME='%s']/@PROFILE";
	private static final String MAPPING_EXP_ENV_EXP ="/TESTSCRIPT//TESTCLASS[@NAME='s']//METHOD[@NAME='%s']//ENTITY_PROFILE[@ENV='%s']/@PROFILE";
	private static final String MAPPING_EXP_TYPE ="/TESTSCRIPT//TESTCLASS[@NAME='s']//METHOD[@NAME='%s']/@EXE-TYPE";
	public static final org.apache.log4j.Logger logger =org.apache.log4j.Logger.getLogger(XMLUtil.class);
	
	public XMLUtil() {
	
	}
	
	private static Document getXMLDocument(final File xmlFile) throws MappingXMLPrasingException {
	Document xmlDocument = null;
	try {
		xmlDocument = (Document) XMLUtil.buliderFactory.newDocumentBuilder().parse(xmlFile);
	}catch(SAXException | IOException | ParserConfigurationException e) {
		logger.error("Exception throw at mapping xml parsing:",e);
		throw new MappingXMLPrasingException(e);
	}
	return xmlDocument;		
	}
	
	
	
	/*
	 * <p>
	 * <b> 
	 * @deprecated This method will removed.replace it by
	 * {@link XMLUtil#getProfileName(Method,String,String}</b>
	 * </p>
	 * @param method
	 * @param entity
	 * @param env
	 * @return
	 * @throws MappingXMLParsingException
	 * 
	 */
	@Deprecated
	public static String getProfileName(final Method method,final String entity ) throws MappingXMLPrasingException{
		Document xmlDocument=getXMLDocument(new File(XMLUtil.MAPPING_XML_PATH + "/" + entity + "/" + XMLUtil.PROFILE_MAPPING_XML));
		return getProfileName(method,entity,xmlDocument);
	}
	
	
	
	public static String getProfileName(final Method method,final String entity,final String env)
		throws MappingXMLPrasingException{
			Document xmlDocument=getXMLDocument(new File(XMLUtil.MAPPING_XML_PATH + "/" + entity + "/" + XMLUtil.PROFILE_MAPPING_XML));
			return getProfileNameForEnv(method,entity,xmlDocument,env); 	
		}
	
	
	public static String getProfileName(final Method method,final String entity ,final Document xmlDocument) throws MappingXMLPrasingException{
		XPath xPath = XPathFactory.newInstance().newXPath();
		try{
			return xPath
					.compile(String.format(XMLUtil.MAPPING_EXP, method.getDeclaringClass().getName(),method.getName(),entity))
					.evaluate(xmlDocument);
		}catch (XPathExpressionException e){
			logger.error("Exception thows at mapping xml xapth evaluation getprofileName:",e);
			throw new MappingXMLPrasingException(e);
		}
	}
	
	public static String getProfileNameForEnv(final Method method,final String entity,final Document document,final String env) throws MappingXMLPrasingException{
		XPath xPath = XPathFactory.newInstance().newXPath();
		return getXMLAttributeValue(xPath,XMLUtil.MAPPING_EXP_ENV_EXP,document,method,entity,env);
	}
	
	
	
	
	private static String getXMLAttributeValue(final XPath xpath,final String mappingExpression,final Document document,final Method method,
			final String entity,final String env) throws MappingXMLPrasingException{
		try{
			return xpath.compile(String.format(mappingExpression, method.getDeclaringClass().getName(),method.getName(),env))
					.evaluate(document);
		}catch (XPathExpressionException XPathExpressionException){
			logger.error("Exception thows at mapping xml xapth evaluation getprofileName:",XPathExpressionException);
			throw new MappingXMLPrasingException(XPathExpressionException);
		}	
	}
	
	
	public static Document getProfileMappingXML(final String entity) throws MappingXMLPrasingException{
		return getXMLDocument(new File(XMLUtil.MAPPING_XML_PATH + "/" + XMLUtil.PROFILE_MAPPING_XML));
	}
	
	public static Document getProfileMappingXMLNew(final String entity) throws MappingXMLPrasingException{
		return getXMLDocument(new File(XMLUtil.MAPPING_XML_ENTITY_PATH + "/" + XMLUtil.PROFILE_MAPPING_XML));
	}
	
	
	public static String getMethodExceptionType(final Method method,final String entity,final Document document,final String env) throws MappingXMLPrasingException{
		XPath xPath = XPathFactory.newInstance().newXPath();
		return getXMLAttributeValue(xPath,XMLUtil.MAPPING_EXP_TYPE,document,method,entity,env);

	}
	
	
	
	
	

}
