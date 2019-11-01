package com.api.training.api.assignment_final;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	
	public static String empName() {
		String newString = RandomStringUtils.randomAlphabetic(1);
		return("Ajeet"+newString);
	}
	
	public static String empsal() {
		String newString = RandomStringUtils.randomAlphabetic(5);
		return(newString);
	}
	public static String empAge() {
		String newString = RandomStringUtils.randomAlphabetic(2);
		return(newString);
	}
}
