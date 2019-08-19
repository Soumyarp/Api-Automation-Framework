package com.securtime_api_testcases;

import org.testng.annotations.BeforeClass;

import com.securtime_api_base.TestBase;

import io.restassured.http.Method;

public class TC008_Get_Shift_Roster_data extends TestBase {
	
	@BeforeClass
	void getShiftRosterData(){
		response = httpRequest.request(Method.GET,"/api/processed-data/shift-roster-data?");
	}

}
