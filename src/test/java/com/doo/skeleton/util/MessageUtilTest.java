package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageUtilTest {

	@Test
	public void getmessage() throws Exception {
		
		assertEquals("only java1", MessageUtil.getMessage("only", new String[]{"java1"}, null));
		assertEquals("all java1",  MessageUtil.getMessage("all", new String[]{"java1"}, Locale.JAPANESE));
		assertEquals("ko java1",   MessageUtil.getMessage("all", new String[]{"java1"}, null));
		assertEquals("ko java1",   MessageUtil.getMessage("all", new String[]{"java1"}, Locale.KOREA));
		assertEquals("en java1",   MessageUtil.getMessage("all", new String[]{"java1"}, Locale.US));
		assertEquals("en java1",   MessageUtil.getMessage("all", new String[]{"java1"}, Locale.ENGLISH));
		
		assertEquals("ko1 java1", MessageUtil.getMessage("ko1", new String[]{"java1"}, null));
		assertEquals("ko1 java1", MessageUtil.getMessage("ko1", new String[]{"java1"}, Locale.CANADA));
		assertEquals("ko1 java1", MessageUtil.getMessage("ko1", new String[]{"java1"}, Locale.KOREAN));
		assertEquals("ko1 java1", MessageUtil.getMessage("ko1", new String[]{"java1"}, Locale.ENGLISH));
		
		assertEquals("no", MessageUtil.getMessage("no", new String[]{"java1"}, null));
	}
	
	@Test
	public void getmessage1() throws Exception {
		
		assertEquals("CM-0000",   MessageUtil.getMessageDB("CM-0000", null, null));
		assertEquals("완료했씁니다.", MessageUtil.getMessageDB("CM-0001", null, null));
		assertEquals("하실래요?",    MessageUtil.getMessageDB("CM-0002", null, null));
	}
}
