package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CommonUtilTest {

	@Test
	@Order(1)
	public void isNullTrue() {
		Object[] arr = new Object[] {"", null};
		
		for (Object x : arr) {
			assertTrue(CommonUtil.isNull(x));
		}
	}
	
	@Test
	@Order(2)
	public void isNullFalse() {
		Object[] arr = new Object[] {"1", new Object(), new Object[] {}};
		
		for (Object x : arr) {
			assertFalse(CommonUtil.isNull(x));
		}
	}
	
}
