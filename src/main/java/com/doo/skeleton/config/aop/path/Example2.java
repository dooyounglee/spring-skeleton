package com.doo.skeleton.config.aop.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.config.exception.BusinessException;

@RestController
public class Example2 {

	@RequestMapping("/config/aop/example2")
	public int methodNm(@RequestParam("a") String param1, @RequestParam("b") int param2) throws BusinessException {
		return 1;
	}
}
