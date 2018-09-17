package com.qa.Homepage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTestCase {

	@Test
	public void test() {
		System.out.println("Failed Test Case");
		Assert.assertTrue(true);
	}
}
