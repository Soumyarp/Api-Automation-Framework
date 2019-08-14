package com.securtime_api_base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Properties property;
	public static Logger logger; 
	
	@BeforeSuite
	public void init(){
		System.out.println("setup initialized");
		setUp();
		String baseURI=property.getProperty("qauri");
		String apiKey= property.getProperty("key");
		String apiValue=property.getProperty("value");
		RestAssured.baseURI=baseURI;
	//	httpRequest= RestAssured.given();
	//	httpRequest = RestAssured.given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("application/json",ContentType.TEXT)));
		httpRequest=RestAssured.given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("application/json", ContentType.TEXT)));
		httpRequest.header("x-apiKey",apiKey);
		httpRequest.header("x-secret",apiValue);
		httpRequest.header("Content-Type","application/json");
		System.out.println("closed");
	}
	public static void setUp(){
		property = new Properties();
		
		try {
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/securtime_api_configproperty/config.properties");
			property.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File Not Found");
			
			/*logger= Logger.getLogger("API");
			PropertyConfigurator.configure("Log4j.properties");
			logger.setLevel(Level.DEBUG);*/
			
		}
		
		
		
	}
	
	

}
