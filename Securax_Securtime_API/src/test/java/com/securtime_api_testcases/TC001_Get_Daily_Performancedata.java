package com.securtime_api_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;
import junit.framework.Assert;

public class TC001_Get_Daily_Performancedata extends TestBase{
	
	@BeforeClass
	public void getPerformanceData() throws Exception{
	response = httpRequest.request(Method.GET,"/api/processed-data/daily-performance?startDate=2019-08-08&endDate=2019-08-08");
	Thread.sleep(3000);	
	}
	
	@Test
	void checkResponseBody(){
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
	}
	
	@Test
	void checkStatusCode(){
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	void checkResponseTime(){
		long responseTime=response.getTime();
		System.out.println(responseTime);
	}
	
	@Test
	void checkContentType(){
		String contentType=response.header("content-type");
		Assert.assertEquals(contentType, "application/json;charset=UTF-8");
	}
	
	@Test
	void checkContentEncoding(){
		String contentEncoding=response.header("content-encoding");
		Assert.assertEquals(contentEncoding,"gzip");
	}

}
