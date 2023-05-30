package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CommonUtilTest {

	@ParameterizedTest
	@Order(1)
	@ValueSource(strings = {"", "  ", "\t", "\n"})
	public void isNullStringsTrue(String x) {
		
		assertTrue(CommonUtil.isNull(x));
	}
	
	@ParameterizedTest
	@Order(1)
	@NullSource
	public void isNullTrue(Object x) {
		
		assertTrue(CommonUtil.isNull(x));
	}

	@ParameterizedTest
	@Order(2)
	@ValueSource(strings = {"1"})
	public void isNullStringsFalse(String x) {
		
		assertFalse(CommonUtil.isNull(x));
	}
	
	@ParameterizedTest
	@Order(2)
	@ValueSource(longs = {0,1,2L})
	public void isNullLongsFalse(long x) {
		
		assertFalse(CommonUtil.isNull(x));
	}
	
	@ParameterizedTest
	@Order(2)
	@ValueSource(booleans = {true,false})
	public void isNullBooleansFalse(boolean x) {
		
		assertFalse(CommonUtil.isNull(x));
	}
	
	@Test
	@Order(2)
	public void isNullObjectsFalse() {
		Object[] arr = new Object[] {new Object(), new Object[] {}};
		
		for (Object x : arr) {
			assertFalse(CommonUtil.isNull(x));
		}
	}
	
	@Test
	@Order(3)
	public void lpadTest() {
		assertEquals("000123", CommonUtil.lpad("123", 6, "0"));
		assertEquals("123456", CommonUtil.lpad("123456", 6, "0"));
		assertEquals("123456", CommonUtil.lpad("1234567", 6, "0"));
	}
	
	@Test
	@Order(4)
	public void rpadTest() {
		assertEquals("123***", CommonUtil.rpad("123", 6, "*"));
		assertEquals("123456", CommonUtil.rpad("123456", 6, "#"));
		assertEquals("123456", CommonUtil.rpad("1234567", 6, "@"));
	}
	
}

class CustomOrder implements MethodOrderer {

	@Override
	public void orderMethods(MethodOrdererContext context) {
		context.getMethodDescriptors().sort(
				(MethodDescriptor m1, MethodDescriptor m2) ->
				m2.getMethod().getName().compareToIgnoreCase(m1.getMethod().getName()));
	}
}
