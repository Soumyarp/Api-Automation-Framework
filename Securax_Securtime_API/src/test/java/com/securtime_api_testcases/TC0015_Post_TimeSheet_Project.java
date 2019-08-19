package com.securtime_api_testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;
import com.securtime_api_utility.EmployeeUtils;

import io.restassured.http.Method;

public class TC0015_Post_TimeSheet_Project extends TestBase {

	@BeforeClass
	void CreateShiftRoster() throws InterruptedException{
		JSONObject requestParams= new JSONObject();
		requestParams.put("affiliateName", property.getProperty("affiliatename"));
		requestParams.put("name", EmployeeUtils.timesheetName());
		
		httpRequest.body(requestParams.toJSONString());
		response =httpRequest.request(Method.POST,"/api/timesheet-project");
		
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	void checkResponseBody(){
		String responseBody = response.getBody().asString();
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
	
}
