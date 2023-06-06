package com.doo.skeleton.config.message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

//	@Bean
//    public LocaleResolver defaultLocaleResolver() {
//        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//        localeResolver.setDefaultLocale(Locale.KOREAN);
//
//        log.info("localeResolver Bean Created.");
//        return localeResolver;
//    }
	
	@Bean
	public MessageSource messageSource(){
		
		Locale.setDefault(Locale.ROOT); // 제공하지 않는 언어로 들어왔을 때 처리
		
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames(
	    		"classpath:/messages/messages",
	    		"classpath:/messages/messages_en",
	    		"classpath:/messages/messages_ko"
	    		);  //basename 설정
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(5);  //메시지 소스 캐시하는 최대 시간(초) 설정
	    
	    return messageSource;
	}
	
//	@Bean
//    public MessageSourceAccessor messageSourceAccessor (
//            @Autowired ReloadableResourceBundleMessageSource messageSource) {
//        return new MessageSourceAccessor(messageSource);
//    }
}
