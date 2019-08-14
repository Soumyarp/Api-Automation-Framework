package com.securtime_api_utility;

import org.apache.commons.lang3.RandomStringUtils;

public class EmployeeUtils {
	
	public static String empName(){
		String generatedEmp=RandomStringUtils.randomNumeric(3);
		return("APITEST"+generatedEmp);
	}
	
	public static String empID(){
		String generatedEmpid= RandomStringUtils.randomNumeric(6);
		return generatedEmpid;
	}
	
	public static String enrollID(){
		String generatedEnrollid= RandomStringUtils.randomNumeric(6);
		return generatedEnrollid;
	}


}
