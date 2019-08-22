package com.securtime_saxapi_testcases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;
import junit.framework.Assert;

public class TC001_Get_Daily_Performance_Data extends TestBase{
	
	
	@BeforeClass
	public void getPerformanceData() throws Exception{
	response = httpRequest.request(Method.GET,"/api/processed-data/daily-performance?startDate=2019-08-08&endDate=2019-08-08");
	Thread.sleep(3000);	
	}
	
	
	
	@Test(priority=1)
	void checkResponseBody(){
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
	}
	
	@Test(priority=2)
	void checkStatusCode(){
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test(priority=3)
	void checkResponseTime(){
		long responseTime=response.getTime();
		System.out.println(responseTime);
	}
	
	@Test(priority=4)
	void checkContentType(){
		String contentType=response.header("content-type");
		Assert.assertEquals(contentType, "application/json;charset=UTF-8");
	}
	
	@Test(priority=5)
	void checkContentEncoding(){
		String contentEncoding=response.header("content-encoding");
		Assert.assertEquals(contentEncoding,"gzip");
	}
	
	@AfterClass
	void TearDown() throws InterruptedException
	{
		Thread.sleep(3000);
	}

}
