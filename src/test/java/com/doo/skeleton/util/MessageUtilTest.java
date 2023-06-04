package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageUtilTest {

	@Autowired
	private MessageUtil messageUtil;
	
	@Test
	public void getmessage() throws Exception {
		
		assertEquals(messageUtil.getMessage("onlydefault", new String[]{"java1"}, null), 	"onlyDefault java1");
		assertEquals(messageUtil.getMessage("all", new String[]{"java1"}, null), 			"ko java1");
		assertEquals(messageUtil.getMessage("all", new String[]{"java1"}, Locale.KOREA), 	"ko java1");
		assertEquals(messageUtil.getMessage("all", new String[]{"java1"}, Locale.US), 		"en java1");
		assertEquals(messageUtil.getMessage("all", new String[]{"java1"}, Locale.ENGLISH), 	"en java1");
	}
}
