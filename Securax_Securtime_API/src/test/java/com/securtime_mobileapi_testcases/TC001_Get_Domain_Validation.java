package com.securtime_mobileapi_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;

public class TC001_Get_Domain_Validation extends TestBase {
	
	public boolean getMobileApiURI(){
		return false;
	}
	
	@BeforeClass
	void getDomain() throws InterruptedException{
		response= httpRequest.request(Method.GET," /login/resources?Url=qa-org");
		Thread.sleep(3000);
	}
	
	
	
	@Test
	void checkResponseBody(){
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}


}
