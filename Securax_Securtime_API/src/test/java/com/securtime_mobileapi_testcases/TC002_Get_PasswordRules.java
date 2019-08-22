package com.securtime_mobileapi_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;

public class TC002_Get_PasswordRules extends TestBase{
	
	
	@BeforeClass
	void getMobilePwdRules() throws InterruptedException{
		response = httpRequest.request(Method.GET,"/login/getMobilePwdRules");
		Thread.sleep(3000);
	}
	public boolean getMobileApiURI(){
		return false;
	}
	
	
	
	@Test
	void checkResponseBody(){
	   String responseBody=response.getBody().asString();
	   System.out.println(responseBody);
	}

}
