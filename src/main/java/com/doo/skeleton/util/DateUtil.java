package com.doo.skeleton.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static String format(LocalDate date, String format) {
		return date.format(DateTimeFormatter.ofPattern(format));
	}
	
	public static String format(LocalDateTime date, String format) {
		return date.format(DateTimeFormatter.ofPattern(format));
	}
	
	public static String now(String format) {
		return format(LocalDateTime.now(), format);
	}
	
	public static LocalDate string2Date(String date, String format) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}
	
	public static LocalDateTime string2Time(String date, String format) {
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
	}
}
