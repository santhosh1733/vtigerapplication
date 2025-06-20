package com.comcast.crm.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 *  class to implement to be able to have a chance to retry a failed test.
 */
public class Retrylistener implements IRetryAnalyzer{
/**
 * 
 * @return boolean
 * @param ITestResult result
 */
	@Override
	public boolean retry(ITestResult result) {
	int count=0;
	int limit=4;
	if(count<limit) {
		count++;
		return true;
	}
		return false;
	}

}
