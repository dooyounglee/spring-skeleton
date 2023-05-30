package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DateUtilTest {

	@Test
	public void formatDateTest() {
		
		LocalDate today = LocalDate.now();
		assertEquals(
				NumberUtil.lpad(today.getYear(), 4)  + "" +
		        NumberUtil.lpad(today.getMonthValue(), 2)  + "" +
				NumberUtil.lpad(today.getDayOfMonth(), 2),
				DateUtil.format(LocalDate.now(), "YYYYMMdd"));
	}
	
	@Test
	public void formatDateTimeTest() {
		
		LocalDateTime now = LocalDateTime.now();
		assertEquals(
				NumberUtil.lpad(now.getYear(), 4) + "" +
				NumberUtil.lpad(now.getMonthValue(), 2) + "" +
				NumberUtil.lpad(now.getDayOfMonth(), 2) + " " +
				NumberUtil.lpad(now.getHour(), 2) + ":" +
				NumberUtil.lpad(now.getMinute(), 2) + "",
				DateUtil.format(LocalDateTime.now(), "yyyyMMdd HH:mm"));
	}
	
	@Test
	public void nowDateTest() {
		
		LocalDate today = LocalDate.now();
		assertEquals(
				NumberUtil.lpad(today.getYear(), 4)  + "" +
	            NumberUtil.lpad(today.getMonthValue(), 2)  + "" +
			    NumberUtil.lpad(today.getDayOfMonth(), 2),
			    DateUtil.now("YYYYMMdd"));
	}
	
	@Test
	public void nowDateTimeTest() {
		
		LocalDateTime now = LocalDateTime.now();
		assertEquals(
				NumberUtil.lpad(now.getYear(), 4) + "" +
				NumberUtil.lpad(now.getMonthValue(), 2) + "" +
				NumberUtil.lpad(now.getDayOfMonth(), 2) + " " +
				NumberUtil.lpad(now.getHour(), 2) + ":" +
				NumberUtil.lpad(now.getMinute(), 2) + "",
				DateUtil.now("yyyyMMdd HH:mm"));
	}
	
	@Test
	public void parseDateTest() {
		
		String date = "20200530";
		String format = "yyyyMMdd";
		
		assertEquals(2020, DateUtil.string2Date(date, format).getYear());
		assertEquals(5,    DateUtil.string2Date(date, format).getMonthValue());
		assertEquals(30,   DateUtil.string2Date(date, format).getDayOfMonth());
	}
	
	@Test
	public void parseDateTimeTest() {
		
		String date = "20200530 15:45";
		String format = "yyyyMMdd HH:mm";
		
		assertEquals(2020, DateUtil.string2Time(date, format).getYear());
		assertEquals(5,    DateUtil.string2Time(date, format).getMonthValue());
		assertEquals(30,   DateUtil.string2Time(date, format).getDayOfMonth());
		assertEquals(15,   DateUtil.string2Time(date, format).getHour());
		assertEquals(45,   DateUtil.string2Time(date, format).getMinute());
	}
}
