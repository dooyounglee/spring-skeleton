package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageUtilTest {

	@Test
	public void getmessage() throws Exception {
		
		assertEquals(MessageUtil.getMessage("onlydefault", new String[]{"java1"}, null), 	"onlyDefault java1");
		assertEquals(MessageUtil.getMessage("all", new String[]{"java1"}, null), 			"ko java1");
		assertEquals(MessageUtil.getMessage("all", new String[]{"java1"}, Locale.KOREA), 	"ko java1");
		assertEquals(MessageUtil.getMessage("all", new String[]{"java1"}, Locale.US), 		"en java1");
		assertEquals(MessageUtil.getMessage("all", new String[]{"java1"}, Locale.ENGLISH), 	"en java1");
	}
	
	@Test
	public void getmessage1() throws Exception {
		
		assertEquals(MessageUtil.getMessageDB("CM-0001", null, null), "완료했씁니다.");
		assertEquals(MessageUtil.getMessageDB("CM-0002", null, null), "하실래요?");
	}
}
