package com.securtime_saxapi_testcases;
/*
 * Get Leave Balance for the organization
 * */
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;
import junit.framework.Assert;

public class TC005_Get_LeaveBalance extends TestBase {
	
@BeforeClass(alwaysRun=true)
public void getLeaveBalance() throws InterruptedException{
	response=httpRequest.request(Method.GET,"/api/leave-balance");
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
