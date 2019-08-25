package com.securtime_mobileapi_testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;

public class TC002_Get_PasswordRules extends TestBase{
	
	public boolean getApiURI(){
		return false;
	}
	
	@BeforeClass
	void getMobilePwdRules() throws InterruptedException{
		response = httpRequest.request(Method.GET,"/api/mobile/login/getmobilepwdrules");
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody(){
	   String responseBody=response.getBody().asString();
	   System.out.println(responseBody);
	}
	
	@Test
	void checkStatusCode(){
	   int statusCode=response.getStatusCode();
	   Assert.assertEquals(statusCode, 200);
	   
	}

}
	