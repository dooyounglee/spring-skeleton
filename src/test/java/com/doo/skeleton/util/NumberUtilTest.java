package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberUtilTest {

	@Test
	public void round_0_digit_Test() {
		
		assertEquals(NumberUtil.round(123.1,0), 123);
		assertEquals(NumberUtil.round(123.4,0), 123);
		assertEquals(NumberUtil.round(123.5,0), 124);
		assertEquals(NumberUtil.round(123.6,0), 124);
	}
	
	@Test
	public void round_minus1_digit_Test() {
		
		assertEquals(NumberUtil.round(123.1,-1), 120);
		assertEquals(NumberUtil.round(124.4,-1), 120);
		assertEquals(NumberUtil.round(125.5,-1), 130);
		assertEquals(NumberUtil.round(126.6,-1), 130);
	}
	
	@Test
	public void round_minus2_digit_Test() {
		
		assertEquals(NumberUtil.round(123.113,-2), 100);
		assertEquals(NumberUtil.round(124.414,-2), 100);
		assertEquals(NumberUtil.round(125.515,-2), 100);
		assertEquals(NumberUtil.round(126.616,-2), 100);
	}
	
	@Test
	public void round_1_digit_Test() {
		
		assertEquals(NumberUtil.round(123.13,1), 123.1);
		assertEquals(NumberUtil.round(124.44,1), 124.4);
		assertEquals(NumberUtil.round(125.55,1), 125.6);
		assertEquals(NumberUtil.round(126.66,1), 126.7);
	}
	
	@Test
	public void round_2_digit_Test() {
		
		assertEquals(NumberUtil.round(123.113,2), 123.11);
		assertEquals(NumberUtil.round(124.414,2), 124.41);
		assertEquals(NumberUtil.round(125.515,2), 125.52);
		assertEquals(NumberUtil.round(126.616,2), 126.62);
	}
	
	@Test
	public void ceilTest() {
		assertEquals(NumberUtil.ceil(123.456, -3), 1000);
		assertEquals(NumberUtil.ceil(123.456, -2), 200);
		assertEquals(NumberUtil.ceil(123.456, -1), 130);
		assertEquals(NumberUtil.ceil(123.456,  0), 124);
		assertEquals(NumberUtil.ceil(123.456,  1), 123.5);
		assertEquals(NumberUtil.ceil(123.456,  2), 123.46);
		assertEquals(NumberUtil.ceil(123.456,  3), 123.456);
	}
	
	@Test
	public void floorTest() {
		assertEquals(NumberUtil.floor(123.456, -3), 0);
		assertEquals(NumberUtil.floor(123.456, -2), 100);
		assertEquals(NumberUtil.floor(123.456, -1), 120);
		assertEquals(NumberUtil.floor(123.456,  0), 123);
		assertEquals(NumberUtil.floor(123.456,  1), 123.4);
		assertEquals(NumberUtil.floor(123.456,  2), 123.45);
		assertEquals(NumberUtil.floor(123.456,  3), 123.456);
	}
}
