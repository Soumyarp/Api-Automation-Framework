package com.securtime_api_testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;
import com.securtime_api_utility.EmployeeUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC002_Post_CreateEmployee extends TestBase {
	
	@BeforeClass
	void createEmployee() throws InterruptedException{
		
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("affiliateName", property.getProperty("affiliatename"));
		requestParams.put("branchName",property.getProperty("branchname") );
		requestParams.put("dateOfJoining",property.getProperty("dateOfJoining"));
		requestParams.put("dateOfBirth", property.getProperty("dateOfBirth"));
		requestParams.put("departmentName", property.getProperty("departmentname"));
		requestParams.put("employeeName", EmployeeUtils.empName());
		requestParams.put("employeeId", EmployeeUtils.empID());
		requestParams.put("enrollmentId", EmployeeUtils.enrollID());
		requestParams.put("gender",property.getProperty("gender"));
		requestParams.put("roleName",property.getProperty("rolename"));
		
		httpRequest.body(requestParams.toJSONString());
		
		
		
		response=httpRequest.request(Method.POST,"/api/employee");
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
		//Assert.assertEquals(contentEncoding,"gzip");
		Assert.assertEquals(contentEncoding,"nzip");
	}


}
