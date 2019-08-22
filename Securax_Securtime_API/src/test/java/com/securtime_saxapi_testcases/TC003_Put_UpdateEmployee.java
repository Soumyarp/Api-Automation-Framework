package com.securtime_saxapi_testcases;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;
import com.securtime_api_utility.EmployeeUtils;

import io.restassured.http.Method;

public class TC003_Put_UpdateEmployee extends TestBase {
	
	@BeforeClass
	void updateEmployee() throws InterruptedException{
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("affiliateName", property.getProperty("affiliatename"));
		requestParams.put("branchName",property.getProperty("branchname") );
		requestParams.put("dateOfJoining",property.getProperty("dateOfJoining"));
		requestParams.put("dateOfBirth", property.getProperty("dateOfBirth"));
		requestParams.put("departmentName", property.getProperty("departmentname"));
		requestParams.put("employeeName", EmployeeUtils.empName());
		requestParams.put("employeeId", property.getProperty("employeeId"));
		requestParams.put("enrollmentId", EmployeeUtils.enrollID());
		requestParams.put("gender",property.getProperty("gender"));
		requestParams.put("roleName",property.getProperty("rolename"));
		requestParams.put("employmentStatus", property.getProperty("employmentStatus"));
		
		httpRequest.body(requestParams.toJSONString());
		response =httpRequest.request(Method.PUT,"/api/employee/update");
		Thread.sleep(10000);
		
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
	
	@AfterClass
	void TearDown() throws InterruptedException
	{
		Thread.sleep(3000);
	}

	
	
}
